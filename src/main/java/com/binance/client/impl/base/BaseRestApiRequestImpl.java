package com.binance.client.impl.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binance.client.RequestOptions;
import com.binance.client.impl.utils.JsonWrapperArray;
import com.binance.client.impl.utils.UrlParamsBuilder;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseRestApiRequestImpl extends RestApiRequestImpl {

    public BaseRestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        super(apiKey, secretKey, options);
    }

    public RestApiRequest<OrderBook> getOrderBook(String symbol, Integer limit, String path) {
        RestApiRequest<OrderBook> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("limit", limit);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            OrderBook result = new OrderBook();
            result.setLastUpdateId(jsonWrapper.getLong("lastUpdateId"));

            List<OrderBookEntry> elementList = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("bids");
            dataArray.forEachAsArray((item) -> {
                OrderBookEntry element = new OrderBookEntry();
                element.setPrice(item.getBigDecimalAt(0));
                element.setQty(item.getBigDecimalAt(1));
                elementList.add(element);
            });
            result.setBids(elementList);

            List<OrderBookEntry> askList = new LinkedList<>();
            JsonWrapperArray askArray = jsonWrapper.getJsonArray("asks");
            askArray.forEachAsArray((item) -> {
                OrderBookEntry element = new OrderBookEntry();
                element.setPrice(item.getBigDecimalAt(0));
                element.setQty(item.getBigDecimalAt(1));
                askList.add(element);
            });
            result.setAsks(askList);

            return result;
        });
        return request;
    }

    public RestApiRequest<List<Trade>> getRecentTrades(String symbol, Integer limit, String path) {
        RestApiRequest<List<Trade>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("limit", limit);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<Trade> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                Trade element = new Trade();
                element.setId(item.getLong("id"));
                element.setPrice(item.getBigDecimal("price"));
                element.setQty(item.getBigDecimal("qty"));
                element.setQuoteQty(item.getBigDecimal("quoteQty"));
                element.setTime(item.getLong("time"));
                element.setIsBuyerMaker(item.getBoolean("isBuyerMaker"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<Trade>> getOldTrades(String symbol, Integer limit, Long fromId, String path) {
        RestApiRequest<List<Trade>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("limit", limit)
                .putToUrl("fromId", fromId);
        request.request = createRequestByGetWithApikey(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<Trade> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");

            dataArray.forEach((item) -> {
                Trade element = new Trade();
                element.setId(item.getLong("id"));
                element.setPrice(item.getBigDecimal("price"));
                element.setQty(item.getBigDecimal("qty"));
                element.setQuoteQty(item.getBigDecimal("quoteQty"));
                element.setTime(item.getLong("time"));
                element.setIsBuyerMaker(item.getBoolean("isBuyerMaker"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<AggregateTrade>> getAggregateTrades(String symbol, Long fromId,
                                                                   Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<AggregateTrade>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("fromId", fromId)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<AggregateTrade> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                AggregateTrade element = new AggregateTrade();
                element.setId(item.getLong("a"));
                element.setPrice(item.getBigDecimal("p"));
                element.setQty(item.getBigDecimal("q"));
                element.setFirstId(item.getLong("f"));
                element.setLastId(item.getLong("l"));
                element.setTime(item.getLong("T"));
                element.setIsBuyerMaker(item.getBoolean("m"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<Candlestick>> getCandlestick(String symbol, String interval, Long startTime,
                                                            Long endTime, Integer limit, String path) {
        RestApiRequest<List<Candlestick>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("interval", interval)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<Candlestick> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEachAsArray((item) -> {
                Candlestick element = new Candlestick();
                element.setOpenTime(item.getLongAt(0));
                element.setOpen(item.getBigDecimalAt(1));
                element.setHigh(item.getBigDecimalAt(2));
                element.setLow(item.getBigDecimalAt(3));
                element.setClose(item.getBigDecimalAt(4));
                element.setVolume(item.getBigDecimalAt(5));
                element.setCloseTime(item.getLongAt(6));
                element.setQuoteAssetVolume(item.getBigDecimalAt(7));
                element.setNumTrades(item.getLongAt(8));
                element.setTakerBuyBaseAssetVolume(item.getBigDecimalAt(9));
                element.setTakerBuyQuoteAssetVolume(item.getBigDecimalAt(10));
                element.setIgnore(item.getBigDecimalAt(11));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<MarkPrice>> getMarkPrice(String symbol, String path) {
        RestApiRequest<List<MarkPrice>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<MarkPrice> result = new LinkedList<>();
            JsonWrapperArray dataArray = new JsonWrapperArray(new JSONArray());
            if (jsonWrapper.containKey("data")) {
                dataArray = jsonWrapper.getJsonArray("data");
            } else {
                dataArray.add(jsonWrapper.convert2JsonObject());
            }
            dataArray.forEach((item) -> {
                MarkPrice element = new MarkPrice();
                element.setSymbol(item.getString("symbol"));
                element.setMarkPrice(item.getBigDecimal("markPrice"));
                element.setLastFundingRate(item.getBigDecimal("lastFundingRate"));
                element.setNextFundingTime(item.getLong("nextFundingTime"));
                element.setTime(item.getLong("time"));
                result.add(element);
            });

            return result;

        });
        return request;
    }

    public RestApiRequest<List<FundingRate>> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<FundingRate>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<FundingRate> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach(item -> {
                FundingRate element = new FundingRate();
                element.setSymbol(item.getString("symbol"));
                element.setFundingRate(item.getBigDecimal("fundingRate"));
                element.setFundingTime(item.getLong("fundingTime"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<PriceChangeTicker>> get24hrTickerPriceChange(String symbol, String path) {
        RestApiRequest<List<PriceChangeTicker>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<PriceChangeTicker> result = new LinkedList<>();
            JsonWrapperArray dataArray = new JsonWrapperArray(new JSONArray());
            if (jsonWrapper.containKey("data")) {
                dataArray = jsonWrapper.getJsonArray("data");
            } else {
                dataArray.add(jsonWrapper.convert2JsonObject());
            }
            dataArray.forEach((item) -> {
                PriceChangeTicker element = new PriceChangeTicker();
                element.setSymbol(item.getString("symbol"));
                element.setPriceChange(item.getBigDecimal("priceChange"));
                element.setPriceChangePercent(item.getBigDecimal("priceChangePercent"));
                element.setWeightedAvgPrice(item.getBigDecimal("weightedAvgPrice"));
                element.setLastPrice(item.getBigDecimal("lastPrice"));
                element.setLastQty(item.getBigDecimal("lastQty"));
                element.setOpenPrice(item.getBigDecimal("openPrice"));
                element.setHighPrice(item.getBigDecimal("highPrice"));
                element.setLowPrice(item.getBigDecimal("lowPrice"));
                element.setVolume(item.getBigDecimal("volume"));
                element.setQuoteVolume(item.getBigDecimal("quoteVolume"));
                element.setOpenTime(item.getLong("openTime"));
                element.setCloseTime(item.getLong("closeTime"));
                element.setFirstId(item.getLong("firstId"));
                element.setLastId(item.getLong("lastId"));
                element.setCount(item.getLong("count"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<SymbolPrice>> getSymbolPriceTicker(String symbol, String path) {
        RestApiRequest<List<SymbolPrice>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<SymbolPrice> result = new LinkedList<>();
            JsonWrapperArray dataArray = new JsonWrapperArray(new JSONArray());
            if (jsonWrapper.containKey("data")) {
                dataArray = jsonWrapper.getJsonArray("data");
            } else {
                dataArray.add(jsonWrapper.convert2JsonObject());
            }
            dataArray.forEach((item) -> {
                SymbolPrice element = new SymbolPrice();
                element.setSymbol(item.getString("symbol"));
                element.setPrice(item.getBigDecimal("price"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<SymbolOrderBook>> getSymbolOrderBookTicker(String symbol, String path) {
        RestApiRequest<List<SymbolOrderBook>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<SymbolOrderBook> result = new LinkedList<>();
            JsonWrapperArray dataArray = new JsonWrapperArray(new JSONArray());
            if (jsonWrapper.containKey("data")) {
                dataArray = jsonWrapper.getJsonArray("data");
            } else {
                dataArray.add(jsonWrapper.convert2JsonObject());
            }
            dataArray.forEach((item) -> {
                SymbolOrderBook element = new SymbolOrderBook();
                element.setSymbol(item.getString("symbol"));
                element.setBidPrice(item.getBigDecimal("bidPrice"));
                element.setBidQty(item.getBigDecimal("bidQty"));
                element.setAskPrice(item.getBigDecimal("askPrice"));
                element.setAskQty(item.getBigDecimal("askQty"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<LiquidationOrder>> getLiquidationOrders(String symbol, Long startTime, Long endTime,
                                                                       Integer limit, String path) {
        RestApiRequest<List<LiquidationOrder>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGetWithApikey(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<LiquidationOrder> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");

            dataArray.forEach((item) -> {
                LiquidationOrder element = new LiquidationOrder();
                element.setSymbol(item.getString("symbol"));
                element.setPrice(item.getBigDecimal("price"));
                element.setOrigQty(item.getBigDecimal("origQty"));
                element.setExecutedQty(item.getBigDecimal("executedQty"));
                element.setAveragePrice(item.getBigDecimal("averagePrice"));
                element.setTimeInForce(item.getString("timeInForce"));
                element.setType(item.getString("symbol"));
                element.setSide(item.getString("side"));
                element.setTime(item.getLong("time"));
                result.add(element);
            });

            return result;
        });
        return request;
    }

    public RestApiRequest<List<Object>> postBatchOrders(String batchOrders, String path) {
        RestApiRequest<List<Object>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("batchOrders", batchOrders);
        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            JSONObject jsonObject = jsonWrapper.getJson();

            // success results
            List<Object> listResult = new ArrayList<>();
            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            jsonArray.forEach(obj -> {
                if (((JSONObject) obj).containsKey("code")) {
                    ResponseResult responseResult = new ResponseResult();
                    responseResult.setCode(((JSONObject) obj).getInteger("code"));
                    responseResult.setMsg(((JSONObject) obj).getString("msg"));
                    listResult.add(responseResult);
                } else {
                    Order o = new Order();
                    JSONObject jsonObj = (JSONObject) obj;
                    o.setClientOrderId(jsonObj.getString("clientOrderId"));
                    o.setCumQuote(jsonObj.getBigDecimal("cumQuote"));
                    o.setExecutedQty(jsonObj.getBigDecimal("executedQty"));
                    o.setOrderId(jsonObj.getLong("orderId"));
                    o.setOrigQty(jsonObj.getBigDecimal("origQty"));
                    o.setPrice(jsonObj.getBigDecimal("price"));
                    o.setReduceOnly(jsonObj.getBoolean("reduceOnly"));
                    o.setSide(jsonObj.getString("side"));
                    o.setPositionSide(jsonObj.getString("positionSide"));
                    o.setStatus(jsonObj.getString("status"));
                    o.setStopPrice(jsonObj.getBigDecimal("stopPrice"));
                    o.setSymbol(jsonObj.getString("symbol"));
                    o.setTimeInForce(jsonObj.getString("timeInForce"));
                    o.setType(jsonObj.getString("type"));
                    o.setUpdateTime(jsonObj.getLong("updateTime"));
                    o.setWorkingType(jsonObj.getString("workingType"));
                    listResult.add(o);
                }
            });
            return listResult;
        });
        return request;
    }

    public RestApiRequest<Order> postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType,
                                           TimeInForce timeInForce, String quantity, String price, String reduceOnly,
                                           String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType, String path) {
        RestApiRequest<Order> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("side", side)
                .putToUrl("positionSide", positionSide)
                .putToUrl("type", orderType)
                .putToUrl("timeInForce", timeInForce)
                .putToUrl("quantity", quantity)
                .putToUrl("price", price)
                .putToUrl("reduceOnly", reduceOnly)
                .putToUrl("newClientOrderId", newClientOrderId)
                .putToUrl("stopPrice", stopPrice)
                .putToUrl("workingType", workingType)
                .putToUrl("newOrderRespType", newOrderRespType);

        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            Order result = new Order();
            result.setClientOrderId(jsonWrapper.getString("clientOrderId"));
            result.setCumQuote(jsonWrapper.getBigDecimal("cumQuote"));
            result.setExecutedQty(jsonWrapper.getBigDecimal("executedQty"));
            result.setOrderId(jsonWrapper.getLong("orderId"));
            result.setOrigQty(jsonWrapper.getBigDecimal("origQty"));
            result.setPrice(jsonWrapper.getBigDecimal("price"));
            result.setReduceOnly(jsonWrapper.getBoolean("reduceOnly"));
            result.setSide(jsonWrapper.getString("side"));
            result.setPositionSide(jsonWrapper.getString("positionSide"));
            result.setStatus(jsonWrapper.getString("status"));
            result.setStopPrice(jsonWrapper.getBigDecimal("stopPrice"));
            result.setSymbol(jsonWrapper.getString("symbol"));
            result.setTimeInForce(jsonWrapper.getString("timeInForce"));
            result.setType(jsonWrapper.getString("type"));
            result.setUpdateTime(jsonWrapper.getLong("updateTime"));
            result.setWorkingType(jsonWrapper.getString("workingType"));
            return result;
        });
        return request;
    }

    public RestApiRequest<ResponseResult> changePositionSide(boolean dual, String path) {
        RestApiRequest<ResponseResult> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("dualSidePosition", String.valueOf(dual));
        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            ResponseResult result = new ResponseResult();
            result.setCode(jsonWrapper.getInteger("code"));
            result.setMsg(jsonWrapper.getString("msg"));
            return result;
        });
        return request;
    }

    public RestApiRequest<ResponseResult> changeMarginType(String symbolName, String marginType, String path) {
        RestApiRequest<ResponseResult> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbolName)
                .putToUrl("marginType", marginType);
        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            ResponseResult result = new ResponseResult();
            result.setCode(jsonWrapper.getInteger("code"));
            result.setMsg(jsonWrapper.getString("msg"));
            return result;
        });
        return request;
    }

    public RestApiRequest<JSONObject> addPositionMargin(String symbolName, int type, String amount, PositionSide positionSide, String path) {
        RestApiRequest<JSONObject> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbolName)
                .putToUrl("amount", amount)
                .putToUrl("positionSide", positionSide.name())
                .putToUrl("type", type);
        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            JSONObject result = new JSONObject();
            result.put("code", jsonWrapper.getInteger("code"));
            result.put("msg", jsonWrapper.getString("msg"));
            result.put("amount", jsonWrapper.getDouble("amount"));
            result.put("type", jsonWrapper.getInteger("type"));
            return result;
        });
        return request;
    }

    public RestApiRequest<List<WalletDeltaLog>> getPositionMarginHistory(String symbolName, int type, long startTime, long endTime, int limit, String path) {
        RestApiRequest<List<WalletDeltaLog>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbolName)
                .putToUrl("type", type)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<WalletDeltaLog> logs = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                WalletDeltaLog log = new WalletDeltaLog();
                log.setSymbol(item.getString("symbol"));
                log.setAmount(item.getString("amount"));
                log.setAsset(item.getString("asset"));
                log.setTime(item.getLong("time"));
                log.setPositionSide(item.getString("positionSide"));
                log.setType(item.getInteger("type"));
                logs.add(log);
            });
            return logs;
        });
        return request;
    }

    public RestApiRequest<JSONObject> getPositionSide(String path) {
        RestApiRequest<JSONObject> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            JSONObject result = new JSONObject();
            result.put("dualSidePosition", jsonWrapper.getBoolean("dualSidePosition"));
            return result;
        });
        return request;
    }

    public RestApiRequest<Order> cancelOrder(String symbol, Long orderId, String origClientOrderId, String path) {
        RestApiRequest<Order> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("orderId", orderId)
                .putToUrl("origClientOrderId", origClientOrderId);
        request.request = createRequestByDeleteWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            Order result = new Order();
            result.setClientOrderId(jsonWrapper.getString("clientOrderId"));
            result.setCumQuote(jsonWrapper.getBigDecimal("cumQuote"));
            result.setExecutedQty(jsonWrapper.getBigDecimal("executedQty"));
            result.setOrderId(jsonWrapper.getLong("orderId"));
            result.setOrigQty(jsonWrapper.getBigDecimal("origQty"));
            result.setPrice(jsonWrapper.getBigDecimal("price"));
            result.setReduceOnly(jsonWrapper.getBoolean("reduceOnly"));
            result.setSide(jsonWrapper.getString("side"));
            result.setPositionSide(jsonWrapper.getString("positionSide"));
            result.setStatus(jsonWrapper.getString("status"));
            result.setStopPrice(jsonWrapper.getBigDecimal("stopPrice"));
            result.setSymbol(jsonWrapper.getString("symbol"));
            result.setTimeInForce(jsonWrapper.getString("timeInForce"));
            result.setType(jsonWrapper.getString("type"));
            result.setUpdateTime(jsonWrapper.getLong("updateTime"));
            result.setWorkingType(jsonWrapper.getString("workingType"));
            return result;
        });
        return request;
    }

    public RestApiRequest<ResponseResult> cancelAllOpenOrder(String symbol, String path) {
        RestApiRequest<ResponseResult> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol);
        request.request = createRequestByDeleteWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            ResponseResult responseResult = new ResponseResult();
            responseResult.setCode(jsonWrapper.getInteger("code"));
            responseResult.setMsg(jsonWrapper.getString("msg"));
            return responseResult;
        });
        return request;
    }

    public RestApiRequest<List<Object>> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList, String path) {
        RestApiRequest<List<Object>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        builder.putToUrl("symbol", symbol);
        if (StringUtils.isNotBlank(orderIdList)) {
            builder.putToUrl("orderIdList", orderIdList);
        } else {
            builder.putToUrl("origClientOrderIdList", origClientOrderIdList);
        }
        request.request = createRequestByDeleteWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            JSONObject jsonObject = jsonWrapper.getJson();

            // success results
            List<Object> listResult = new ArrayList<>();
            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            jsonArray.forEach(obj -> {
                if (((JSONObject) obj).containsKey("code")) {
                    ResponseResult responseResult = new ResponseResult();
                    responseResult.setCode(((JSONObject) obj).getInteger("code"));
                    responseResult.setMsg(((JSONObject) obj).getString("msg"));
                    listResult.add(responseResult);
                } else {
                    Order o = new Order();
                    JSONObject jsonObj = (JSONObject) obj;
                    o.setClientOrderId(jsonObj.getString("clientOrderId"));
                    o.setCumQuote(jsonObj.getBigDecimal("cumQuote"));
                    o.setExecutedQty(jsonObj.getBigDecimal("executedQty"));
                    o.setOrderId(jsonObj.getLong("orderId"));
                    o.setOrigQty(jsonObj.getBigDecimal("origQty"));
                    o.setPrice(jsonObj.getBigDecimal("price"));
                    o.setReduceOnly(jsonObj.getBoolean("reduceOnly"));
                    o.setSide(jsonObj.getString("side"));
                    o.setPositionSide(jsonObj.getString("positionSide"));
                    o.setStatus(jsonObj.getString("status"));
                    o.setStopPrice(jsonObj.getBigDecimal("stopPrice"));
                    o.setSymbol(jsonObj.getString("symbol"));
                    o.setTimeInForce(jsonObj.getString("timeInForce"));
                    o.setType(jsonObj.getString("type"));
                    o.setUpdateTime(jsonObj.getLong("updateTime"));
                    o.setWorkingType(jsonObj.getString("workingType"));
                    listResult.add(o);
                }
            });
            return listResult;
        });
        return request;
    }

    public RestApiRequest<Order> getOrder(String symbol, Long orderId, String origClientOrderId, String path) {
        RestApiRequest<Order> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("orderId", orderId)
                .putToUrl("origClientOrderId", origClientOrderId);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            Order result = new Order();
            result.setClientOrderId(jsonWrapper.getString("clientOrderId"));
            result.setCumQuote(jsonWrapper.getBigDecimalOrDefault("cumQuote", jsonWrapper.getBigDecimalOrDefault("cummulativeQuoteQty", null)));
            result.setExecutedQty(jsonWrapper.getBigDecimalOrDefault("executedQty", null));
            result.setOrderId(jsonWrapper.getLong("orderId"));
            result.setOrigQty(jsonWrapper.getBigDecimal("origQty"));
            result.setPrice(jsonWrapper.getBigDecimal("price"));
            result.setReduceOnly(jsonWrapper.getBooleanOrDefault("reduceOnly", null));
            result.setSide(jsonWrapper.getString("side"));
            result.setPositionSide(jsonWrapper.getStringOrDefault("positionSide", null));
            result.setStatus(jsonWrapper.getString("status"));
            result.setStopPrice(jsonWrapper.getBigDecimal("stopPrice"));
            result.setSymbol(jsonWrapper.getString("symbol"));
            result.setTimeInForce(jsonWrapper.getString("timeInForce"));
            result.setType(jsonWrapper.getString("type"));
            result.setUpdateTime(jsonWrapper.getLong("updateTime"));
            result.setWorkingType(jsonWrapper.getStringOrDefault("workingType", null));
            return result;
        });
        return request;
    }

    public RestApiRequest<List<Order>> getOpenOrders(String symbol, String path) {
        RestApiRequest<List<Order>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<Order> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                Order element = new Order();
                element.setClientOrderId(item.getString("clientOrderId"));
                element.setCumQuote(item.getBigDecimal("cumQuote"));
                element.setExecutedQty(item.getBigDecimal("executedQty"));
                element.setOrderId(item.getLong("orderId"));
                element.setOrigQty(item.getBigDecimal("origQty"));
                element.setPrice(item.getBigDecimal("price"));
                element.setReduceOnly(item.getBoolean("reduceOnly"));
                element.setSide(item.getString("side"));
                element.setPositionSide(item.getString("positionSide"));
                element.setStatus(item.getString("status"));
                element.setStopPrice(item.getBigDecimal("stopPrice"));
                element.setSymbol(item.getString("symbol"));
                element.setTimeInForce(item.getString("timeInForce"));
                element.setType(item.getString("type"));
                element.setUpdateTime(item.getLong("updateTime"));
                element.setWorkingType(item.getString("workingType"));
                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<Order>> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<Order>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("orderId", orderId)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<Order> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                Order element = new Order();
                element.setClientOrderId(item.getString("clientOrderId"));
                element.setCumQuote(item.getBigDecimal("cumQuote"));
                element.setExecutedQty(item.getBigDecimal("executedQty"));
                element.setOrderId(item.getLong("orderId"));
                element.setOrigQty(item.getBigDecimal("origQty"));
                element.setPrice(item.getBigDecimal("price"));
                element.setReduceOnly(item.getBoolean("reduceOnly"));
                element.setSide(item.getString("side"));
                element.setPositionSide(item.getString("positionSide"));
                element.setStatus(item.getString("status"));
                element.setStopPrice(item.getBigDecimal("stopPrice"));
                element.setSymbol(item.getString("symbol"));
                element.setTimeInForce(item.getString("timeInForce"));
                element.setType(item.getString("type"));
                element.setUpdateTime(item.getLong("updateTime"));
                element.setWorkingType(item.getString("workingType"));
                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<AccountBalance>> getBalance(String path) {
        RestApiRequest<List<AccountBalance>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<AccountBalance> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                AccountBalance element = new AccountBalance();
                element.setAsset(item.getString("asset"));
                element.setBalance(item.getBigDecimal("balance"));
                element.setWithdrawAvailable(item.getBigDecimal("withdrawAvailable"));
                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<AccountInformation> getAccountInformation(String path) {
        RestApiRequest<AccountInformation> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            AccountInformation result = new AccountInformation();
            result.setCanDeposit(jsonWrapper.getBoolean("canDeposit"));
            result.setCanTrade(jsonWrapper.getBoolean("canTrade"));
            result.setCanWithdraw(jsonWrapper.getBoolean("canWithdraw"));
            result.setFeeTier(jsonWrapper.getBigDecimal("feeTier"));
            result.setMaxWithdrawAmount(jsonWrapper.getBigDecimal("maxWithdrawAmount"));
            result.setTotalInitialMargin(jsonWrapper.getBigDecimal("totalInitialMargin"));
            result.setTotalMaintMargin(jsonWrapper.getBigDecimal("totalMaintMargin"));
            result.setTotalMarginBalance(jsonWrapper.getBigDecimal("totalMarginBalance"));
            result.setTotalOpenOrderInitialMargin(jsonWrapper.getBigDecimal("totalOpenOrderInitialMargin"));
            result.setTotalPositionInitialMargin(jsonWrapper.getBigDecimal("totalPositionInitialMargin"));
            result.setTotalUnrealizedProfit(jsonWrapper.getBigDecimal("totalUnrealizedProfit"));
            result.setTotalWalletBalance(jsonWrapper.getBigDecimal("totalWalletBalance"));
            result.setUpdateTime(jsonWrapper.getLong("updateTime"));

            List<Asset> assetList = new LinkedList<>();
            JsonWrapperArray assetArray = jsonWrapper.getJsonArray("assets");
            assetArray.forEach((item) -> {
                Asset element = new Asset();
                element.setAsset(item.getString("asset"));
                element.setInitialMargin(item.getBigDecimal("initialMargin"));
                element.setMaintMargin(item.getBigDecimal("maintMargin"));
                element.setMarginBalance(item.getBigDecimal("marginBalance"));
                element.setMaxWithdrawAmount(item.getBigDecimal("maxWithdrawAmount"));
                element.setOpenOrderInitialMargin(item.getBigDecimal("openOrderInitialMargin"));
                element.setPositionInitialMargin(item.getBigDecimal("positionInitialMargin"));
                element.setUnrealizedProfit(item.getBigDecimal("unrealizedProfit"));
                assetList.add(element);
            });
            result.setAssets(assetList);

            List<Position> positionList = new LinkedList<>();
            JsonWrapperArray positionArray = jsonWrapper.getJsonArray("positions");
            positionArray.forEach((item) -> {
                Position element = new Position();
                element.setIsolated(item.getBoolean("isolated"));
                element.setLeverage(item.getBigDecimal("leverage"));
                element.setInitialMargin(item.getBigDecimal("initialMargin"));
                element.setMaintMargin(item.getBigDecimal("maintMargin"));
                element.setOpenOrderInitialMargin(item.getBigDecimal("openOrderInitialMargin"));
                element.setPositionInitialMargin(item.getBigDecimal("positionInitialMargin"));
                element.setSymbol(item.getString("symbol"));
                element.setUnrealizedProfit(item.getBigDecimal("unrealizedProfit"));
                element.setEntryPrice(item.getString("entryPrice"));
                element.setMaxNotional(item.getString("maxNotional"));
                element.setPositionSide(item.getString("positionSide"));
                positionList.add(element);
            });
            result.setPositions(positionList);
            return result;
        });
        return request;
    }

    public RestApiRequest<Leverage> changeInitialLeverage(String symbol, Integer leverage, String path) {
        RestApiRequest<Leverage> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("leverage", leverage);
        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            Leverage result = new Leverage();
            result.setLeverage(jsonWrapper.getBigDecimal("leverage"));
            if (jsonWrapper.getString("maxNotionalValue").equals("INF")) {
                result.setMaxNotionalValue(Double.POSITIVE_INFINITY);
            } else {
                result.setMaxNotionalValue(jsonWrapper.getDouble("maxNotionalValue"));
            }
            result.setSymbol(jsonWrapper.getString("symbol"));
            return result;
        });
        return request;
    }

    public RestApiRequest<List<PositionRisk>> getPositionRisk(String path) {
        RestApiRequest<List<PositionRisk>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<PositionRisk> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                PositionRisk element = new PositionRisk();
                element.setEntryPrice(item.getBigDecimal("entryPrice"));
                element.setLeverage(item.getBigDecimal("leverage"));
                if (item.getString("maxNotionalValue").equals("INF")) {
                    element.setMaxNotionalValue(Double.POSITIVE_INFINITY);
                } else {
                    element.setMaxNotionalValue(item.getDouble("maxNotionalValue"));
                }
                element.setLiquidationPrice(item.getBigDecimal("liquidationPrice"));
                element.setMarkPrice(item.getBigDecimal("markPrice"));
                element.setPositionAmt(item.getBigDecimal("positionAmt"));
                element.setSymbol(item.getString("symbol"));
                element.setIsolatedMargin(item.getString("isolatedMargin"));
                element.setPositionSide(item.getString("positionSide"));
                element.setMarginType(item.getString("marginType"));
                element.setUnrealizedProfit(item.getBigDecimal("unRealizedProfit"));
                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<MyTrade>> getAccountTrades(String symbol, Long startTime, Long endTime,
                                                          Long fromId, Integer limit, String path) {
        RestApiRequest<List<MyTrade>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("fromId", fromId)
                .putToUrl("limit", limit);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<MyTrade> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                MyTrade element = new MyTrade();
                element.setIsBuyer(item.getBoolean("buyer"));
                element.setCommission(item.getBigDecimal("commission"));
                element.setCommissionAsset(item.getString("commissionAsset"));
                element.setCounterPartyId(item.getLongOrDefault("counterPartyId", null));
                element.setOrderId(item.getLong("orderId"));
                element.setIsMaker(item.getBoolean("maker"));
                element.setOrderId(item.getLong("orderId"));
                element.setPrice(item.getBigDecimal("price"));
                element.setQty(item.getBigDecimal("qty"));
                element.setQuoteQty(item.getBigDecimal("quoteQty"));
                element.setRealizedPnl(item.getBigDecimal("realizedPnl"));
                element.setSide(item.getString("side"));
                element.setPositionSide(item.getString("positionSide"));
                element.setSymbol(item.getString("symbol"));
                element.setTime(item.getLong("time"));
                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<Income>> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime,
                                                         Integer limit, String path) {
        RestApiRequest<List<Income>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("incomeType", incomeType)
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<Income> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                Income element = new Income();
                element.setSymbol(item.getString("symbol"));
                element.setIncomeType(item.getString("incomeType"));
                element.setIncome(item.getBigDecimal("income"));
                element.setAsset(item.getString("asset"));
                element.setTime(item.getLong("time"));
                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<String> startUserDataStream(String path) {
        RestApiRequest<String> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();

        request.request = createRequestByPost(path, builder);

        request.jsonParser = (jsonWrapper -> {
            String result = jsonWrapper.getString("listenKey");
            return result;
        });
        return request;
    }

    public RestApiRequest<String> keepUserDataStream(String listenKey, String path) {
        RestApiRequest<String> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("listenKey", listenKey);

        request.request = createRequestByPut(path, builder);

        request.jsonParser = (jsonWrapper -> {
            String result = "Ok";
            return result;
        });
        return request;
    }

    public RestApiRequest<String> closeUserDataStream(String listenKey, String path) {
        RestApiRequest<String> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("listenKey", listenKey);

        request.request = createRequestByDelete(path, builder);

        request.jsonParser = (jsonWrapper -> {
            String result = "Ok";
            return result;
        });
        return request;
    }

    public RestApiRequest<List<OpenInterestStat>> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<OpenInterestStat>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("period", period.getCode())
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);


//        request.request = createRequestByGetWithSignature("/gateway-api//v1/public/future/data/openInterestHist", builder);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<OpenInterestStat> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                OpenInterestStat element = new OpenInterestStat();
                element.setSymbol(item.getString("symbol"));
                element.setSumOpenInterest(item.getBigDecimal("sumOpenInterest"));
                element.setSumOpenInterestValue(item.getBigDecimal("sumOpenInterestValue"));
                element.setTimestamp(item.getLong("timestamp"));

                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<CommonLongShortRatio>> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<CommonLongShortRatio>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("period", period.getCode())
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);


