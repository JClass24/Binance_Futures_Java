package com.binance.client.impl.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binance.client.RequestOptions;
import com.binance.client.exception.BinanceApiException;
import com.binance.client.impl.utils.JsonWrapperArray;
import com.binance.client.impl.utils.UrlParamsBuilder;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;
import okhttp3.Request;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RestApiRequestImpl {

    private String apiKey;
    private String secretKey;
    private String serverUrl;

    public RestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
        this.serverUrl = options.getUrl();
    }

    protected Request createRequestByGet(String address, UrlParamsBuilder builder) {
        System.out.println(serverUrl);
        return createRequestByGet(serverUrl, address, builder);
    }

    protected Request createRequestByGet(String url, String address, UrlParamsBuilder builder) {
        return createRequest(url, address, builder);
    }

    protected Request createRequest(String url, String address, UrlParamsBuilder builder) {
        String requestUrl = url + address;
        System.out.println(requestUrl);
        if (builder != null) {
            if (builder.hasPostParam()) {
                return new Request.Builder().url(requestUrl).post(builder.buildPostBody())
                        .addHeader("Content-Type", "application/json")
                        .addHeader("client_SDK_Version", "binance_futures-1.0.1-java").build();
            } else {
                return new Request.Builder().url(requestUrl + builder.buildUrl())
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader("client_SDK_Version", "binance_futures-1.0.1-java").build();
            }
        } else {
            return new Request.Builder().url(requestUrl).addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("client_SDK_Version", "binance_futures-1.0.1-java")
                    .build();
        }
    }

    protected Request createRequestWithSignature(String url, String address, UrlParamsBuilder builder) {
        if (builder == null) {
            throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR,
                    "[Invoking] Builder is null when create request with Signature");
        }
        new ApiSignature().createSignature(apiKey, secretKey, builder);
        return createRequestWithApikey(url, address, builder);
    }

    protected Request createRequestByPostWithSignature(String address, UrlParamsBuilder builder) {
        return createRequestWithSignature(serverUrl, address, builder.setMethod("POST"));
    }

    protected Request createRequestByPost(String address, UrlParamsBuilder builder) {
        return createRequestWithApikey(serverUrl, address, builder.setMethod("POST"));
    }

    protected Request createRequestByGetWithSignature(String address, UrlParamsBuilder builder) {
        return createRequestWithSignature(serverUrl, address, builder);
    }

    protected Request createRequestByPutWithSignature(String address, UrlParamsBuilder builder) {
        return createRequestWithSignature(serverUrl, address, builder.setMethod("PUT"));
    }

    protected Request createRequestByDeleteWithSignature(String address, UrlParamsBuilder builder) {
        return createRequestWithSignature(serverUrl, address, builder.setMethod("DELETE"));
    }

    protected Request createRequestByPut(String address, UrlParamsBuilder builder) {
        return createRequestWithApikey(serverUrl, address, builder.setMethod("PUT"));
    }

    protected Request createRequestByDelete(String address, UrlParamsBuilder builder) {
        return createRequestWithApikey(serverUrl, address, builder.setMethod("DELETE"));
    }

    protected Request createRequestWithApikey(String url, String address, UrlParamsBuilder builder) {
        if (builder == null) {
            throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR,
                    "[Invoking] Builder is null when create request with Signature");
        }
        String requestUrl = url + address;
        requestUrl += builder.buildUrl();
        if (builder.hasPostParam()) {
            return new Request.Builder().url(requestUrl)
                    .post(builder.buildPostBody())
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-MBX-APIKEY", apiKey)
                    .addHeader("client_SDK_Version", "binance_futures-1.0.1-java")
                    .build();
        } else if (builder.checkMethod("DELETE")) {
            return new Request.Builder().url(requestUrl)
                    .delete()
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("X-MBX-APIKEY", apiKey)
                    .addHeader("client_SDK_Version", "binance_futures-1.0.1-java")
                    .build();
        } else if (builder.checkMethod("PUT")) {
            return new Request.Builder().url(requestUrl)
                    .put(builder.buildPostBody())
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("X-MBX-APIKEY", apiKey)
                    .addHeader("client_SDK_Version", "binance_futures-1.0.1-java")
                    .build();
        } else {
            return new Request.Builder().url(requestUrl)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .addHeader("X-MBX-APIKEY", apiKey)
                    .addHeader("client_SDK_Version", "binance_futures-1.0.1-java")
                    .build();
        }
    }

    protected Request createRequestByGetWithApikey(String address, UrlParamsBuilder builder) {
        return createRequestWithApikey(serverUrl, address, builder);
    }

    public RestApiRequest<ExchangeInformation> getExchangeInformation(String path) {
        RestApiRequest<ExchangeInformation> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build();
        request.request = createRequestByGet(path, builder);

        request.jsonParser = (jsonWrapper -> {
            ExchangeInformation result = new ExchangeInformation();
            result.setTimezone(jsonWrapper.getString("timezone"));
            result.setServerTime(jsonWrapper.getLong("serverTime"));

            List<RateLimit> elementList = new LinkedList<>();
            JsonWrapperArray dataArray = jsonWrapper.getJsonArray("rateLimits");
            dataArray.forEach((item) -> {
                RateLimit element = new RateLimit();
                element.setRateLimitType(item.getString("rateLimitType"));
                element.setInterval(item.getString("interval"));
                element.setIntervalNum(item.getLong("intervalNum"));
                element.setLimit(item.getLong("limit"));
                elementList.add(element);
            });
            result.setRateLimits(elementList);

            List<ExchangeFilter> filterList = new LinkedList<>();
            JsonWrapperArray filterArray = jsonWrapper.getJsonArray("exchangeFilters");
            filterArray.forEach((item) -> {
                ExchangeFilter filter = new ExchangeFilter();
                filter.setFilterType(item.getString("filterType"));
                filter.setMaxNumOrders(item.getLong("maxNumOrders"));
                filter.setMaxNumAlgoOrders(item.getLong("maxNumAlgoOrders"));
                filterList.add(filter);
            });
            result.setExchangeFilters(filterList);

            List<ExchangeInfoEntry> symbolList = new LinkedList<>();
            JsonWrapperArray symbolArray = jsonWrapper.getJsonArray("symbols");
            symbolArray.forEach((item) -> {
                ExchangeInfoEntry symbol = new ExchangeInfoEntry();
                symbol.setSymbol(item.getString("symbol"));
                symbol.setStatus(item.getStringOrDefault("status", null));
                symbol.setMaintMarginPercent(item.getBigDecimal("maintMarginPercent"));
                symbol.setRequiredMarginPercent(item.getBigDecimal("requiredMarginPercent"));
                symbol.setBaseAsset(item.getString("baseAsset"));
                symbol.setQuoteAsset(item.getString("quoteAsset"));
                symbol.setPricePrecision(item.getLong("pricePrecision"));
                symbol.setQuantityPrecision(item.getLong("quantityPrecision"));
                symbol.setBaseAssetPrecision(item.getLong("baseAssetPrecision"));
                symbol.setQuotePrecision(item.getLong("quotePrecision"));
                symbol.setPair(item.getStringOrDefault("pair", null));
                symbol.setContractStatus(item.getStringOrDefault("contractStatus", null));
                symbol.setContractSize(item.getIntegerOrDefault("contractSize", null));
                symbol.setContractType(item.getStringOrDefault("contractType", null));
                symbol.setDeliveryDate(item.getLongOrDefault("deliveryDate", null));
                symbol.setMarginAsset(item.getStringOrDefault("marginAsset", null));
                symbol.setOnboardDate(item.getLongOrDefault("onboardDate", null));
                symbol.setUnderlyingType(item.getStringOrDefault("underlyingType", null));
                symbol.setOrderTypes(item.getJsonArray("orderTypes").convert2StringList());
                symbol.setTimeInForce(item.getJsonArray("orderTypes").convert2StringList());
                List<List<Map<String, String>>> valList = new LinkedList<>();
                JsonWrapperArray valArray = item.getJsonArray("filters");
                valArray.forEach((val) -> {
                    valList.add(val.convert2DictList());
                });
                symbol.setFilters(valList);
                symbolList.add(symbol);
            });
            result.setSymbols(symbolList);

            return result;
        });
        return request;
    }
}
