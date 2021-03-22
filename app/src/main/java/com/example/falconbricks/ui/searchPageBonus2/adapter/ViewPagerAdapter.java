package com.example.falconbricks.ui.searchPageBonus2.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.ui.searchPageBonus2.view.FragmentTab;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;
    int NumOfTabs;
    List<TableBlockMaster> blockList;
    String searchTerm;

    public ViewPagerAdapter(FragmentManager fm, int NumOfTabs, List<TableBlockMaster> blockList, String searchTerm) {
        super(fm);
        this.context = context;
        this.NumOfTabs = NumOfTabs;
        this.blockList = blockList;
        this.searchTerm = searchTerm;

    }

    @Override
    public int getCount() {
        return NumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        FragmentTab tab1 = FragmentTab.newInstance(position, blockList.get(position).getBlock_table_id(), searchTerm);
        return tab1;
    }


}
