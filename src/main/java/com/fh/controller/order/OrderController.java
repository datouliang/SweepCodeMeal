package com.fh.controller.order;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.order.Order;
import com.fh.service.order.impl.OrderService;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

/*
 * 后台订单管理
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Resource(name="orderService")
	private OrderService orderService;
	
	@RequestMapping(value= "")
	public ModelAndView myOrder() throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		List<PageData> orderList = orderService.findList(pd);
		mv.addObject("orderList", orderList);
		mv.addObject("QX", Jurisdiction.getHC());
		mv.setViewName("order/myOrder");
		return mv;
	}
	
	@RequestMapping("/form")
	public ModelAndView form(@RequestParam String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		Order order = orderService.findForId(id);
		mv.addObject("order", order);
		mv.setViewName("order/orderForm");
		return mv;
	}
	
	@RequestMapping(value="/save")
	public String save(HttpServletRequest request) throws Exception {
		Order order = orderService.findForId(request.getParameter("ID"));
		if (order.getID() != "" || order.getID() != null) {
			order.setTOTAL_PRICE(request.getParameter("TOTAL_PRICE"));
			order.setTABLE_NUMBER(request.getParameter("TABLE_NUMBER"));
			orderService.update(order);
		}
		return "redirect:/order";
	}
	
	@RequestMapping("/pay")
	public String pay(@RequestParam String id) throws Exception {
		Order order = orderService.findForId(id);
		order.setSTATUS(Order.PAID);
		orderService.update(order);
		return "redirect:/order";
	}
}
