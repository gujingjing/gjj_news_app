package gjj.news.app.present;

import android.os.Handler;

import gjj.news.app.base.BasePresenter;
import gjj.news.app.view.KnowledgeView;

/**
 * 作者：gjj on 2016/4/12 16:38
 * 邮箱：Gujj512@163.com
 */
public class KnowledgePresent extends BasePresenter<KnowledgeView> {

    public void showView(boolean pullToRefresh){
        getView().showLoading(pullToRefresh);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().showContent();
            }
        },3000);
    }
}
