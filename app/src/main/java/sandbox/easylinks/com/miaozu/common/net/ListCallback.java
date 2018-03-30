package sandbox.easylinks.com.miaozu.common.net;


import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import okhttp3.Response;
import sandbox.easylinks.com.widget.okhttp.callback.Callback;
import sandbox.easylinks.com.widget.utils.LogUtils;

public abstract class ListCallback<T> extends Callback<List<T>> {
    @Override
    public List<T> parseNetworkResponse(Response response, int id) throws IOException {
        String string = response.body().string();
        string = "[{\n" +
                "\t\t\"name\": \"ding\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"name\": \"jia\"\n" +
                "\t}\n" +
                "]";
        LogUtils.json(string);
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        List<T> list = JSON.parseArray(string, entityClass);
        return list;
    }
}
