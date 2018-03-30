package sandbox.easylinks.com.miaozu;


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import sandbox.easylinks.com.miaozu.beans.UserBean;
import sandbox.easylinks.com.miaozu.common.BaseActivity;
import sandbox.easylinks.com.miaozu.common.net.JsonGenericsSerializator;
import sandbox.easylinks.com.miaozu.common.net.ListCallback;
import sandbox.easylinks.com.miaozu.common.net.NetRequestUtils;
import sandbox.easylinks.com.widget.okhttp.OkHttpUtils;
import sandbox.easylinks.com.widget.okhttp.callback.GenericsCallback;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    String baseUrl = "http://www.nikest.com/web/jswd/2015/0301/126097.html";

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initData() {
        list();


    }


    private void single() {
        HashMap params = new HashMap();
        NetRequestUtils.request(
                baseUrl,
                OkHttpUtils.METHOD.GET,
                null,
                params,
                new GenericsCallback<UserBean>(new JsonGenericsSerializator()) {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("djh", e.getMessage());
                    }

                    @Override
                    public void onResponse(UserBean response, int id) {
                        UserBean userBean = response;
                        if (userBean != null) {
                            Log.i("djh", userBean.getName());
                        }
                    }
                });
    }


    private void list() {
        NetRequestUtils.request(
                baseUrl,
                OkHttpUtils.METHOD.GET,
                null,
                null,
                new ListCallback<UserBean>() {

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.i("djh", e.getMessage());

                    }

                    @Override
                    public void onResponse(List<UserBean> response, int id) {
                        List<UserBean> list = response;
                        if (list != null) {
                            Log.i("djh", list.size()+"");
                        }
                    }
                });
    }


}
