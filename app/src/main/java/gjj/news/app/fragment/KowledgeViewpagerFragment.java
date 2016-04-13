package gjj.news.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import gjj.news.app.R;
import gjj.news.app.base.MvpBaseFragment;
import gjj.news.app.model.KnowledgeModel;
import gjj.news.app.present.KnowledgePresent;
import gjj.news.app.view.KnowledgeView;

/**
 * 作者：gjj on 2016/4/13 13:38
 * 邮箱：Gujj512@163.com
 */
public class KowledgeViewpagerFragment extends MvpBaseFragment<TextView, KnowledgeModel, KnowledgeView, KnowledgePresent> implements KnowledgeView {

    @Bind(R.id.loadingView)
    ProgressBar loadingView;
    @Bind(R.id.errorView)
    TextView errorView;
    @Bind(R.id.contentView)
    TextView contentView;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_knowledge_viewpager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        loadData(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public KnowledgePresent createPresenter() {
        return new KnowledgePresent();
    }

    @Override
    public void setData(KnowledgeModel data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.showView(pullToRefresh);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
