package sandbox.easylinks.com.miaozu.common.net;

import android.support.annotation.Nullable;

import java.util.HashMap;

import okhttp3.MediaType;
import sandbox.easylinks.com.widget.okhttp.OkHttpUtils;
import sandbox.easylinks.com.widget.okhttp.callback.Callback;


public class NetRequestUtils {

    public static final String JSONSTRING = "JSONSTRING";

    public static void request(
            String url,
            String method,
            @Nullable HashMap<String, String> header,
            @Nullable HashMap<String, String> params,
            Callback callback) {

        //设置默认头
//        HashMap defaultHeaderParams = DefaultHeaderUtils.createDefaultHeaders(MyApplication.context, header);
        HashMap defaultHeaderParams = null;

        if (OkHttpUtils.METHOD.DELETE.equals(method)) {
            requestDelete(url, defaultHeaderParams, params, callback);
        } else if (OkHttpUtils.METHOD.HEAD.equals(method)) {
            requestHead(url, defaultHeaderParams, params, callback);
        } else if (OkHttpUtils.METHOD.PUT.equals(method)) {
            requestPut(url, defaultHeaderParams, params, callback);
        } else if (OkHttpUtils.METHOD.PATCH.equals(method)) {
            requestPatch(url, defaultHeaderParams, params, callback);
        } else if (OkHttpUtils.METHOD.POST.equals(method)) {
            requestPost(url, defaultHeaderParams, params, callback);
        } else if (OkHttpUtils.METHOD.GET.equals(method)) {
            requestGet(url, defaultHeaderParams, params, callback);
        } else if (OkHttpUtils.METHOD.JSON.equals(method)) {
            requestJson(url, defaultHeaderParams, params, callback);
        }

    }

    public static void requestGet(String url,
                                  HashMap headers,
                                  HashMap params,
                                  Callback callback) {

        if (params != null) {
            StringBuffer stringBuffer = new StringBuffer(url);
            int i = 0;
            for (Object key : params.keySet()) {
                if (i == 0) {
                    stringBuffer.append("?");
                } else {
                    stringBuffer.append("&");
                }
                stringBuffer.append(key);
                stringBuffer.append("=");
                stringBuffer.append((String) params.get(key));
                i++;
            }
            url = stringBuffer.toString();
        }

        OkHttpUtils
                .get()
                .headers(headers)
                .url(url)
                .build()
                .execute(callback);
    }

    public static void requestPost(String url,
                                   HashMap headers,
                                   HashMap params,
                                   Callback callback) {
        OkHttpUtils
                .post()
                .headers(headers)
                .params(params)
                .url(url)
                .build()
                .execute(callback);

    }

    public static void requestDelete(String url,
                                     HashMap headers,
                                     HashMap params,
                                     Callback callback) {
        OkHttpUtils
                .delete()
                .headers(headers)
                .url(url)
                .build()
                .execute(callback);

    }

    public static void requestPatch(String url,
                                    HashMap headers,
                                    HashMap params,
                                    Callback callback) {
        OkHttpUtils
                .patch()
                .headers(headers)
                .url(url)
                .build()
                .execute(callback);

    }

    public static void requestHead(String url,
                                   HashMap headers,
                                   HashMap params,
                                   Callback callback) {
        OkHttpUtils
                .head()
                .headers(headers)
                .params(params)
                .url(url)
                .build()
                .execute(callback);

    }

    public static void requestPut(String url,
                                  HashMap headers,
                                  HashMap params,
                                  Callback callback) {
        OkHttpUtils
                .put()
                .headers(headers)
                .url(url)
                .build()
                .execute(callback);

    }

    public static void requestJson(String url,
                                   HashMap headers,
                                   HashMap params,
                                   Callback callback) {
        String content = "";
        if (params != null) {
            content = (String) params.get(JSONSTRING);
        }

        OkHttpUtils
                .postString()
                .headers(headers)
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(content)
                .build()
                .execute(callback);

    }
}
