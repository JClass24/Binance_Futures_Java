package com.binance.client.impl.base;

import okhttp3.Request;

public class RestApiRequest<T> {

    public Request request;
    public RestApiJsonParser<T> jsonParser;
}
