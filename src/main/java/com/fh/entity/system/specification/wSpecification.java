package com.fh.entity.system.specification;

import java.util.Date;

/**
 * 菜品规格表
 * Created by 大梁
 * Created Time 2017/10/25.
 */
public class wSpecification {
    private String SPECIFICATION_ID; //规格ID
    private String NAME; //规格名字
    private String VARIETY_ID; //菜品ID
    private Date CREATE_TIME; //创建时间
    private Date UPDATE_TIME; //更新时间
    private Double PRICE; //单价
    private String SORT; //排序

    public String getSPECIFICATION_ID() {
        return SPECIFICATION_ID;
    }

    public void setSPECIFICATION_ID(String SPECIFICATION_ID) {
        this.SPECIFICATION_ID = SPECIFICATION_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getVARIETY_ID() {
        return VARIETY_ID;
    }

    public void setVARIETY_ID(String VARIETY_ID) {
        this.VARIETY_ID = VARIETY_ID;
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public Date getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Date UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public String getSORT() {
        return SORT;
    }

    public void setSORT(String SORT) {
        this.SORT = SORT;
    }
}
