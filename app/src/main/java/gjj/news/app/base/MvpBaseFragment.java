package gjj.news.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import butterknife.ButterKnife;

/**
 * 作者：gjj on 2016/3/4 15:41
 * 邮箱：Gujj512@163.com
 * MvpViewStateFrameLayout---这是一个自定义的控件，里面实现数据加载显示---可以不用
 *MvpFragment----不使用loading加载的原始fragment
 */
public abstract class MvpBaseFragment<CV extends View, M, V extends MvpLceView<M>, P extends MvpPresenter<V>>
        extends MvpLceFragment<CV,M,V,P> implements MvpLceView<M>{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = initView(inflater,container, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
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

    /**
     * @param inflater           打气筒
     * @param savedInstanceState bundle
     * @return view
     * @Title: initView
     * @Description: 初始化视图 及 监听
     */
    protected abstract View initView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState);


    protected abstract void initData();


}
