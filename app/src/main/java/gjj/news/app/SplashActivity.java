package gjj.news.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import gjj.news.app.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public int initView() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        goToActivity();
    }
    @Override
    public boolean notFiniActivity() {
        return true;
    }

    @Override
    public boolean notSetNotifyColor() {
        return true;
    }

    @Override
    public boolean notSetNotifyNetSatte() {
        return true;
    }



    public void goToActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
