package com.fh.service.column;

import java.util.List;

import com.fh.entity.column.Column;

public interface ColumnManager {
	
	public List<Column> findList(Column column);
	public Column findColumn(String id);
	public void addColumn(Column column);
	public void deleteColumn(String id);
	public void updateColumn(Column column);
	
}
