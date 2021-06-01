package com.binance.client.base;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.util.List;

/**
 * Synchronous request interface, invoking Binance RestAPI via synchronous method.<br> All methods in this interface
 * will be blocked until the RestAPI response.
 * <p>
 * If the invoking failed or timeout, the {@link com.binance.client.exception.BinanceApiException} will be thrown.
 */
public interface FuturesSyncRequestClient extends SyncRequestClient {

    /**
     * Get mark price for a symbol.
     *
     * @return Mark price for a symbol.
     */
    List<MarkPrice> getMarkPrice(String symbol);

    /**
     * Get funding rate history.
     *
     * @return funding rate history.
     */
    List<FundingRate> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit);

    /**
     * Get all liquidation orders.
     *
     * @return All liquidation orders.
     */
    List<LiquidationOrder> getLiquidationOrders(String symbol, Long startTime, Long endTime, Integer limit);

    /**
     * Send in a new order.
     *
     * @return Order.
     */
    Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
                    TimeInForce timeInForce, String quantity, String price, String reduceOnly,
                    String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType);

    /**
     * Place new orders
     *
     * @param batchOrders
     * @return
     */
    List<Object> postBatchOrders(String batchOrders);

    /**
     * Cancel all open orders.
     *
     * @return ResponseResult.
     */
    ResponseResult cancelAllOpenOrder(String symbol);

    /**
     * Batch cancel orders.
     *
     * @return Order.
     */
    List<Object> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList);

    /**
     * Switch position side. (true == dual, false == both)
     *
     * @return ResponseResult.
     */
    ResponseResult changePositionSide(boolean dual);

    /**
     * Change margin type (ISOLATED, CROSSED)
     *
     * @param symbolName
     * @param marginType
     * @return
     */
    ResponseResult changeMarginType(String symbolName, String marginType);

    /**
     * add isolated position margin
     *
     * @param symbolName
     * @param type
     * @param amount
     * @param positionSide SHORT, LONG, BOTH
     * @return
     */
    JSONObject addIsolatedPositionMargin(String symbolName, int type, String amount, PositionSide positionSide);

    /**
     * get position margin history
     *
     * @param symbolName
     * @param type
     * @param startTime
     * @param endTime
     * @param limit
     * @return
     */
    List<WalletDeltaLog> getPositionMarginHistory(String symbolName, int type, long startTime, long endTime, int limit);

    /**
     * Get if changed to HEDGE mode. (true == hedge mode, false == one-way mode)
     *
     * @return ResponseResult.
     */
    JSONObject getPositionSide();

    /**
     * Get current account information.
     *
     * @return Current account information.
     */
    AccountInformation getAccountInformation();

    /**
     * Get account balances.
     *
     * @return Balances.
     */
    List<AccountBalance> getBalance();

    /**
     * Change initial leverage.
     *
     * @return Leverage.
     */
    Leverage changeInitialLeverage(String symbol, Integer leverage);

    /**
     * Get position.
     *
     * @return Position.
     */
    List<PositionRisk> getPositionRisk();

    /**
     * Get income history.
     *
     * @return Income history.
     */
    List<Income> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime, Integer limit);

    /**
     * Open Interest Stat (MARKET DATA)
     *
     * @return Open Interest Stat.
     */
    List<OpenInterestStat> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

    /**
     * Top Trader Long/Short Ratio (Accounts) (MARKET DATA)
     *
     * @return Top Trader Long/Short Ratio (Accounts).
     */
    List<CommonLongShortRatio> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

    /**
     * Top Trader Long/Short Ratio (Positions) (MARKET DATA)
     *
     * @return Top Trader Long/Short Ratio (Positions).
     */
    List<CommonLongShortRatio> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);

    /**
     * Long/Short Ratio (MARKET DATA)
     *
     * @return global Long/Short Ratio.
     */
    List<CommonLongShortRatio> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit);
}