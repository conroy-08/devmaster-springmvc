package com.shopping.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dto.ProductDTO;
import com.shopping.service.IProductService;
import com.shopping.utils.MessageUtils;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired 
	private MessageUtils messageUtils;
	
	@RequestMapping(value = "/quan-tri/san-pham/danh-sach", method = RequestMethod.GET )
	public ModelAndView showList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/list");
		ProductDTO product = new ProductDTO();
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtils.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}	
		product.setListResult(productService.getAll());
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping(value = "/quan-tri/san-pham/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editProduct(@RequestParam(value = "id" , required = false) Long id  , HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/product/edit");
		ProductDTO product = new ProductDTO();
		if (id != null) {
			product = productService.findOneById(id);
		}
		mav.addObject("model", product);
		return mav;
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam(value ="id") Long id) {
		  productService.deleteProduct(id);
	      return "redirect:/quan-tri/san-pham/danh-sach";
	}
	

}
