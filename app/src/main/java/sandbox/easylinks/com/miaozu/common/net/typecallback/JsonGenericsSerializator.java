package sandbox.easylinks.com.miaozu.common.net.typecallback;


import com.alibaba.fastjson.JSON;

import sandbox.easylinks.com.widget.okhttp.callback.IGenericsSerializator;

/**
 * Created by JimGong on 2016/6/23.
 */
public class JsonGenericsSerializator implements IGenericsSerializator {

    @Override
    public <T> T transform(String response, Class<T> classOfT) {
        return JSON.parseObject(response, classOfT);
    }
}
