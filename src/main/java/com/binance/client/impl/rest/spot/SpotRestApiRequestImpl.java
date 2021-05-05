package com.binance.client.impl.rest.spot;

import com.binance.client.RequestOptions;
import com.binance.client.impl.base.BaseRestApiRequestImpl;
import com.binance.client.impl.base.RestApiRequest;
import com.binance.client.impl.utils.JsonWrapperArray;
import com.binance.client.impl.utils.UrlParamsBuilder;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.LinkedList;
import java.util.List;

public class SpotRestApiRequestImpl extends BaseRestApiRequestImpl {

    public SpotRestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        super(apiKey, secretKey, options);
    }

    public RestApiRequest<SpotOrder> postOrder(String symbol, OrderSide side, OrderType orderType,
                                               TimeInForce timeInForce, String quantity, String quoteOrderQty, String price,
                                               String newClientOrderId, String stopPrice, String icebergQty, NewOrderRespType newOrderRespType) {
        RestApiRequest<SpotOrder> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("side", side)
                .putToUrl("type", orderType)
                .putToUrl("timeInForce", timeInForce)
                .putToUrl("quantity", quantity)
                .putToUrl("quoteOrderQty", quoteOrderQty)
                .putToUrl("price", price)
                .putToUrl("newClientOrderId", newClientOrderId)
                .putToUrl("stopPrice", stopPrice)
                .putToUrl("icebergQty", icebergQty)
                .putToUrl("newOrderRespType", newOrderRespType);

        request.request = createRequestByPostWithSignature("/api/v3/order", builder);

        request.jsonParser = (jsonWrapper -> {
            SpotOrder result = new SpotOrder();
            result.setSymbol(jsonWrapper.getString("symbol"));
            result.setOrderId(jsonWrapper.getLong("orderId"));
            result.setOrderListId(jsonWrapper.getLong("orderListId"));
            result.setClientOrderId(jsonWrapper.getString("clientOrderId"));
            result.setTransactTime(jsonWrapper.getLong("transactTime"));
            result.setPrice(jsonWrapper.getBigDecimal("price"));
            result.setOrigQty(jsonWrapper.getBigDecimal("origQty"));
            result.setExecutedQty(jsonWrapper.getBigDecimal("executedQty"));
            result.setCummulativeQuoteQty(jsonWrapper.getBigDecimal("cummulativeQuoteQty"));
            result.setStatus(jsonWrapper.getString("status"));
            result.setTimeInForce(jsonWrapper.getString("timeInForce"));
            result.setType(jsonWrapper.getString("type"));
            result.setSide(jsonWrapper.getString("side"));

            List<Fill> elementList = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("fills");
            dataArray.forEach((item) -> {
                Fill element = new Fill();
                element.setPrice(item.getBigDecimal("price"));
                element.setCommission(item.getBigDecimal("commission"));
                element.setCommissionAsset(item.getString("commissionAsset"));
                element.setQty(item.getBigDecimal("qty"));
                elementList.add(element);
            });
            result.setFills(elementList);
            return result;
        });
        return request;
    }

    public RestApiRequest<ExchangeInformation> getExchangeInformation() {
        return getExchangeInformation("/api/v3/exchangeInfo");
    }

    public RestApiRequest<OrderBook> getOrderBook(String symbol, Integer limit) {
        return getOrderBook(symbol, limit, "/api/v3/depth");
    }

    public RestApiRequest<List<Trade>> getRecentTrades(String symbol, Integer limit) {
        return getRecentTrades(symbol, limit, "/api/v3/trades");
    }

    public RestApiRequest<List<Trade>> getOldTrades(String symbol, Integer limit, Long fromId) {
        return getOldTrades(symbol, limit, fromId, "/api/v3/historicalTrades");
    }

    public RestApiRequest<List<AggregateTrade>> getAggregateTrades(String symbol, Long fromId,
                                                                   Long startTime, Long endTime, Integer limit) {
        return getAggregateTrades(symbol, fromId, startTime, endTime, limit, "/api/v3/aggTrades");
    }

    public RestApiRequest<List<Candlestick>> getCandlestick(String symbol, CandlestickInterval interval, Long startTime,
                                                            Long endTime, Integer limit) {
        return getCandlestick(symbol, interval, startTime, endTime, limit, "/api/v3/klines");
    }

    public RestApiRequest<List<PriceChangeTicker>> get24hrTickerPriceChange(String symbol) {
        return get24hrTickerPriceChange(symbol, "/api/v3/ticker/24hr");
    }

    public RestApiRequest<List<SymbolPrice>> getSymbolPriceTicker(String symbol) {
        return getSymbolPriceTicker(symbol, "/api/v3/ticker/price");
    }

    public RestApiRequest<List<SymbolOrderBook>> getSymbolOrderBookTicker(String symbol) {
        return getSymbolOrderBookTicker(symbol, "/api/v3/ticker/bookTicker");
    }

    public RestApiRequest<FuturesOrder> cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return cancelOrder(symbol, orderId, origClientOrderId, "/api/v3/order");
    }

    public RestApiRequest<FuturesOrder> getOrder(String symbol, Long orderId, String origClientOrderId) {
        return getOrder(symbol, orderId, origClientOrderId, "/api/v3/order");
    }

    public RestApiRequest<List<FuturesOrder>> getOpenOrders(String symbol) {
        return getOpenOrders(symbol, "/api/v3/openOrders");
    }

    /**
     * 查询所有订单 (USER_DATA)
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<List<FuturesOrder>> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return getAllOrders(symbol, orderId, startTime, endTime, limit, "/api/v3/allOrders");
    }

    public RestApiRequest<SpotAccountInformation> getAccountInformation() {
        RestApiRequest<SpotAccountInformation> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        request.request = createRequestByGetWithSignature("/api/v3/account", builder);
        request.jsonParser = (jsonWrapper -> {
            SpotAccountInformation result = new SpotAccountInformation();
            result.setAccountType(jsonWrapper.getString("accountType"));
            result.setBuyerCommission(jsonWrapper.getBigDecimal("buyerCommission"));
            result.setCanDeposit(jsonWrapper.getBoolean("canDeposit"));
            result.setCanTrade(jsonWrapper.getBoolean("canTrade"));
            result.setCanWithdraw(jsonWrapper.getBoolean("canWithdraw"));
            result.setMakerCommission(jsonWrapper.getBigDecimal("makerCommission"));
            result.setSellerCommission(jsonWrapper.getBigDecimal("sellerCommission"));
            result.setTakerCommission(jsonWrapper.getBigDecimal("takerCommission"));
            result.setUpdateTime(jsonWrapper.getLong("updateTime"));

            List<SpotBalance> elementList = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("balances");
            dataArray.forEach((item) -> {
                SpotBalance element = new SpotBalance();
                element.setFree(item.getBigDecimal("free"));
                element.setAsset(item.getString("asset"));
                element.setLocked(item.getBigDecimal("locked"));
                elementList.add(element);
            });
            result.setBalances(elementList);
            JsonWrapperArray permissionsArray = jsonWrapper.getJsonArray("permissions");
            result.setPermissions(permissionsArray.convert2StringList());
            return result;
        });
        return request;
    }

    public RestApiRequest<List<MyTrade>> getAccountTrades(String symbol, Long startTime, Long endTime,
                                                          Long fromId, Integer limit) {
        return getAccountTrades(symbol, startTime, endTime, fromId, limit, "/api/v3/myTrades");
    }

    public RestApiRequest<String> startUserDataStream() {
        return startUserDataStream("/api/v3/userDataStream");
    }

    public RestApiRequest<String> keepUserDataStream(String listenKey) {
        return keepUserDataStream(listenKey, "/api/v3/userDataStream");
    }

    public RestApiRequest<String> closeUserDataStream(String listenKey) {
        return closeUserDataStream(listenKey, "/api/v3/userDataStream");
    }
}
