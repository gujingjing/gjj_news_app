package gjj.news.app.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import butterknife.ButterKnife;
import gjj.android.base.manager.AppManager;
import gjj.android.base.manager.SystemBarTintManager;
import gjj.android.base.view.swipClassView.SwipeBackLayout;
import gjj.android.base.tools.NetWorkUtil;
import gjj.android.base.tools.ToastUtils;
import gjj.news.app.R;

/**
 * 作者：gjj on 2016/3/4 12:46
 * 邮箱：Gujj512@163.com
 */
public abstract class BaseActivity  extends AppCompatActivity {
    public BaseActivity context;
    protected SwipeBackLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initView());
        ButterKnife.bind(this);
        context = this;
        //顺序很重要，必须先设置是否需要滑动activity----然后在设置顶部标题栏的颜色
        if (!notFiniActivity()) {
            //是否需要滑动消除界面的主要代码
            layout = (SwipeBackLayout) LayoutInflater.from(this).inflate(
                    R.layout.activity_base, null);
            layout.attachToActivity(this);
        }
        if(!notSetNotifyColor()){
//            setStateBarColor(R.color.colorPrimary);//设置最顶部标题栏颜色
            StatusBarUtil.setColor(context, getResources().getColor(R.color.colorPrimary),0);
//            StatusBarUtil.setTransparent(context);
        }

        AppManager.getAppManager().addActivity(this);

        initData();
    }
    /**
     * 设置layout
     */
    public abstract int initView();
    /**
     * 设置数据
     */
    public abstract void initData();
    /**
     * 是否需要右滑删除界面
     */
    public abstract boolean notFiniActivity();

    /**
     * 是否需要设置导航栏的颜色
     */
    public abstract boolean notSetNotifyColor();
    /**
     * 是否需要设置监听网络状态操作
     */
    public abstract boolean notSetNotifyNetSatte();

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.base_slide_remain);
    }

    // Press the back button in mobile phone
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.base_slide_right_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //移除activity的时候使用AppManager.finishActivity();
        AppManager.getAppManager().finishActivity(this);
    }

    /**
     * 当没有网络的时候
     */
    public void onDisConnect() {
        if(notSetNotifyNetSatte()){
            return;
        }

//        ToastUtils.setToastShot(context, "暂时没有网络,请稍后重试");
            SnackbarManager.show(
                    Snackbar.with(context)
                            .text("暂时没有网络,请稍后重试"));
    }

    /**
     * 当网络连接的时候
     * 获取当前的网络状态 -1：没有网络 1：WIFI网络2：wap 网络3：net网络
     * wifi, CMNET, CMWAP, noneNet
     */
    public void onConnect(NetWorkUtil.NetType type) {
        if(notSetNotifyNetSatte()){
            return;
        }
        String netType="";
        ToastUtils.setToastShot(context, "网络已经连接");
        switch (type){
            case wifi:
                netType="当前网络状态为wifi网络";
                break;
            case CMNET:
            case CMWAP:
                netType="当前网络状态为手机网络";
                break;
            case noneNet:
                netType="当前没有网络,请连接网络";
                break;

        }
        SnackbarManager.show(
                Snackbar.with(context)
                        .text(netType));
    }
    protected void setStateBarColor(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            winParams.flags |= bits;
            win.setAttributes(winParams);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(resId);
            tintManager.setStatusBarDarkMode(true, this);
        }
    }
    public void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_fragment, fragment, tag);
        transaction.commit();
    }
}
