package com.fh.service.table;

import com.fh.entity.order.Order;
import com.fh.entity.table.Table;
import com.fh.util.PageData;

import java.util.List;

/**
 * 桌号管理service
 *
 * @author Administrator
 **/
public interface TableManager {
    void save(Table table) throws Exception;
    void delete(Table table) throws Exception;
    void update(Table table) throws Exception;
    Table findForId(String id) throws Exception;
    List<PageData> findList(PageData pd) throws Exception;
    List<PageData> findForTableID (String TABLE_ID) throws Exception;
}
