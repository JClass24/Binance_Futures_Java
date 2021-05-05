package com.binance.client.impl.rest.common;

import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.model.enums.TransferType;
import com.binance.client.model.trade.SpotOrder;
import com.binance.client.rest.CommonSyncRequestClient;

public class CommonSyncRequestImpl implements CommonSyncRequestClient {

    private final CommonRestApiRequestImpl requestImpl;

    public CommonSyncRequestImpl(CommonRestApiRequestImpl requestImpl) {
        this.requestImpl = requestImpl;
    }

    @Override
    public String transfer(TransferType type, String asset, String amount) {
        return RestApiInvoker.callSync(requestImpl.transfer(type, asset, amount));
    }

    @Override
    public SpotOrder placeSpotLimitBuyOrder(String symbol, String quantity, String price, String newClientOrderId) {
        return null;
    }

    @Override
    public SpotOrder placeSpotLimitSellOrder(String symbol, String quantity, String price, String newClientOrderId) {
        return null;
    }
}
