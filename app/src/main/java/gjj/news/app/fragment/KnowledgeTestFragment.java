package gjj.news.app.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import gjj.news.app.R;
import gjj.news.app.adapter.KnowledgeViewpagerAdapter;
import gjj.news.app.base.BaseFragment;
import gjj.news.app.utils.Constants;

/**
 * 作者：gjj on 2016/4/13 16:53
 * 邮箱：Gujj512@163.com
 */
public class KnowledgeTestFragment extends BaseFragment {
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.contentView)
    ViewPager pager;

    private List<String> titles;
    private KnowledgeViewpagerAdapter adapter;
    List<KowledgeViewpagerFragment> fragments;


    public static KnowledgeTestFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(Constants.TYPE, type);
        KnowledgeTestFragment fragment = new KnowledgeTestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_knowledge, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        adapter=new KnowledgeViewpagerAdapter(getChildFragmentManager());
        initFragments();
        pager.setAdapter(adapter);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabs.setupWithViewPager(pager);
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    public void initFragments(){
        titles = new ArrayList<>();
        fragments=new ArrayList<>();
        fragments.add(new KowledgeViewpagerFragment());
        fragments.add(new KowledgeViewpagerFragment());
        titles.add(getString(R.string.zhihu_news));
        titles.add(getString(R.string.fresh_news));

        adapter.setFragments(fragments, titles);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
