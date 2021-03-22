package com.example.falconbricks.ui.searchPageBonus2.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.Database.Table.UnitsAndActivities;
import com.example.falconbricks.R;
import com.example.falconbricks.ui.searchPageBonus2.adapter.ViewPagerAdapter;
import com.example.falconbricks.ui.searchPageBonus2.viewModel.SearchViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SearchFragmentBonus2 extends Fragment {

    View rootView;
    SearchViewModel searchViewModel;
    TabLayout tabLayout;

    private List<TableBlockMaster> blockList = new ArrayList<>();
    private List<UnitsAndActivities> unitsAndActivitiesList = new ArrayList<>();
    LinearLayout ll_search, ll_no_record_found;
    TextView tv_term_not_found;
    List blockId = new ArrayList<String>();
    ViewPager view_pager;

    public static SearchFragmentBonus2 newInstance() {
        return new SearchFragmentBonus2();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search_bonus_2, container, false);

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        view_pager = rootView.findViewById(R.id.view_pager);
        ll_search = rootView.findViewById(R.id.ll_search);
        ll_no_record_found = rootView.findViewById(R.id.ll_no_record_found);
        tabLayout = rootView.findViewById(R.id.tabLayout);
        tv_term_not_found = rootView.findViewById(R.id.tv_term_not_found);
        ImageView iv_back = rootView.findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        SearchView searchView = rootView.findViewById(R.id.searchView);
        int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = (ImageView) searchView.findViewById(magId);
        magImage.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
        magImage.setVisibility(View.GONE);
        int id = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        final TextView textView = (TextView) searchView.findViewById(id);
        textView.setTextColor(Color.WHITE);
        textView.setHintTextColor(Color.WHITE);
        textView.setTextSize(15);
        int close_btn = searchView.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
        ImageView iv_close = (ImageView) searchView.findViewById(close_btn);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                ll_search.setVisibility(View.VISIBLE);
                ll_no_record_found.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                view_pager.setVisibility(View.GONE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
// do something on text submit
                getUnitsByAll(query);
                ll_search.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
// do something when text changes
                return false;
            }
        });


        return rootView;
    }

    private void getUnitsByAll(final String unitTitle) {
        unitsAndActivitiesList.clear();
        blockList.clear();
        blockId.clear();
        searchViewModel.getUnitsByAll(getActivity(), unitTitle);
        searchViewModel.getUnitsByAll().observe(getActivity(), new Observer<List<UnitsAndActivities>>() {
            @Override
            public void onChanged(List<UnitsAndActivities> unitsAndActivities) {

                if (unitsAndActivities.size() > 0) {
                    for (int k = 0; k < unitsAndActivities.size(); k++) {
                        UnitsAndActivities activities = new UnitsAndActivities();
                        activities.setFld_activity_name(unitsAndActivities.get(k).getFld_activity_name());
                        activities.setFld_activity_status(unitsAndActivities.get(k).getFld_activity_status());
                        activities.setFld_current_user_name(unitsAndActivities.get(k).getFld_current_user_name());

                        activities.setFld_step_name(unitsAndActivities.get(k).getFld_step_name());
                        activities.setFld_progress(unitsAndActivities.get(k).getFld_progress());
                        activities.setFld_wf(unitsAndActivities.get(k).getFld_wf());
                        activities.setFld_title(unitsAndActivities.get(k).getFld_title());
                        unitsAndActivitiesList.add(activities);

                        blockId.add(unitsAndActivities.get(k).getFld_block_table_id_from_block_table());
                    }
                    Set<String> hashSet = new LinkedHashSet(blockId);
                    TableBlockMaster block = new TableBlockMaster();
                    block.setBlock_name("ALL");
                    block.setBlock_table_id(0);
                    blockList.add(block);
                    for (Iterator<String> it = hashSet.iterator(); it.hasNext(); ) {
                        String f = it.next();
                        searchViewModel.getBlockNameById(getActivity(), f);
                        searchViewModel.getBlockNameById().observe(getActivity(), new Observer<List<TableBlockMaster>>() {
                            @Override
                            public void onChanged(List<TableBlockMaster> tableBlockMasters) {
                                for (int k = 0; k < tableBlockMasters.size(); k++) {
                                    TableBlockMaster block = new TableBlockMaster();
                                    block.setBlock_name(tableBlockMasters.get(k).getBlock_name());
                                    block.setBlock_table_id(tableBlockMasters.get(k).getBlock_table_id());
                                    blockList.add(block);
                                }
                            }
                        });
                    }

                    final Handler handler = new Handler(Looper.getMainLooper());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tabLayout.setVisibility(View.VISIBLE);
                            tabLayout.removeAllTabs();
                            for (int l = 0; l < blockList.size(); l++) {
                                tabLayout.addTab(tabLayout.newTab().setText(blockList.get(l).getBlock_name()).setTag(String.valueOf(blockList.get(l).getBlock_table_id())));
                            }
                            view_pager.setVisibility(View.VISIBLE);
                            final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);
                            final ViewPagerAdapter adapter = new ViewPagerAdapter
                                    (getChildFragmentManager(), tabLayout.getTabCount(), blockList, unitTitle);
                            viewPager.setAdapter(adapter);
                            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                            tabLayout.setTabTextColors(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                            tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                                @Override
                                public void onTabSelected(TabLayout.Tab tab) {
                                    viewPager.setCurrentItem(tab.getPosition());
                                }

                                @Override
                                public void onTabUnselected(TabLayout.Tab tab) {

                                }

                                @Override
                                public void onTabReselected(TabLayout.Tab tab) {

                                }
                            });
                        }
                    }, 100);
                } else {
                    tabLayout.setVisibility(View.GONE);
                    view_pager.setVisibility(View.GONE);
                    ll_no_record_found.setVisibility(View.VISIBLE);
                    tv_term_not_found.setVisibility(View.VISIBLE);
                    String styledText = "Term <font color='#FFCE32'>" + unitTitle + "</font> not found.";
                    tv_term_not_found.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                }
            }
        });
    }
}