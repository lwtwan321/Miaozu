# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile




#My custom
    -dontwarn com.yanzhenjie.permission.**

 #指定代码的压缩级别
    -optimizationpasses 5

    #包明不混合大小写
    -dontusemixedcaseclassnames

    #不去忽略非公共的库类
    -dontskipnonpubliclibraryclasses

     #优化  不优化输入的类文件
    -dontoptimize

     #预校验
    -dontpreverify

     #混淆时是否记录日志
    -verbose

     # 混淆时所采用的算法
    -optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

    #保护注解
    -keepattributes *Annotation*

    # 保持哪些类不被混淆
    -keep public class * extends android.app.Fragment
    -keep public class * extends android.app.Activity
    -keep public class * extends android.app.Application
    -keep public class * extends android.app.Service
    -keep public class * extends android.content.BroadcastReceiver
    -keep public class * extends android.content.ContentProvider
    -keep public class * extends android.app.backup.BackupAgentHelper
    -keep public class * extends android.preference.Preference
    -keep public class com.android.vending.licensing.ILicensingService
    #如果有引用v4包可以添加下面这行
    -keep public class * extends android.support.v4.app.Fragment


    #忽略警告
    -ignorewarning

    ##记录生成的日志数据,gradle build时在本项目根目录输出##

    #apk 包内所有 class 的内部结构
    -dump class_files.txt
    #未混淆的类和成员
    -printseeds seeds.txt
    #列出从 apk 中删除的代码
    -printusage unused.txt
    #混淆前后的映射
    -printmapping mapping.txt

    ########记录生成的日志数据，gradle build时 在本项目根目录输出-end######


    #####混淆保护自己项目的部分代码以及引用的第三方jar包library#######

    #-libraryjars libs/umeng-analytics-v5.2.4.jar

    #三星应用市场需要添加:sdk-v1.0.0.jar,look-v1.0.1.jar
    #-libraryjars libs/sdk-v1.0.0.jar
    #-libraryjars libs/look-v1.0.1.jar

    #如果不想混淆 keep 掉
    -keep class com.lippi.recorder.iirfilterdesigner.** {*; }
    #友盟
    -keep class com.umeng.**{*;}
    #项目特殊处理代码

    #忽略警告
    -dontwarn com.lippi.recorder.utils**
    #保留一个完整的包
    -keep class com.lippi.recorder.utils.** {
        *;
     }

    -keep class  com.lippi.recorder.utils.AudioRecorder{*;}


    #如果引用了v4或者v7包
    -dontwarn android.support.**

    ####混淆保护自己项目的部分代码以及引用的第三方jar包library-end####

    -keep public class * extends android.view.View {
        public <init>(android.content.Context);
        public <init>(android.content.Context, android.util.AttributeSet);
        public <init>(android.content.Context, android.util.AttributeSet, int);
        public void set*(...);
    }

    #保持 native 方法不被混淆
    -keepclasseswithmembernames class * {
        native <methods>;
    }

    #保持自定义控件类不被混淆
    -keepclasseswithmembers class * {
        public <init>(android.content.Context, android.util.AttributeSet);
    }

    #保持自定义控件类不被混淆
    -keepclassmembers class * extends android.app.Activity {
       public void *(android.view.View);
    }

    #保持 Parcelable 不被混淆
    -keep class * implements android.os.Parcelable {
      public static final android.os.Parcelable$Creator *;
    }

    #保持 Serializable 不被混淆
    -keepnames class * implements java.io.Serializable

    #保持 Serializable 不被混淆并且enum 类也不被混淆
    -keepclassmembers class * implements java.io.Serializable {
        static final long serialVersionUID;
        private static final java.io.ObjectStreamField[] serialPersistentFields;
        !static !transient <fields>;
        !private <fields>;
        !private <methods>;
        private void writeObject(java.io.ObjectOutputStream);
        private void readObject(java.io.ObjectInputStream);
        java.lang.Object writeReplace();
        java.lang.Object readResolve();
    }

    #保持枚举 enum 类不被混淆 如果混淆报错，建议直接使用上面的 -keepclassmembers class * implements java.io.Serializable即可
    #-keepclassmembers enum * {
    #  public static **[] values();
    #  public static ** valueOf(java.lang.String);
    #}

    -keepclassmembers class * {
        public void *ButtonClicked(android.view.View);
    }

    #不混淆资源类
    -keepclassmembers class **.R$* {
        public static <fields>;
    }

    #避免混淆泛型 如果混淆报错建议关掉
    #–keepattributes Signature

    #移除log 测试了下没有用还是建议自己定义一个开关控制是否输出日志
    #-assumenosideeffects class android.util.Log {
    #    public static boolean isLoggable(java.lang.String, int);
    #    public static int v(...);
    #    public static int i(...);
    #    public static int w(...);
    #    public static int d(...);
    #    public static int e(...);
    #}

    -keep class com.worknrock.gongdi.sml.busbean.**
    -keepclassmembers class com.worknrock.gongdi.sml.busbean.** {
        *;
    }

    -keep class com.worknrock.gongdi.sml.bean.**
    -keepclassmembers class com.worknrock.gongdi.sml.bean.** {
        *;
    }

    #-keep public class com.bst.cardioge.business.eeducation.activity.EEducationNewsDetail$MyObject {
    #*;
    #}

    ## ----------------------------------
    ##   ########## Gson混淆    ##########
    #这些类是我们自己的一些不需要混淆的类，如带注解的实体类，需要由GSON进行转换的类，如果被混淆可能GSON 会转换失败
    -keep class com.xxxx.xxxxxxxxxx.http.util.JsonUtils {*;}
    -keep class com.xxxx.xxxxxxxxxx.entity.**{*;}
    -keep class com.xxxx.xxxxxxxxxx.http.action.entity.**{*;}
    -keep class com.xxxx.xxxxxxxxxx.ui.**{*;}
    -keep class com.xxxx.xxxxxxxxxx.ui.run.**{*;}
    #--------------以下部分是确保GSON转换成功需要保留的一些类，不能进行混淆--------------
    #这个参数很重要 ： 和-keepattributes *Annotation* 一样 如果没有添加，GSON可能转换一些实体类会失败
    #保留GSON的同时还需要实体类也不能被混淆，否则可能会失败
    -keepattributes Signature
    # 保留Gson 的一些类
    -keep class sun.misc.Unsafe { *; }
    -keep class com.google.gson.stream.** { *; }
    -keep class com.google.gson.** { *;}
    ##---------------^上面是GSON的混淆^  ----------

    # # -------------------------------------------
    # #  ######## greenDao混淆  ##########
    # # -------------------------------------------
