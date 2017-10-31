package com.fh.controller.order;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.order.Order;
import com.fh.service.order.impl.OrderService;
import com.fh.util.PageData;


/*
 * 接口
 */
@Controller
@RequestMapping("/orderF")
public class OrderFController extends BaseController {
	@Resource(name="orderService")
	private OrderService orderService;
	
	/*
	 * 通过订单号获取节后
	 * @param id
	 */
	@RequestMapping("")
	public String order(@RequestParam String id) throws Exception {
		ModelAndView md = this.getModelAndView();
		Order order = orderService.findForId(id);
		md.addObject("order", order);
		return null;
	}
	
	/*
	 * 通过用户id，获取当前用户的所有订单信息
	 * @param id
	 */
	@RequestMapping("/orderListForUser")
	public String orderListForUser(@RequestParam String id) throws Exception {
		ModelAndView md = this.getModelAndView();
		PageData pd = this.getPageData();
		List<PageData> orderList = orderService.findForWeixinID(id);
		md.addObject("orderList", orderList);
		return null;
	}
	
	/*
	 * 将菜单页中的已选菜品信息，商户ID，桌号，顾客唯一标识存如session中，绑定并跳转到结算页
	 */
	@RequestMapping("/accout")
	public String account(HttpServletSession session) {
		
		return "";
	}

}
