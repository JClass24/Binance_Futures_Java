package com.binance.client.model.trade;

import java.math.BigDecimal;

public class Fill {
    private String commissionAsset;

    private BigDecimal commission;

    private BigDecimal price;

    private BigDecimal qty;

    public String getCommissionAsset() {
        return commissionAsset;
    }

    public void setCommissionAsset(String commissionAsset) {
        this.commissionAsset = commissionAsset;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Fill{" +
                "commissionAsset='" + commissionAsset + '\'' +
                ", commission=" + commission +
                ", price=" + price +
                ", qty=" + qty +
                '}';
    }
}
