package com.binance.client.impl.rest.common;

import com.binance.client.RequestOptions;
import com.binance.client.impl.base.RestApiRequest;
import com.binance.client.impl.base.RestApiRequestImpl;
import com.binance.client.impl.utils.UrlParamsBuilder;
import com.binance.client.model.enums.TransferType;

public class CommonRestApiRequestImpl extends RestApiRequestImpl {

    public CommonRestApiRequestImpl(String apiKey, String secretKey, RequestOptions options) {
        super(apiKey, secretKey, options);
    }

    public RestApiRequest<String> transfer(TransferType type, String asset, String amount) {
        RestApiRequest<String> request = new RestApiRequest<>();
        UrlParamsBuilder builder = UrlParamsBuilder.build()
                .putToUrl("type", type)
                .putToUrl("asset", asset)
                .putToUrl("amount", amount);
        request.request = createRequestByGet("/sapi/v1/asset/transfer", builder);

        request.jsonParser = (jsonWrapper -> jsonWrapper.getString("tranId"));
        return request;
    }
}
