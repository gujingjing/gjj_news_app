package gjj.news.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import butterknife.ButterKnife;

/**
 * 作者：gjj on 2016/3/4 15:41
 * 邮箱：Gujj512@163.com
 * MvpViewStateFrameLayout---这是一个自定义的控件，里面实现数据加载显示---可以不用
 *MvpFragment----不使用loading加载的原始fragment
 */
public abstract class BaseFragmentNoShowView< V extends MvpView, P extends BasePresenter<V>>
        extends MvpFragment<V,P> implements MvpView{
    protected View rootView;
    protected int layoutId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(initLayoutId(), container, false);
            ButterKnife.bind(this, rootView);
            initViews();
        }
        AlwaysInit();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected abstract int initLayoutId();

    protected void AlwaysInit() {
        ButterKnife.bind(this, rootView);
    }

    protected abstract void initData();

    protected abstract void initViews();


    public boolean isAlive() {
        return getActivity() != null;
    }
}
