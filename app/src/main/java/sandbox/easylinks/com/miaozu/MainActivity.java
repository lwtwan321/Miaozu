package sandbox.easylinks.com.miaozu;


import android.os.Build;
import android.support.annotation.RequiresApi;

import okhttp3.OkHttpClient;
import sandbox.easylinks.com.miaozu.common.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void initData() {

//        Request request = new Request.Builder()
//                .url("https://raw.github.com/square/okhttp/master/README.md")
//                .build();
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String json = response.body().string();
//                Log.d("okHttp", json);
//            }
//        });


    }


}
