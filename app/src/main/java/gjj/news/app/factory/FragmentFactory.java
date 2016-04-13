package gjj.news.app.factory;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

import gjj.news.app.fragment.KnowledgeFragment;
import gjj.news.app.fragment.KnowledgeTestFragment;
import gjj.news.app.utils.Constants;

public class FragmentFactory {
	//SparseArray性能优化
	private static SparseArray<Fragment> sparseArray=new SparseArray<>();
	private static SparseArray<Long> fragmentCreateTime=new SparseArray<>();//记录创建的时间
	public static Fragment createFragment(int arg0){
		Fragment baseFragment = null;
		if(sparseArray.get(arg0)!=null){
			baseFragment=sparseArray.get(arg0);
		}else{
			switch (arg0){
				case 0:
//					baseFragment = KnowledgeFragment.newInstance(Constants.MENU_NEWS);
					baseFragment = KnowledgeTestFragment.newInstance(Constants.MENU_NEWS);

					fragmentCreateTime.put(0,System.currentTimeMillis());
					break;
				case 1:
					baseFragment = KnowledgeFragment.newInstance(Constants.MENU_PIC);
					fragmentCreateTime.put(1,System.currentTimeMillis());
					break;
				default:
					break;
			}
			sparseArray.put(arg0,baseFragment);
		}
		return baseFragment;
	}
	/**
	 * 获取对应fragment创建额时间
	 */
	public static long getFragmentCreateTime(int arg0){
		long time=0;
		if(fragmentCreateTime.get(arg0)<1){//时间不存在
			return time;
		}else{
			return fragmentCreateTime.get(arg0);
		}
	}
}
