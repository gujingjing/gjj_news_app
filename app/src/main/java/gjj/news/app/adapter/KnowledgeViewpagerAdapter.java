package gjj.news.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import gjj.news.app.fragment.KowledgeViewpagerFragment;
import gjj.news.app.model.KnowledgeModel;

/**
 * 作者：gjj on 2016/4/13 13:32
 * 邮箱：Gujj512@163.com
 */
public class KnowledgeViewpagerAdapter extends FragmentPagerAdapter{

    private List<KowledgeViewpagerFragment> fragments=new ArrayList<>();
    private List<String> titles;

    public KnowledgeViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void setFragments(List<KowledgeViewpagerFragment> fragments, List<String> titles) {
        this.fragments = fragments;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
