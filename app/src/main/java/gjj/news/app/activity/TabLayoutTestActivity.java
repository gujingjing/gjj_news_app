package gjj.news.app.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import gjj.news.app.R;
import gjj.news.app.base.BaseActivity;

/**
 * 作者：gjj on 2016/4/14 10:38
 * 邮箱：Gujj512@163.com
 */
public class TabLayoutTestActivity extends BaseActivity {

    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public int initView() {
        return R.layout.activity_talbayout_test;
    }

    @Override
    public void initData() {
        initTootalBar();
        initInstances();
    }
    private void initInstances() {
//        tabs.addTab(tabs.newTab().setText("Tab 1"));
//        tabs.addTab(tabs.newTab().setText("Tab 2"));
//        tabs.addTab(tabs.newTab().setText("Tab 3"));
    }
    public void initTootalBar() {
        // App Logo
//        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("妹知");
        // Sub Title
//        toolbar.setSubtitle("Sub title");

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回箭头
        // Menu item click 的監聽事件一樣要設定在 setSupportActionBar 才有作用

        //初始化显示知识fragment
    }

    @Override
    public boolean notFiniActivity() {
        return false;
    }

    @Override
    public boolean notSetNotifyColor() {
        return false;
    }

    @Override
    public boolean notSetNotifyNetSatte() {
        return false;
    }

}
