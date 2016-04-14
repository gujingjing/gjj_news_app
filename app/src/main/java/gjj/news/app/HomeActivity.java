package gjj.news.app;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.jaeger.library.StatusBarUtil;
import com.nispok.snackbar.Snackbar;
import com.nispok.snackbar.SnackbarManager;

import butterknife.Bind;
import gjj.news.app.activity.ScrollHiddenTootalbarActivity;
import gjj.news.app.activity.TabLayoutTestActivity;
import gjj.news.app.activity.TootalBarTestActivity;
import gjj.news.app.base.BaseActivity;
import gjj.news.app.factory.FragmentFactory;
import gjj.news.app.fragment.KnowledgeFragment;
import gjj.news.app.utils.Constants;

/**
 * 作者：gjj on 2016/4/12 11:35
 * 邮箱：Gujj512@163.com
 */
public class HomeActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.content_fragment)
    FrameLayout contentMain;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer)
    DrawerLayout drawerLayout;

    private String currentType;
    private Fragment currentFragment;

    private Intent intent;
    @Override
    public int initView() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        setupDrawer();
        initTootalBar();
        initListener();
    }

    public void initTootalBar(){
        // App Logo
//        toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle("妹知");
        // Sub Title
//        toolbar.setSubtitle("Sub title");

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//返回箭头
        // Menu item click 的監聽事件一樣要設定在 setSupportActionBar 才有作用
        toolbar.setOnMenuItemClickListener(this);

        //初始化显示知识fragment
        currentFragment= FragmentFactory.createFragment(0);
        replaceFragment(currentFragment,Constants.MENU_NEWS);
    }

    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
//                setStateBarColor(getResources().getColor(R.color.transparency));
//                StatusBarUtil.setTranslucentForDrawerLayout(context, drawerLayout, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
                StatusBarUtil.setColor(context, getResources().getColor(R.color.colorPrimary),StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
                StatusBarUtil.setColorForDrawerLayout(context,drawerLayout,R.color.transparency,StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                setStateBarColor(getResources().getColor(R.color.colorPrimary));
                StatusBarUtil.setColor(context, getResources().getColor(R.color.colorPrimary),0);
            }
        };
        drawerLayout.setDrawerListener(toggle);
        StatusBarUtil.setColorForDrawerLayout(context,drawerLayout,getResources().getColor(R.color.transparency),StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
        StatusBarUtil.setTranslucentForDrawerLayout(context, drawerLayout, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
        toggle.syncState();
    }
    public void initListener(){
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_original1:
//                        replace(Constants.MENU_NEWS);
                        showTest(item);
                        break;
                    case R.id.navigation_original2:
//                        replace(Constants.MENU_PIC);
                        showTest(item);
                        break;
                    case R.id.navigation_original3:
                        showTest(item);
                        intent=new Intent(HomeActivity.this, TabLayoutTestActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
//                        drawerLayout.openDrawer(Gravity.LEFT);
                        break;
                    case R.id.navigation_original4:
                        showTest(item);
                        intent=new Intent(HomeActivity.this, TootalBarTestActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.navigation_original5:
                        showTest(item);
                        intent=new Intent(HomeActivity.this, ScrollHiddenTootalbarActivity.class);
                        startActivity(intent);
                        drawerLayout.closeDrawers();

                        break;
                    case R.id.navigation_original6:
                        SnackbarManager.show(
                                Snackbar.with(context)
                                        .text(item.getTitle()));
                        break;
                    case R.id.image:
                        SnackbarManager.show(
                                Snackbar.with(context)
                                        .text("点击了图片"));
                        break;
                }
                return false;
            }
        });
    }


    public void showTest(MenuItem item){
        item.setChecked(true);
        SnackbarManager.show(
                Snackbar.with(context)
                        .text(item.getTitle()));
    }
    @Override
    public boolean notFiniActivity() {
        return true;
    }

    @Override
    public boolean notSetNotifyColor() {
        return false;
    }

    @Override
    public boolean notSetNotifyNetSatte() {
        return false;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
//                break;
            case R.id.action_share:
//                break;
            case R.id.action_settings:
                SnackbarManager.show(
                        Snackbar.with(context)
                                .text(item.getTitle()));
                break;
        }
        return true;
    }
    private void replace(String type) {
        if (!type.equals(currentType)) {
            currentType = type;
            replaceFragment(KnowledgeFragment.newInstance(type), type);
        }
    }
}
