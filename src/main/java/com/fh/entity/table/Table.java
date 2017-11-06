package com.fh.entity.table;

import java.util.Date;

/**
 * 桌号实体类
 *
 * @author zcc ON 2017/11/4
 **/
public class Table {
    /**
     * ID
     */
    private String TABLE_ID;
    /**
     * 桌号
     */
    private String NUM;
    /**
     * 位置
     */
    private String LOCATION;
    /**
     * 创建时间
     */
    private Date CREATE_TIME;
    /**
     * 更新时间
     */
    private Date UPDATE_TIME;
    /**
     * 桌号状态
     */
    private String STATUS;

    public String getTABLE_ID() {
        return TABLE_ID;
    }

    public void setTABLE_ID(String TABLE_ID) {
        this.TABLE_ID = TABLE_ID;
    }

    public String getNUM() {
        return NUM;
    }

    public void setNUM(String NUM) {
        this.NUM = NUM;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
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

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
