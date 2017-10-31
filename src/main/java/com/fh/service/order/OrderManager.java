package com.fh.service.order;

import java.util.List;

import com.fh.entity.order.Order;
import com.fh.util.PageData;

public interface OrderManager {
	public void save(Order order) throws Exception;
	public void delete(Order order) throws Exception;
	public void update(Order order) throws Exception;
	public Order findForId(String id) throws Exception;
	public List<PageData> findList(PageData pd) throws Exception;
	public List<PageData> findForWeixinID (String WEIXIN_ID) throws Exception;
}
