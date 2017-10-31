package com.fh.service.column.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.column.Column;
import com.fh.service.column.ColumnManager;

@Service("columnService")
public class ColumnService implements ColumnManager {
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@SuppressWarnings("unchecked")
	public List<Column> findList(Column column) {
		try {
			return (List<Column>) dao.findForList("columnMapper.findList", column);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Column findColumn(String id){
		try {
			return (Column) dao.findForObject("columnMapper.findColumn", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void addColumn(Column column) {
		try {
			dao.save("columnMapper.addColumn", column);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteColumn(String id){
		try {
			dao.delete("columnMapper.deleteColumn", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void updateColumn(Column column) {
		try {
			dao.update("columnMapper.updateColumn", column);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
