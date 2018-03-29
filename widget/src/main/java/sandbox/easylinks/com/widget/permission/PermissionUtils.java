package sandbox.easylinks.com.widget.permission;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;

import java.util.List;

public class PermissionUtils {

    //AndPermission.permissionSetting(MainActivity.this).execute();//直接打开设置权限

    //调用方法
//     PermissionUtils.requestPermission(this, new PermissionUtils.PermissionListener() {
//        @Override
//        public void grant() {
//
//        }
//
//        @Override
//        public void denied() {
//
//        }
//    }, true, Permission.Group.STORAGE);

    /**
     * 多权限请求
     *
     * @param activity
     * @param permissionListener
     * @param isAllowDeniedCheck
     * @param permissions
     */
    public static void requestPermission(
            final Activity activity,
            final PermissionListener permissionListener,
            final boolean isAllowDeniedCheck,
            String... permissions) {
        Rationale mRationale = new DefaultRationale();

        AndPermission.with(activity)
                .permission(permissions)
                .rationale(mRationale)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        if (permissionListener != null) {
                            permissionListener.grant();
                        }
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        if (permissionListener != null && !isAllowDeniedCheck) {
                            permissionListener.denied();
                        }
                        if (isAllowDeniedCheck && AndPermission.hasAlwaysDeniedPermission(activity, permissions)) {
                            PermissionSetting mSetting = new PermissionSetting(activity);
                            mSetting.showSetting(permissions);
                        }
                    }
                })
                .start();
    }

    /**
     * 数组权限请求
     *
     * @param activity
     * @param permissionListener
     * @param isAllowDeniedCheck
     * @param permissions
     */
    public static void requestPermission(
            final Activity activity,
            final PermissionListener permissionListener,
            final boolean isAllowDeniedCheck,
            String[]... permissions) {

        Rationale mRationale = new DefaultRationale();

        AndPermission.with(activity)
                .permission(permissions)
                .rationale(mRationale)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        if (permissionListener != null) {
                            permissionListener.grant();
                        }
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {
                        if (permissionListener != null && !isAllowDeniedCheck) {
                            permissionListener.denied();
                        }
                        if (isAllowDeniedCheck && AndPermission.hasAlwaysDeniedPermission(activity, permissions)) {
                            PermissionSetting mSetting = new PermissionSetting(activity);
                            mSetting.showSetting(permissions);
                        }
                    }
                })
                .start();
    }


    public interface PermissionListener {
        void grant();

        void denied();
    }
}
