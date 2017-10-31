package com.fh.entity.column;

import java.util.Date;

public class Column {
	private String COLUMN_ID;  //id
	private String NAME;     //栏目名称
	private String WEIGHT;   //权重
	private Date CREATE_DATE; //创建时间
	public String getCOLUMN_ID() {
		return COLUMN_ID;
	}
	public void setCOLUMN_ID(String cOLUMN_ID) {
		COLUMN_ID = cOLUMN_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getWEIGHT() {
		return WEIGHT;
	}
	public void setWEIGHT(String wEIGHT) {
		WEIGHT = wEIGHT;
	}
	public Date getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(Date cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	

}
