package com.example.xw.myfirstapplication.myWebView;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Administrator on 2016/8/28.
 */
public class MyWebViewClient extends WebViewClient {


    public MyWebViewClient() {
        super();
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //在网页上的所有加载都经过这个方法,这个函数我们可以做很多操作。
        Log.v("MyWebViewClient", "shouldOverrideUrlLoading(WebView view, String url)");
        return super.shouldOverrideUrlLoading(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        //在网页上的所有加载都经过这个方法,这个函数我们可以做很多操作。
        Log.v("MyWebViewClient", "shouldOverrideUrlLoading(WebView view, WebResourceRequest request)");
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        //这个事件就是开始载入页面调用的，我们可以设定一个loading的页面，告诉用户程序在等待网络响应。
        Log.v("MyWebViewClient", "onPageStarted(WebView view, String url, Bitmap favicon)");
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        //在页面加载结束时调用。同样道理，我们可以关闭loading 条，切换程序动作。
        Log.v("MyWebViewClient", "onPageFinished(WebView view, String url)");
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        // 在加载页面资源时会调用，每一个资源（比如图片）的加载都会调用一次。
        Log.v("MyWebViewClient", "onLoadResource(WebView view, String url)");
        super.onLoadResource(view, url);
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        Log.v("MyWebViewClient", "onPageCommitVisible(WebView view, String url)");
        super.onPageCommitVisible(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        Log.v("MyWebViewClient", "WebResourceResponse shouldInterceptRequest(WebView view, String url)");
        return super.shouldInterceptRequest(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Log.v("MyWebViewClient", "WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request)");
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
        Log.v("MyWebViewClient", "onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg)");
        super.onTooManyRedirects(view, cancelMsg, continueMsg);
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        // (报告错误信息)
        Log.v("MyWebViewClient", "onReceivedError(WebView view, int errorCode, String description, String failingUrl)");
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        // (报告错误信息)
        Log.v("MyWebViewClient", "onReceivedError(WebView view, WebResourceRequest request, WebResourceError error)");
        super.onReceivedError(view, request, error);
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        Log.v("MyWebViewClient", "onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse)");
        super.onReceivedHttpError(view, request, errorResponse);
    }

    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        //(应用程序重新请求网页数据)
        Log.v("MyWebViewClient", "onFormResubmission(WebView view, Message dontResend, Message resend)");
        super.onFormResubmission(view, dontResend, resend);
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        //(更新历史记录)
        Log.v("MyWebViewClient", "doUpdateVisitedHistory(WebView view, String url, boolean isReload)");
        super.doUpdateVisitedHistory(view, url, isReload);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        //重写此方法可以让webview处理https请求。
        Log.v("MyWebViewClient", "onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)");
        super.onReceivedSslError(view, handler, error);
    }

    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        Log.v("MyWebViewClient", "onReceivedClientCertRequest(WebView view, ClientCertRequest request)");
        super.onReceivedClientCertRequest(view, request);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        //（获取返回信息授权请求）
        Log.v("MyWebViewClient", "onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm)");
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        Log.v("MyWebViewClient", "shouldOverrideKeyEvent(WebView view, KeyEvent event)");
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        Log.v("MyWebViewClient", "onUnhandledKeyEvent(WebView view, KeyEvent event)");
        //（Key事件未被加载时调用）
        super.onUnhandledKeyEvent(view, event);
    }

    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        // (WebView发生改变时调用)
        Log.v("MyWebViewClient", "onScaleChanged(WebView view, float oldScale, float newScale)");
        super.onScaleChanged(view, oldScale, newScale);
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        Log.v("MyWebViewClient", "onReceivedLoginRequest(WebView view, String realm, String account, String args)");
        super.onReceivedLoginRequest(view, realm, account, args);
    }
}
