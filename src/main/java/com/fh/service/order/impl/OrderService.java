package com.fh.service.order.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.order.Order;
import com.fh.service.order.OrderManager;
import com.fh.util.PageData;

@Service("orderService")
public class OrderService implements OrderManager{
	@Resource(name = "daoSupport")
	private DaoSupport dao;

	public void save(Order order) throws Exception {
		dao.save("orderMapper.save", order);
	}

	public void delete(Order order) throws Exception {
		dao.delete("orderMapper.delete", order);
	}

	public void update(Order order) throws Exception {
		dao.update("orderMapper.update", order);
	}

	public Order findForId(String id) throws Exception {
		return (Order) dao.findForObject("orderMapper.findForId", id);
	}

	public List<PageData> findList(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("orderMapper.findList", pd);
	}
	public List<PageData> findForWeixinID (String WEIXIN_ID) throws Exception {
		return (List<PageData>) dao.findForObject("orderMapper.finForWeixinID", WEIXIN_ID);
	}

}
