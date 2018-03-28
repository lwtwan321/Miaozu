package sandbox.easylinks.com.miaozu.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import sandbox.easylinks.com.miaozu.R;
import sandbox.easylinks.com.widget.StatusBarUtil;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置布局
        setContentView(getLayout());
        //设置状态栏
        setStatusBar();
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    /**
     * 设置顶部状态栏
     */
    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }

    /**
     * 设置布局
     *
     * @return
     */
    public abstract int getLayout();

    /**
     * 初始化布局
     */
    public abstract void initView();

    /**
     * 设置数据
     */
    public abstract void initData();
}
