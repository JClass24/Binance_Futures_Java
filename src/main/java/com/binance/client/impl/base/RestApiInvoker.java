package com.binance.client.impl.base;

import com.binance.client.exception.BinanceApiException;
import com.binance.client.impl.utils.JsonWrapper;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public abstract class RestApiInvoker {

    private static final Logger log = LoggerFactory.getLogger(RestApiInvoker.class);
    private static OkHttpClient client = new OkHttpClient().newBuilder().callTimeout(3, TimeUnit.SECONDS).connectTimeout(3, TimeUnit.SECONDS).pingInterval(15, TimeUnit.SECONDS).build();

    public static void initClient(String ip, Integer port, int interval) {
        client = new OkHttpClient().newBuilder().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port))).callTimeout(3, TimeUnit.SECONDS).connectTimeout(3, TimeUnit.SECONDS).pingInterval(interval, TimeUnit.SECONDS).build();
    }

    public static OkHttpClient getClient() {
        return client;
    }

    static void checkResponse(JsonWrapper json) {
        try {
            if (json.containKey("success")) {
                boolean success = json.getBoolean("success");
                if (!success) {
                    String err_code = json.getStringOrDefault("code", "");
                    String err_msg = json.getStringOrDefault("msg", "");
                    if ("".equals(err_code)) {
                        throw new BinanceApiException(BinanceApiException.EXEC_ERROR, "[Executing] " + err_msg);
                    } else {
                        throw new BinanceApiException(BinanceApiException.EXEC_ERROR,
                                "[Executing] " + err_code + ": " + err_msg);
                    }
                }
            } else if (json.containKey("code")) {

                int code = json.getInteger("code");
                if (code != 200) {
                    String message = json.getStringOrDefault("msg", "");
                    throw new BinanceApiException(BinanceApiException.EXEC_ERROR,
                            "[Executing] " + code + ": " + message);
                }
            }
        } catch (BinanceApiException e) {
            throw e;
        } catch (Exception e) {
            throw new BinanceApiException(BinanceApiException.RUNTIME_ERROR,
                    "[Invoking] Unexpected error: " + e.getMessage());
        }
    }

    public static <T> T callSync(RestApiRequest<T> request) {
        try {
            String str;
            log.debug("Request URL " + request.request.url());
            Response response = client.newCall(request.request).execute();
            // System.out.println(response.body().string());
            if (response != null && response.body() != null) {
                str = response.body().string();
                response.close();
            } else {
                throw new BinanceApiException(BinanceApiException.ENV_ERROR,
                        "[Invoking] Cannot get the response from server");
            }
            log.debug("Response =====> " + str);
            JsonWrapper jsonWrapper = JsonWrapper.parseFromString(str);
            checkResponse(jsonWrapper);
            return request.jsonParser.parseJson(jsonWrapper);
        } catch (BinanceApiException e) {
            throw e;
        } catch (Exception e) {
            throw new BinanceApiException(BinanceApiException.ENV_ERROR,
                    "[Invoking] Unexpected error: " + e.getMessage());
        }
    }

    static WebSocket createWebSocket(Request request, WebSocketListener listener) {
        return client.newWebSocket(request, listener);
    }

}
