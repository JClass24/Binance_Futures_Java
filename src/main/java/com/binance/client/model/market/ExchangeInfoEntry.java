package com.binance.client.model.market;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ExchangeInfoEntry {

    private String symbol;

    private String status;

    private String pair;

    private String contractType;

    private Long deliveryDate;

    private Long onboardDate;

    private String contractStatus;

    private Integer contractSize;

    private String marginAsset;

    private String underlyingType;

    private BigDecimal maintMarginPercent;

    private BigDecimal requiredMarginPercent;

    private String baseAsset;

    private String quoteAsset;

    private Long pricePrecision;

    private Long quantityPrecision;

    private Long baseAssetPrecision;

    private Long quotePrecision;

    private List<String> orderTypes;

    private List<String> timeInForce;

    private List<List<Map<String, String>>> filters;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMaintMarginPercent() {
        return maintMarginPercent;
    }

    public void setMaintMarginPercent(BigDecimal maintMarginPercent) {
        this.maintMarginPercent = maintMarginPercent;
    }

    public BigDecimal getRequiredMarginPercent() {
        return requiredMarginPercent;
    }

    public void setRequiredMarginPercent(BigDecimal requiredMarginPercent) {
        this.requiredMarginPercent = requiredMarginPercent;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuoteAsset() {
        return quoteAsset;
    }

    public void setQuoteAsset(String quoteAsset) {
        this.quoteAsset = quoteAsset;
    }

    public Long getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(Long pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public Long getQuantityPrecision() {
        return quantityPrecision;
    }

    public void setQuantityPrecision(Long quantityPrecision) {
        this.quantityPrecision = quantityPrecision;
    }

    public Long getBaseAssetPrecision() {
        return baseAssetPrecision;
    }

    public void setBaseAssetPrecision(Long baseAssetPrecision) {
        this.baseAssetPrecision = baseAssetPrecision;
    }

    public Long getQuotePrecision() {
        return quotePrecision;
    }

    public void setQuotePrecision(Long quotePrecision) {
        this.quotePrecision = quotePrecision;
    }

    public List<String> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<String> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public List<String> getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(List<String> timeInForce) {
        this.timeInForce = timeInForce;
    }

    public List<List<Map<String, String>>> getFilters() {
        return filters;
    }

    public void setFilters(List<List<Map<String, String>>> filters) {
        this.filters = filters;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getOnboardDate() {
        return onboardDate;
    }

    public void setOnboardDate(Long onboardDate) {
        this.onboardDate = onboardDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Integer getContractSize() {
        return contractSize;
    }

    public void setContractSize(Integer contractSize) {
        this.contractSize = contractSize;
    }

    public String getMarginAsset() {
        return marginAsset;
    }

    public void setMarginAsset(String marginAsset) {
        this.marginAsset = marginAsset;
    }

    public String getUnderlyingType() {
        return underlyingType;
    }

    public void setUnderlyingType(String underlyingType) {
        this.underlyingType = underlyingType;
    }

    @Override
    public String toString() {
        return "ExchangeInfoEntry{" +
                "symbol='" + symbol + '\'' +
                ", status='" + status + '\'' +
                ", pair='" + pair + '\'' +
                ", contractType='" + contractType + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", onboardDate=" + onboardDate +
                ", contractStatus='" + contractStatus + '\'' +
                ", contractSize=" + contractSize +
                ", marginAsset='" + marginAsset + '\'' +
                ", underlyingType='" + underlyingType + '\'' +
                ", maintMarginPercent=" + maintMarginPercent +
                ", requiredMarginPercent=" + requiredMarginPercent +
                ", baseAsset='" + baseAsset + '\'' +
                ", quoteAsset='" + quoteAsset + '\'' +
                ", pricePrecision=" + pricePrecision +
                ", quantityPrecision=" + quantityPrecision +
                ", baseAssetPrecision=" + baseAssetPrecision +
                ", quotePrecision=" + quotePrecision +
                ", orderTypes=" + orderTypes +
                ", timeInForce=" + timeInForce +
                ", filters=" + filters +
                '}';
    }
}
