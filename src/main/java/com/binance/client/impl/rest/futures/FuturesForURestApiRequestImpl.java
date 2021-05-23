package com.binance.client.impl.rest.futures;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.RequestOptions;
import com.binance.client.impl.base.BaseRestApiRequestImpl;
import com.binance.client.impl.base.RestApiRequest;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

public class FuturesForURestApiRequestImpl extends BaseRestApiRequestImpl {

    public FuturesForURestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        super(apiKey, secretKey, options);
    }

    /**
     * 获取交易规则和交易对
     *
     * @return
     */
    public RestApiRequest<ExchangeInformation> getExchangeInformation() {
        return getExchangeInformation("/fapi/v1/exchangeInfo");
    }

    /**
     * 深度信息
     *
     * @param symbol
     * @param limit
     * @return
     */
    public RestApiRequest<OrderBook> getOrderBook(String symbol, Integer limit) {
        return getOrderBook(symbol, limit, "/fapi/v1/depth");
    }

    /**
     * 近期成交
     *
     * @param symbol
     * @param limit
     * @return
     */
    public RestApiRequest<List<Trade>> getRecentTrades(String symbol, Integer limit) {
        return getRecentTrades(symbol, limit, "/fapi/v1/trades");
    }

    /**
     * 查询历史成交 (MARKET_DATA)
     *
     * @param symbol
     * @param limit
     * @param fromId
     * @return
     */
    public RestApiRequest<List<Trade>> getOldTrades(String symbol, Integer limit, Long fromId) {
        return getOldTrades(symbol, limit, fromId, "/fapi/v1/historicalTrades");
    }

    /**
     * 近期成交(归集)
     *
     * @param symbol
     * @param fromId
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<AggregateTrade>> getAggregateTrades(String symbol, Long fromId,
                                                                   Long startTime, Long endTime, Integer limit) {
        return getAggregateTrades(symbol, fromId, startTime, endTime, limit, "/fapi/v1/aggTrades");
    }

    /**
     * K线数据
     *
     * @param symbol
     * @param interval
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<Candlestick>> getCandlestick(String symbol, String interval, Long startTime,
                                                            Long endTime, Integer limit) {
        return getCandlestick(symbol, interval, startTime, endTime, limit, "/fapi/v1/klines");
    }

    /**
     * 最新现货指数价格和Mark Price
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<List<MarkPrice>> getMarkPrice(String symbol) {
        return getMarkPrice(symbol, "/fapi/v1/premiumIndex");
    }

    /**
     * 查询永续合约资金费率历史
     *
     * @param symbol
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<FundingRate>> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit) {
        return getFundingRate(symbol, startTime, endTime, limit, "/fapi/v1/fundingRate");
    }

    /**
     * 24hr价格变动情况
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<List<PriceChangeTicker>> get24hrTickerPriceChange(String symbol) {
        return get24hrTickerPriceChange(symbol, "/fapi/v1/ticker/24hr");
    }

    /**
     * 最新价格
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<List<SymbolPrice>> getSymbolPriceTicker(String symbol) {
        return getSymbolPriceTicker(symbol, "/fapi/v1/ticker/price");
    }

    /**
     * 当前最优挂单
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<List<SymbolOrderBook>> getSymbolOrderBookTicker(String symbol) {
        return getSymbolOrderBookTicker(symbol, "/fapi/v1/ticker/bookTicker");
    }

    /**
     * 【停止服务】获取市场强平订单接口
     *
     * @param symbol
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<LiquidationOrder>> getLiquidationOrders(String symbol, Long startTime, Long endTime,
                                                                       Integer limit) {
        return getLiquidationOrders(symbol, startTime, endTime, limit, "/fapi/v1/allForceOrders");
    }

    /**
     * 批量下单 (TRADE)
     *
     * @param batchOrders
     * @return
     */
    public RestApiRequest<List<Object>> postBatchOrders(String batchOrders) {
        return postBatchOrders(batchOrders, "/fapi/v1/batchOrders");
    }

    /**
     * 下单 (TRADE)
     *
     * @param symbol
     * @param side
     * @param positionSide
     * @param orderType
     * @param timeInForce
     * @param quantity
     * @param price
     * @param reduceOnly
     * @param newClientOrderId
     * @param stopPrice
     * @param workingType
     * @param newOrderRespType
     * @return
     */
    public RestApiRequest<FuturesOrder> postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
                                                  TimeInForce timeInForce, String quantity, String price, String reduceOnly,
                                                  String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType) {
        return postOrder(symbol, side, positionSide, orderType, timeInForce, quantity, price, reduceOnly, newClientOrderId, stopPrice, workingType, newOrderRespType, "/fapi/v1/order");
    }

    /**
     * 更改持仓模式(TRADE)
     *
     * @param dual
     * @return
     */
    public RestApiRequest<ResponseResult> changePositionSide(boolean dual) {
        return changePositionSide(dual, "/fapi/v1/positionSide/dual");
    }

    /**
     * 变换逐全仓模式 (TRADE)
     *
     * @param symbolName
     * @param marginType
     * @return
     */
    public RestApiRequest<ResponseResult> changeMarginType(String symbolName, String marginType) {
        return changeMarginType(symbolName, marginType, "/fapi/v1/marginType");
    }

    /**
     * 调整逐仓保证金 (TRADE)
     *
     * @param symbolName
     * @param type
     * @param amount
     * @param positionSide
     * @return
     */
    public RestApiRequest<JSONObject> addPositionMargin(String symbolName, int type, String amount, PositionSide positionSide) {
        return addPositionMargin(symbolName, type, amount, positionSide, "/fapi/v1/positionMargin");
    }

    /**
     * 逐仓保证金变动历史 (TRADE)
     *
     * @param symbolName
     * @param type
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<WalletDeltaLog>> getPositionMarginHistory(String symbolName, int type, long startTime, long endTime, int limit) {
        return getPositionMarginHistory(symbolName, type, startTime, endTime, limit, "/fapi/v1/positionMargin/history");
    }

    /**
     * 查询持仓模式(USER_DATA)
     *
     * @return
     */
    public RestApiRequest<JSONObject> getPositionSide() {
        return getPositionSide("/fapi/v1/positionSide/dual");
    }

    /**
     * 撤销订单 (TRADE)
     *
     * @param symbol
     * @param orderId
     * @param origClientOrderId
     * @return
     */
    public RestApiRequest<FuturesOrder> cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return cancelOrder(symbol, orderId, origClientOrderId, "/fapi/v1/order");
    }

    /**
     * 撤销全部订单 (TRADE)
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<ResponseResult> cancelAllOpenOrder(String symbol) {
        return cancelAllOpenOrder(symbol, "/fapi/v1/allOpenOrders");
    }

    /**
     * 批量撤销订单 (TRADE)
     *
     * @param symbol
     * @param orderIdList
     * @param origClientOrderIdList
     * @return
     */
    public RestApiRequest<List<Object>> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList) {
        return batchCancelOrders(symbol, orderIdList, origClientOrderIdList, "/fapi/v1/batchOrders");
    }

    /**
     * 查询订单 (USER_DATA)
     *
     * @param symbol
     * @param orderId
     * @param origClientOrderId
     * @return
     */
    public RestApiRequest<FuturesOrder> getOrder(String symbol, Long orderId, String origClientOrderId) {
        return getOrder(symbol, orderId, origClientOrderId, "/fapi/v1/order");
    }

    /**
     * 查看当前全部挂单 (USER_DATA)
     *
     * @param symbol
     * @return
     */
    public RestApiRequest<List<FuturesOrder>> getOpenOrders(String symbol) {
        return getOpenOrders(symbol, "/fapi/v1/openOrders");
    }

    /**
     * 查询所有订单(包括历史订单) (USER_DATA)
     *
     * @param symbol
     * @param orderId
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<FuturesOrder>> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return getAllOrders(symbol, orderId, startTime, endTime, limit, "/fapi/v1/allOrders");
    }

    /**
     * 账户余额 (USER_DATA)
     *
     * @return
     */
    public RestApiRequest<List<AccountBalance>> getBalance() {
        return getBalance("/fapi/v1/balance");
    }

    /**
     * 账户信息 (USER_DATA)
     *
     * @return
     */
    public RestApiRequest<AccountInformation> getAccountInformation() {
        return getAccountInformation("/fapi/v1/account");
    }

    /**
     * 调整开仓杠杆 (TRADE)
     *
     * @param symbol
     * @param leverage
     * @return
     */
    public RestApiRequest<Leverage> changeInitialLeverage(String symbol, Integer leverage) {
        return changeInitialLeverage(symbol, leverage, "/fapi/v1/leverage");
    }

    /**
     * 用户持仓风险
     *
     * @return
     */
    public RestApiRequest<List<PositionRisk>> getPositionRisk() {
        return getPositionRisk("/fapi/v1/positionRisk");
    }

    /**
     * 账户成交历史 (USER_DATA)
     *
     * @param symbol
     * @param startTime
     * @param endTime
     * @param fromId
     * @param limit
     * @return
     */
    public RestApiRequest<List<MyTrade>> getAccountTrades(String symbol, Long startTime, Long endTime,
                                                          Long fromId, Integer limit) {
        return getAccountTrades(symbol, startTime, endTime, fromId, limit, "/fapi/v1/userTrades");
    }

    /**
     * 获取账户损益资金流水(USER_DATA)
     *
     * @param symbol
     * @param incomeType
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<Income>> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime,
                                                         Integer limit) {
        return getIncomeHistory(symbol, incomeType, startTime, endTime, limit, "/fapi/v1/income");
    }

    /**
     * 生成listenKey (USER_STREAM)
     *
     * @return
     */
    public RestApiRequest<String> startUserDataStream() {
        return startUserDataStream("/fapi/v1/listenKey");
    }

    /**
     * 延长listenKey有效期 (USER_STREAM)
     *
     * @param listenKey
     * @return
     */
    public RestApiRequest<String> keepUserDataStream(String listenKey) {
        return keepUserDataStream(listenKey, "/fapi/v1/listenKey");
    }

    /**
     * 关闭listenKey (USER_STREAM)
     *
     * @param listenKey
     * @return
     */
    public RestApiRequest<String> closeUserDataStream(String listenKey) {
        return closeUserDataStream(listenKey, "/fapi/v1/listenKey");
    }

    /**
     * 合约持仓量
     *
     * @param symbol
     * @param period
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<OpenInterestStat>> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getOpenInterestStat(symbol, period, startTime, endTime, limit, "/futures/data/openInterestHist");
    }

    /**
     * 大户账户数多空比
     *
     * @param symbol
     * @param period
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<CommonLongShortRatio>> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getTopTraderAccountRatio(symbol, period, startTime, endTime, limit, "/futures/data/topLongShortAccountRatio");
    }

    /**
     * 大户持仓量多空比
     *
     * @param symbol
     * @param period
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<CommonLongShortRatio>> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getTopTraderPositionRatio(symbol, period, startTime, endTime, limit, "/futures/data/topLongShortPositionRatio");
    }

    /**
     * 多空持仓人数比
     *
     * @param symbol
     * @param period
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<CommonLongShortRatio>> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getGlobalAccountRatio(symbol, period, startTime, endTime, limit, "/futures/data/globalLongShortAccountRatio");
    }

    /**
     * 合约主动买卖量
     *
     * @param symbol
     * @param period
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    public RestApiRequest<List<TakerLongShortStat>> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return getTakerLongShortRatio(symbol, period, startTime, endTime, limit, "/futures/data/takerlongshortRatio");
    }
}
