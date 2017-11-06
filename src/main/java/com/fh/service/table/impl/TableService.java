package com.fh.service.table.impl;

import com.fh.dao.DaoSupport;
import com.fh.entity.table.Table;
import com.fh.service.table.TableManager;
import com.fh.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 桌号管理service实现类
 *
 * @author Administrator ON 2017/11/4
 **/
@Service("tableService")
public class TableService implements TableManager{
    @Resource(name = "daoSupport")
    private DaoSupport dao;
    @Override
    public void save(Table table) throws Exception {
        dao.save("tableMapper.save", table);
    }
    @Override
    public void delete(Table table) throws Exception {
        dao.delete("tableMapper.delete", table);
    }
    @Override
    public void update(Table table) throws Exception {
        dao.update("tableMapper.update", table);
    }
    @Override
    public Table findForId(String id) throws Exception {
        return (Table) dao.findForObject("tableMapper.findForId", id);
    }
    @Override
    public List<PageData> findList(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("tableMapper.findList", pd);
    }
    @Override
    public List<PageData> findForTableID(String TABLE_ID) throws Exception {
        return (List<PageData>) dao.findForObject("tableMapper.finForTableID", TABLE_ID);
    }
}
