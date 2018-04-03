package sandbox.easylinks.com.miaozu.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;
import sandbox.easylinks.com.miaozu.eventbus.BaseEventBusBean;

public abstract class BaseFragment extends Fragment {

    protected BaseActivity mActivity;

    private Unbinder bind;

    protected abstract int getFragmentView();

    protected abstract void init(View view);

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = (BaseActivity) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentView(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        init(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(BaseEventBusBean event) {

    }
}
