package com.tream.coach.ticket.entity;

import java.util.Date;

public class Ticket {
    private Integer id;

    private String ticketId;

    private String departure;

    private String destnation;

    private Date startTime;

    private Integer ticketNum;

    private Double payMoney;

    private Date payTime;

    private Integer payUserId;

    private String payUserName;

    private String payUserIdentify;

    private String buyTypeCode;

    private String buyTypeName;

    private String payTypeCode;

    private String payTypeName;

    private String payUserTel;

    private String takeFlag;

    private String delFlag;

    private String returnFlag;

    private Double returnMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure == null ? null : departure.trim();
    }

    public String getDestnation() {
        return destnation;
    }

    public void setDestnation(String destnation) {
        this.destnation = destnation == null ? null : destnation.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(Integer payUserId) {
        this.payUserId = payUserId;
    }

    public String getPayUserName() {
        return payUserName;
    }

    public void setPayUserName(String payUserName) {
        this.payUserName = payUserName == null ? null : payUserName.trim();
    }

    public String getPayUserIdentify() {
        return payUserIdentify;
    }

    public void setPayUserIdentify(String payUserIdentify) {
        this.payUserIdentify = payUserIdentify == null ? null : payUserIdentify.trim();
    }

    public String getBuyTypeCode() {
        return buyTypeCode;
    }

    public void setBuyTypeCode(String buyTypeCode) {
        this.buyTypeCode = buyTypeCode == null ? null : buyTypeCode.trim();
    }

    public String getBuyTypeName() {
        return buyTypeName;
    }

    public void setBuyTypeName(String buyTypeName) {
        this.buyTypeName = buyTypeName == null ? null : buyTypeName.trim();
    }

    public String getPayTypeCode() {
        return payTypeCode;
    }

    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode == null ? null : payTypeCode.trim();
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName == null ? null : payTypeName.trim();
    }

    public String getPayUserTel() {
        return payUserTel;
    }

    public void setPayUserTel(String payUserTel) {
        this.payUserTel = payUserTel == null ? null : payUserTel.trim();
    }

    public String getTakeFlag() {
        return takeFlag;
    }

    public void setTakeFlag(String takeFlag) {
        this.takeFlag = takeFlag == null ? null : takeFlag.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getReturnFlag() {
        return returnFlag;
    }

    public void setReturnFlag(String returnFlag) {
        this.returnFlag = returnFlag == null ? null : returnFlag.trim();
    }

    public Double getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }
}