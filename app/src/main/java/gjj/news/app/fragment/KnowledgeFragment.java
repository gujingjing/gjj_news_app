package gjj.news.app.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import gjj.news.app.R;
import gjj.news.app.adapter.KnowledgeViewpagerAdapter;
import gjj.news.app.base.BaseFragment;
import gjj.news.app.utils.Constants;

/**
 * 作者：gjj on 2016/4/12 15:19
 * 邮箱：Gujj512@163.com
 */
public class KnowledgeFragment extends BaseFragment {
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.contentView)
    ViewPager contentView;

    private List<String> titles;
    private KnowledgeViewpagerAdapter adapter;
    List<KowledgeViewpagerFragment> fragments;

    public static KnowledgeFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(Constants.TYPE, type);
        KnowledgeFragment fragment = new KnowledgeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_knowledge, container,false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    protected void initData() {
        initFragments();
        adapter = new KnowledgeViewpagerAdapter(getChildFragmentManager());
        adapter.setFragments(fragments, this.titles);
        contentView.setAdapter(adapter);

        //绑定tab和viewpager
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabs.setupWithViewPager(contentView);

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                contentView.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void initFragments() {
        String[] titles = new String[]{
                getString(R.string.zhihu_news),
                getString(R.string.fresh_news),
        };
        this.titles = Arrays.asList(titles);
        fragments = new ArrayList<>();

        fragments.add(new KowledgeViewpagerFragment());
        fragments.add(new KowledgeViewpagerFragment());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