#    -libraryjars libs/greendao-1.3.7.jar
    -keep class de.greenrobot.dao.** {*;}
    -keepclassmembers class com.worknrock.gongdi.sml.db.** {*;}
    -keepclassmembers class * extends de.greenrobot.dao.AbstractDao {
        public static java.lang.String TABLENAME;
    }
    -keep class **$Properties

    # # -------------------------------------------
    # #  ############### volley混淆  ###############
    # # -------------------------------------------
    -keep class com.android.volley.** {*;}
    -keep class com.android.volley.toolbox.** {*;}
    -keep class com.android.volley.Response$* { *; }
    -keep class com.android.volley.Request$* { *; }
    -keep class com.android.volley.RequestQueue$* { *; }
    -keep class com.android.volley.toolbox.HurlStack$* { *; }
    -keep class com.android.volley.toolbox.ImageLoader$* { *; }
    -keep class org.apache.http.** {*;}

#    -libraryjars libs/volley.jar

    # # pinyin4j
    -dontwarn net.soureceforge.pinyin4j.**
    -dontwarn demo.**
#    -libraryjars libs/pinyin4j-2.5.0.jar
    -keep class net.sourceforge.pinyin4j.** { *;}
    -keep class demo.** { *;}

    # # JPush
#    -libraryjars libs/jpush-android-2.1.0.jar
    -dontwarn cn.jpush.**
    -keep class cn.jpush.** { *; }

    # # EventBus
#    -libraryjars libs/eventbus.jar
    -keepclassmembers class ** {
        public void onEvent*(**);
    }
    -keepclasseswithmembers class * {public void onEventMainThread(***);}

    -keepclasseswithmembers class * { public void onEvent(***);}

    -keepclasseswithmembers class * { public void onEventPostThread(***);}

    -keepclasseswithmembers class * { public void onEventBackgroundThread(***);}

    -keepclasseswithmembers class * { public void onEventAsync(***);}



    -keepattributes *Annotation*
    -keepclassmembers class ** {
        @org.greenrobot.eventbus.Subscribe <methods>;
    }
    -keep enum org.greenrobot.eventbus.ThreadMode { *; }

    # Only required if you use AsyncExecutor
    -keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
        <init>(Java.lang.Throwable);
    }


    -keepclassmembers class * extends android.webkit.WebChromeClient{
       public void openFileChooser(...);
       public boolean onShowFileChooser(...);
    }

    # TalkingData
    -keep public class com.tendcloud.tenddata.** { public protected *;}
    -keepclassmembers class com.tendcloud.tenddata.**{
    public void *(***);
    }
    -keep class com.talkingdata.sdk.TalkingDataSDK {public *;}
    -keep class com.apptalkingdata.** {*;}
