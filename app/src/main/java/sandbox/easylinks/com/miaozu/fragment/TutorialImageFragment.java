package sandbox.easylinks.com.miaozu.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import sandbox.easylinks.com.miaozu.R;
import sandbox.easylinks.com.miaozu.common.BaseFragment;

public class TutorialImageFragment extends BaseFragment {

    @BindView(R.id.iv_cover)
    ImageView iv_cover;

    int resId;

    public void setResId(int resId) {
        this.resId = resId;
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_tutorial_item_view;
    }

    @Override
    protected void init(View view) {
        if (resId != 0) {
            iv_cover.setImageResource(resId);
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    public static TutorialImageFragment newInstance(int resId) {
        TutorialImageFragment fragment = new TutorialImageFragment();
        fragment.setResId(resId);
        return fragment;
    }
}
