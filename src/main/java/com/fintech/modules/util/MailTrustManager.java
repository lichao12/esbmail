package com.fintech.modules.util;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * @Description: 邮箱信证管理
 * @author lc
 * @date 2018年6月26日
 */
public class MailTrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] cert, String authType) {
        // everything is trusted
    }

    public void checkServerTrusted(X509Certificate[] cert, String authType) {
        // everything is trusted
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}