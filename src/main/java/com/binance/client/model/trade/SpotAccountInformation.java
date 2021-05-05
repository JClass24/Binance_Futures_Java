package com.binance.client.model.trade;

import java.math.BigDecimal;
import java.util.List;

public class SpotAccountInformation {

    private Boolean canTrade;

    private Boolean canWithdraw;

    private Boolean canDeposit;

    private BigDecimal makerCommission;

    private BigDecimal takerCommission;

    private BigDecimal buyerCommission;

    private BigDecimal sellerCommission;

    private String accountType;

    private Long updateTime;

    private List<SpotBalance> balances;

    private List<String> permissions;

    public Boolean getCanTrade() {
        return canTrade;
    }

    public void setCanTrade(Boolean canTrade) {
        this.canTrade = canTrade;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public Boolean getCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public BigDecimal getMakerCommission() {
        return makerCommission;
    }

    public void setMakerCommission(BigDecimal makerCommission) {
        this.makerCommission = makerCommission;
    }

    public BigDecimal getTakerCommission() {
        return takerCommission;
    }

    public void setTakerCommission(BigDecimal takerCommission) {
        this.takerCommission = takerCommission;
    }

    public BigDecimal getBuyerCommission() {
        return buyerCommission;
    }

    public void setBuyerCommission(BigDecimal buyerCommission) {
        this.buyerCommission = buyerCommission;
    }

    public BigDecimal getSellerCommission() {
        return sellerCommission;
    }

    public void setSellerCommission(BigDecimal sellerCommission) {
        this.sellerCommission = sellerCommission;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public List<SpotBalance> getBalances() {
        return balances;
    }

    public void setBalances(List<SpotBalance> balances) {
        this.balances = balances;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "SpotAccountInformation{" +
                "canTrade=" + canTrade +
                ", canWithdraw=" + canWithdraw +
                ", canDeposit=" + canDeposit +
                ", makerCommission=" + makerCommission +
                ", takerCommission=" + takerCommission +
                ", buyerCommission=" + buyerCommission +
                ", sellerCommission=" + sellerCommission +
                ", accountType='" + accountType + '\'' +
                ", updateTime=" + updateTime +
                ", balances=" + balances +
                ", permissions=" + permissions +
                '}';
    }
}
