package sandbox.easylinks.com.miaozu.common.net.typecallback;


import com.alibaba.fastjson.JSON;

import org.json.JSONArray;
import org.json.JSONException;

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
        LogUtils.json(string);
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        List<T> list = null;
        try {
            JSONArray jsonArray = new JSONArray(string);
            list = JSON.parseArray(jsonArray.toString(), entityClass);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
}
