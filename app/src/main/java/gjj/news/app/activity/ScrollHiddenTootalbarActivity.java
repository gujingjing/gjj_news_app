package gjj.news.app.activity;

import gjj.news.app.R;
import gjj.news.app.base.BaseActivity;

/**
 * 作者：gjj on 2016/4/14 14:27
 * 邮箱：Gujj512@163.com
 */
public class ScrollHiddenTootalbarActivity  extends BaseActivity{
    @Override
    public int initView() {
        return R.layout.activity_scroller_hidden_toolbar;
    }

    @Override
    public void initData() {

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
