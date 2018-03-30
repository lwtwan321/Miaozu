package sandbox.easylinks.com.widget.okhttp.callback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Response;

/**
 * Created by JimGong on 2016/6/23.
 */

public abstract class GenericsCallback<T> extends Callback<T> {
    IGenericsSerializator mGenericsSerializator;

    public GenericsCallback(IGenericsSerializator serializator) {
        mGenericsSerializator = serializator;
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws IOException {
        String string = response.body().string();
//        string = "{\n" +
//                "\t\"name\": \"dingjiahui\"\n" +
//                "}";
        Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (entityClass == String.class) {
            return (T) string;
        }

        T bean = null;
        try {
            JSONObject jsonObject = new JSONObject(string);
            bean = mGenericsSerializator.transform(jsonObject.toString(), entityClass);
        } catch (JSONException e) {
            e.printStackTrace();
            return bean;
        }

        return bean;
    }

}
