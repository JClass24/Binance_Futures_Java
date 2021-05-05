package com.binance.client.model.enums;

/**
 * MAIN_UMFUTURE 现货钱包转向U本位合约钱包 MAIN_CMFUTURE 现货钱包转向币本位合约钱包 UMFUTURE_MAIN U本位合约钱包转向现货钱包 CMFUTURE_MAIN 币本位合约钱包转向现货钱包
 */
public enum TransferType {
    MAIN_UMFUTURE,
    MAIN_CMFUTURE,
    UMFUTURE_MAIN,
    CMFUTURE_MAIN
}