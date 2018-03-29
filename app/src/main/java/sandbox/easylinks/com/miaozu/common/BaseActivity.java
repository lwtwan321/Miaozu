package sandbox.easylinks.com.miaozu.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;
import sandbox.easylinks.com.miaozu.R;
import sandbox.easylinks.com.miaozu.eventbus.BaseEventBusBean;
import sandbox.easylinks.com.widget.StatusBarUtil;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);//注册EventBus
        //设置布局
        setContentView(getLayout());
        //初始化黄油刀控件绑定框架
        bind = ButterKnife.bind(this);
        //设置状态栏
        setStatusBar();
        //初始化控件
        initView();
        //设置数据
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }

    /**
     * 默认时间监听
     *
     * @param event
     */
    public void onEventMainThread(BaseEventBusBean event) {
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
