package com.binance.client.impl.rest.spot;

import com.binance.client.RequestOptions;
import com.binance.client.impl.base.BaseRestApiRequestImpl;
import com.binance.client.impl.base.RestApiRequest;
import com.binance.client.impl.utils.UrlParamsBuilder;
import com.binance.client.model.enums.*;
import com.binance.client.model.trade.Order;

public class SpotRestApiRequestImpl extends BaseRestApiRequestImpl {

    public SpotRestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        super(apiKey, secretKey, options);
    }

    public RestApiRequest<Order> postOrder(String symbol, OrderSide side, OrderType orderType,
                                           TimeInForce timeInForce, String quantity, String  quoteOrderQty,String price,
                                           String newClientOrderId, String stopPrice, String  icebergQty, NewOrderRespType newOrderRespType, String path) {
        RestApiRequest<Order> request = new RestApiRequest<>();
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

        request.request = createRequestByPostWithSignature(path, builder);

        request.jsonParser = (jsonWrapper -> {
            Order result = new Order();
            result.setClientOrderId(jsonWrapper.getString("clientOrderId"));
            return result;
        });
        return request;
    }

}
