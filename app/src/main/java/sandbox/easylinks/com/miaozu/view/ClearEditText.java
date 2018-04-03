package sandbox.easylinks.com.miaozu.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;

import sandbox.easylinks.com.miaozu.R;

public class ClearEditText extends android.support.v7.widget.AppCompatEditText implements View.OnFocusChangeListener, TextWatcher {

    private Drawable mClearDrawable;
    private boolean hasFocus;

    public ClearEditText(Context context) {
        this(context, null);
    }

    public ClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mClearDrawable = getCompoundDrawables()[2]; // 获取drawableRight
        if (mClearDrawable == null) {
            // 如果为空，即没有设置drawableRight，则使用R.mipmap.close这张图片
            mClearDrawable = getResources().getDrawable(R.drawable.ic_edit_close);
        }
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(), mClearDrawable.getIntrinsicHeight());

        setOnFocusChangeListener(this);
        addTextChangedListener(this);
        // 默认隐藏图标
        setDrawableVisible(false);
    }

    protected void setDrawableVisible(boolean visible) {
        Drawable right = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
    }

    @Override
    public void onFocusChange(View view, boolean b) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
