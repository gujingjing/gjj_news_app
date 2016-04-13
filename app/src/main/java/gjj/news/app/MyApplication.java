package gjj.news.app;

import com.squareup.leakcanary.LeakCanary;

import gjj.news.app.base.BaseApplication;

/**
 * 作者：gjj on 2016/4/12 13:13
 * 邮箱：Gujj512@163.com
 */
public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogUtils(true,"gjj-");
        initSPUtils("gjj_shareSP");
        //初始化内存泄漏
        LeakCanary.install(this);
    }

}
