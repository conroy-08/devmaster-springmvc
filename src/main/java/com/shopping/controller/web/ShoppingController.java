package com.shopping.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dto.CartDTO;
import com.shopping.dto.CartInfoDTO;
import com.shopping.dto.CustomerDTO;
import com.shopping.dto.ProductDTO;
import com.shopping.service.IOrderService;
import com.shopping.service.IProductService;

@Controller(value = "shoppingControllerOfWeb")
public class ShoppingController {

	@Autowired
	private IProductService productService;

	@Autowired
	private IOrderService orderService;

	@RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
	public ModelAndView shoppingCart() {
		ModelAndView mav = new ModelAndView("web/mycart");
		return mav;
	}

	@RequestMapping(value = { "/addCart" })
	public String addCart(HttpServletRequest request, @RequestParam(value = "id", required = false) Long id) {
		List<CartDTO> listCart = (List<CartDTO>) request.getSession().getAttribute("listCart");
		ProductDTO product = null;
		if (listCart == null) {
			listCart = new ArrayList<>();
			product = productService.findOneById(id);
			CartDTO cart = new CartDTO(product, 1);
			listCart.add(cart);
		} else {
			boolean check = false;
			for (CartDTO item : listCart) {
				if (item.getProduct().getId().equals(id)) {
					check = true;
					item.setQuantity(item.getQuantity() + 1);
					break;
				}
			}
			if (!check) {
				product = productService.findOneById(id);
				CartDTO cart = new CartDTO(product, 1);
				listCart.add(cart);
			}

		}
		request.getSession().setAttribute("listCart", listCart);
		request.getSession().setAttribute("totalAmout", totalAmount(listCart));
		return "redirect:/shoppingCart";
	}

	public float totalAmount(List<CartDTO> listCart) {
		float totalAmount = 0;
		for (CartDTO cartDTO : listCart) {
			totalAmount += cartDTO.getQuantity() * cartDTO.getProduct().getPrice();
		}
		return totalAmount;
	}

	@RequestMapping(value = "/updateCart")
	public String updateQuantity(HttpServletRequest request) {
		List<CartDTO> listCart = (List<CartDTO>) request.getSession().getAttribute("listCart");
		String[] quantity = request.getParameterValues("quantity");
		for (int i = 0; i < listCart.size(); i++) {
			listCart.get(i).setQuantity(Integer.parseInt(quantity[i]));
		}
		request.getSession().setAttribute("listCart", listCart);
		request.getSession().setAttribute("totalAmout", totalAmount(listCart));
		return "redirect:/shoppingCart";
	}

	@GetMapping(value = "/deleteCart")
	public String deleteCart(HttpServletRequest request, @RequestParam("id") Long id) {

		List<CartDTO> listCart = (List<CartDTO>) request.getSession().getAttribute("listCart");
		for (int i = 0; i < listCart.size(); i++) {
			if (listCart.get(i).getProduct().getId().equals(id)) {
				listCart.remove(i);
				break;
			}
		}
		request.getSession().setAttribute("listCart", listCart);
		request.getSession().setAttribute("totalAmout", totalAmount(listCart));
		return "redirect:/shoppingCart";
	}

	@RequestMapping(value = "/cartConfirm")
	public ModelAndView cartConfirm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/cartConfirm");
		List<CartDTO> listCart = (List<CartDTO>) request.getSession().getAttribute("listCart");
		CustomerDTO customer = new CustomerDTO();
		mav.addObject("customer", customer);
		mav.addObject("listCat", listCart);
		return mav;

	}

	@RequestMapping(value = "/shoppingCartConfirm", method = RequestMethod.POST)
	public String shoppingCartConfirmationSave(HttpServletRequest request,
			@ModelAttribute(name = "customer") CustomerDTO customer) {
		List<CartDTO> listCart = (List<CartDTO>) request.getSession().getAttribute("listCart");
		CartInfoDTO cartInfoDTO = new CartInfoDTO();
		cartInfoDTO.setCustomer(customer);
		cartInfoDTO.setCartDTO(listCart);
		orderService.saveOrder(cartInfoDTO);
		request.getSession().removeAttribute("listCart");
		request.getSession().removeAttribute("totalAmout");
		return "redirect:/shoppingCart";

	}

}
