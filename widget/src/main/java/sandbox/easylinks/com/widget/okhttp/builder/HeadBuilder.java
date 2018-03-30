package sandbox.easylinks.com.widget.okhttp.builder;


import sandbox.easylinks.com.widget.okhttp.OkHttpUtils;
import sandbox.easylinks.com.widget.okhttp.request.OtherRequest;
import sandbox.easylinks.com.widget.okhttp.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
