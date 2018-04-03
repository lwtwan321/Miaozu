package sandbox.easylinks.com.miaozu.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import sandbox.easylinks.com.miaozu.R;
import sandbox.easylinks.com.miaozu.adapter.GuildePageAdapter;
import sandbox.easylinks.com.miaozu.common.BaseActivity;
import sandbox.easylinks.com.miaozu.fragment.FragmentLogin;
import sandbox.easylinks.com.miaozu.fragment.TutorialImageFragment;
import sandbox.easylinks.com.widget.utils.BarUtils;

public class WelcomeActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.view_welcome_container)
    ViewPager view_welcome_container;

    @BindView(R.id.view_guide_ll_point)
    LinearLayout view_guide_ll_point;

    private GuildePageAdapter guildePageAdapter;

    private List<Fragment> fragmentList = new ArrayList<>();

    //实例化原点View
    private ImageView iv_point;
    private ImageView[] ivPointArray;

    @Override
    public int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        BarUtils.setStatusBarVisibility(this, false);
    }

    @Override
    public void initData() {
        fragmentList.add(TutorialImageFragment.newInstance(R.drawable.tutorial_text_1));
        fragmentList.add(TutorialImageFragment.newInstance(R.drawable.tutorial_text_2));
        fragmentList.add(TutorialImageFragment.newInstance(R.drawable.tutorial_text_3));
        fragmentList.add(new FragmentLogin());
        initPoint();
        guildePageAdapter = new GuildePageAdapter(getSupportFragmentManager(), fragmentList);
        view_welcome_container.setAdapter(guildePageAdapter);
        view_welcome_container.addOnPageChangeListener(this);
    }

    private void initPoint() {
        ivPointArray = new ImageView[fragmentList.size()];
        int size = fragmentList.size();
        for (int i = 0; i < size; i++) {
            iv_point = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(20, 20);
            int margin = 15;
            layoutParams.setMargins(margin, 0, margin, 0);
            iv_point.setLayoutParams(layoutParams);
            ivPointArray[i] = iv_point;
            view_guide_ll_point.addView(iv_point);
        }
        showPointPosition(0);
    }

    private void showPointPosition(int position) {
        int length = fragmentList.size();
        for (int i = 0; i < length; i++) {
            ivPointArray[i].setBackgroundResource(R.drawable.ic_welcome_unselected_page);
            if (i == position) {
                ivPointArray[i].setBackgroundResource(R.drawable.ic_welcome_selected_page);
            }
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        showPointPosition(position);
        if (position == fragmentList.size() - 1) {
            view_guide_ll_point.setVisibility(View.GONE);
            view_welcome_container.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        } else {
            view_guide_ll_point.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
