package com.fh.entity.system.variety;

import java.util.Date;

/**
 * 菜品实体类
 * Created by 大梁
 * Created Time 2017/10/25.
 */
public class wVariety {

    private String VARIETY_ID; //菜品ID
    private String NAME; //菜品名称
    private String COLUMN_ID; //所属分类
    private Date CREATE_TIME; //创建时间
    private Date UPDATE_TIME; //更新时间
    private Double PRICE; //单价
    private String IMAGE; //照片
    private String SORT; //排序
    private String USER_ID; //所属用户ID
    private String INFO; //菜品详情
    private String SPECIFICATION; //规格
    private String SPECIFICATION_ID; //规格ID
    private String SPECIFICATION_NAME; //规格ID
    private String SPECIFICATION_PRICE; //规格ID

    public String getSPECIFICATION_ID() {
        return SPECIFICATION_ID;
    }

    public void setSPECIFICATION_ID(String SPECIFICATION_ID) {
        this.SPECIFICATION_ID = SPECIFICATION_ID;
    }

    public String getSPECIFICATION_NAME() {
        return SPECIFICATION_NAME;
    }

    public void setSPECIFICATION_NAME(String SPECIFICATION_NAME) {
        this.SPECIFICATION_NAME = SPECIFICATION_NAME;
    }

    public String getSPECIFICATION_PRICE() {
        return SPECIFICATION_PRICE;
    }

    public void setSPECIFICATION_PRICE(String SPECIFICATION_PRICE) {
        this.SPECIFICATION_PRICE = SPECIFICATION_PRICE;
    }

    public String getVARIETY_ID() {
        return VARIETY_ID;
    }

    public void setVARIETY_ID(String VARIETY_ID) {
        this.VARIETY_ID = VARIETY_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCOLUMN_ID() {
        return COLUMN_ID;
    }

    public String getSPECIFICATION() {
        return SPECIFICATION;
    }

    public void setSPECIFICATION(String SPECIFICATION) {
        this.SPECIFICATION = SPECIFICATION;
    }

    public void setCOLUMN_ID(String COLUMN_ID) {
        this.COLUMN_ID = COLUMN_ID;
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

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public String getSORT() {
        return SORT;
    }

    public void setSORT(String SORT) {
        this.SORT = SORT;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getINFO() {
        return INFO;
    }

    public void setINFO(String INFO) {
        this.INFO = INFO;
    }

    }
