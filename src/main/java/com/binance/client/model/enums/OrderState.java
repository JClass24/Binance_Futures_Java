package com.binance.client.model.enums;

/**
 * NEW 新建订单
 * PARTIALLY_FILLED 部分成交
 * FILLED 全部成交
 * CANCELED 已撤销
 * REJECTED 订单被拒绝
 * EXPIRED 订单过期(根据timeInForce参数规则)
 */
public enum OrderState {
    NEW, PARTIALLY_FILLED, FILLED, CANCELED, REJECTED, EXPIRED
}