//        request.request = createRequestByGetWithSignature("/gateway-api//v1/public/future/data/topLongShortAccountRatio", builder);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<CommonLongShortRatio> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                CommonLongShortRatio element = new CommonLongShortRatio();
                element.setSymbol(item.getString("symbol"));
                element.setLongAccount(item.getBigDecimal("longAccount"));
                element.setLongShortRatio(item.getBigDecimal("longShortRatio"));
                element.setShortAccount(item.getBigDecimal("shortAccount"));
                element.setTimestamp(item.getLong("timestamp"));

                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<CommonLongShortRatio>> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<CommonLongShortRatio>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("period", period.getCode())
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);


//        request.request = createRequestByGetWithSignature("/gateway-api//v1/public/future/data/topLongShortPositionRatio", builder);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<CommonLongShortRatio> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                CommonLongShortRatio element = new CommonLongShortRatio();
                element.setSymbol(item.getString("symbol"));
                element.setLongAccount(item.getBigDecimal("longAccount"));
                element.setLongShortRatio(item.getBigDecimal("longShortRatio"));
                element.setShortAccount(item.getBigDecimal("shortAccount"));
                element.setTimestamp(item.getLong("timestamp"));

                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<CommonLongShortRatio>> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<CommonLongShortRatio>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("period", period.getCode())
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);


