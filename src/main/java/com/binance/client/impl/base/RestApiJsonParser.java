package com.binance.client.impl.base;

import com.binance.client.impl.utils.JsonWrapper;

@FunctionalInterface
public interface RestApiJsonParser<T> {

    T parseJson(JsonWrapper json);
}
