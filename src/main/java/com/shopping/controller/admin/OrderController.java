package com.shopping.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.dto.OrderDTO;
import com.shopping.service.IOrderService;

@Controller(value = "orderControllerOfAdmin")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	
	@RequestMapping(value = "/quan-tri/mua-hang/danh-sach", method = RequestMethod.GET )
	public ModelAndView showList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/order/orderlist");
		OrderDTO order = new OrderDTO();
		order.setListResult(orderService.getAll());
		mav.addObject("order", order);
		return mav;
	}

}
