package com.fh.entity.order;

public class Order {
	public String ID;             //id;
	public String WEIXIN_ID;      //微信用户ID
	public String PAGE;           //订单页    
	public String NUMBER;         //订单号
	public String TOTAL_PRICE;    //总价格
	public String TABLE_NUMBER;   //桌号
	public String NAME;           //顾客姓名
	public String STATUS;         //状态( 1 已付款，0 未付款)
	public String DE_FLAGE;       //删除标志
	public String REMARK;         //备注
	public static String PAID = "1";
	public static String NOPAID = "0";
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getWEIXIN_ID() {
		return WEIXIN_ID;
	}
	public void setWEIXIN_ID(String wEIXIN_ID) {
		WEIXIN_ID = wEIXIN_ID;
	}
	public String getPAGE() {
		return PAGE;
	}
	public void setPAGE(String pAGE) {
		PAGE = pAGE;
	}
	public String getNUMBER() {
		return NUMBER;
	}
	public void setNUMBER(String nUMBER) {
		NUMBER = nUMBER;
	}
	public String getTOTAL_PRICE() {
		return TOTAL_PRICE;
	}
	public void setTOTAL_PRICE(String tOTAL_PRICE) {
		TOTAL_PRICE = tOTAL_PRICE;
	}
	public String getTABLE_NUMBER() {
		return TABLE_NUMBER;
	}
	public void setTABLE_NUMBER(String tABLE_NUMBER) {
		TABLE_NUMBER = tABLE_NUMBER;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public String getDE_FLAGE() {
		return DE_FLAGE;
	}
	public void setDE_FLAGE(String dE_FLAGE) {
		DE_FLAGE = dE_FLAGE;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	

}
