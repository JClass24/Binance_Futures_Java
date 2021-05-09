package com.binance.client.model.user;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class BalanceUpdate {

    private String asset;

    private BigDecimal walletBalance;
    private BigDecimal availBalance;
    private BigDecimal blockBalance;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public BigDecimal getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(BigDecimal walletBalance) {
        this.walletBalance = walletBalance;
    }

    public BigDecimal getAvailBalance() {
        return availBalance;
    }

    public void setAvailBalance(BigDecimal availBalance) {
        this.availBalance = availBalance;
    }

    public BigDecimal getBlockBalance() {
        return blockBalance;
    }

    public void setBlockBalance(BigDecimal blockBalance) {
        this.blockBalance = blockBalance;
    }

    @Override
    public String toString() {
        return "BalanceUpdate{" +
                "asset='" + asset + '\'' +
                ", walletBalance=" + walletBalance +
                ", availBalance=" + availBalance +
                ", blockBalance=" + blockBalance +
                '}';
    }
}
