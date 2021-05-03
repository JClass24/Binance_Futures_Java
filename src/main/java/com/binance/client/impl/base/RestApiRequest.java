package com.binance.client.impl.base;

import okhttp3.Request;

public class RestApiRequest<T> {

    public Request request;
    RestApiJsonParser<T> jsonParser;
}
