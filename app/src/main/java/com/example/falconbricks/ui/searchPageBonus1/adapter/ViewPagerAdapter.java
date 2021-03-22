package com.example.falconbricks.ui.searchPageBonus1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.R;

import java.util.List;

public class ViewPagerAdapter  extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    List<TableBlockMaster> blockList;

    public ViewPagerAdapter(Context context, List<TableBlockMaster> blockList) {
        this.context = context;
        this.blockList = blockList;

    }

    @Override
    public int getCount() {
        return blockList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.view_pager_item, null);

        int blockId = blockList.get(position).getBlock_table_id();
        //RecyclerView recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;

        vp.removeView(view);
    }

}
