package com.binance.client.impl.rest.common;

import com.binance.client.impl.base.RestApiInvoker;
import com.binance.client.model.enums.TransferType;
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
}
