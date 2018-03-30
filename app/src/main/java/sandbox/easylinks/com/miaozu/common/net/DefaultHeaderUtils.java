package sandbox.easylinks.com.miaozu.common.net;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class DefaultHeaderUtils {

    private static final String ACCEPT = "Accept";
    private static final String TYPE = "application/json";
    private static final String ACCEPT_LANGUAGE = "Accept-Language";
    private static final String AUTHORIZATION = "Authorization";
    private static final String USER_AGENT = "User-Agent";

    public static Map<String, String> createDefaultHeaders(Context context) {
        return createDefaultHeaders(context, null);
    }

    public static HashMap<String, String> createDefaultHeaders(Context context, HashMap<String, String> additionalHeaders) {
        HashMap<String, String> map = new HashMap<>();
        map.put(ACCEPT, TYPE);
//        String lng = LanguageController.getLanguageCode(context);
//        map.put(ACCEPT_LANGUAGE, lng);
//        map.put(
//                USER_AGENT,
//                "Sandbox/"
//                        + BstXMPPPreferences.getInstance(context).getAppVersion()
//                        + " ("
//                        + "Android; "
//                        + Build.PRODUCT + "; "
//                        + Build.VERSION.RELEASE
//                        + ")"
//        );
//        String auth = AuthController.getBasicAuth(context);
//        XMPPServiceController.showLog("auth=" + auth);
//        if (!TextUtils.isEmpty(auth)) {
//            map.put(AUTHORIZATION, auth);
//        }
        if (additionalHeaders != null) {
            map.putAll(additionalHeaders);
        }
        return map;
    }
}