//        request.request = createRequestByGetWithSignature("/gateway-api//v1/public/future/data/globalLongShortAccountRatio", builder);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<CommonLongShortRatio> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                CommonLongShortRatio element = new CommonLongShortRatio();
                element.setSymbol(item.getString("symbol"));
                element.setLongAccount(item.getBigDecimal("longAccount"));
                element.setLongShortRatio(item.getBigDecimal("longShortRatio"));
                element.setShortAccount(item.getBigDecimal("shortAccount"));
                element.setTimestamp(item.getLong("timestamp"));

                result.add(element);
            });
            return result;
        });
        return request;
    }

    public RestApiRequest<List<TakerLongShortStat>> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit, String path) {
        RestApiRequest<List<TakerLongShortStat>> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("symbol", symbol)
                .putToUrl("period", period.getCode())
                .putToUrl("startTime", startTime)
                .putToUrl("endTime", endTime)
                .putToUrl("limit", limit);


//        request.request = createRequestByGetWithSignature("/gateway-api//v1/public/future/data/globalLongShortAccountRatio", builder);
        request.request = createRequestByGetWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            List<TakerLongShortStat> result = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("data");
            dataArray.forEach((item) -> {
                TakerLongShortStat element = new TakerLongShortStat();
                element.setBuySellRatio(item.getBigDecimal("buySellRatio"));
                element.setSellVol(item.getBigDecimal("sellVol"));
                element.setBuyVol(item.getBigDecimal("buyVol"));
                element.setTimestamp(item.getLong("timestamp"));

                result.add(element);
            });
            return result;
        });
        return request;
    }

}
