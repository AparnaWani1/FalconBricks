package com.example.falconbricks.ui.searchPage.view;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.falconbricks.Database.Table.TableActivities;
import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.Database.Table.TableUnitsMaster;
import com.example.falconbricks.R;
import com.example.falconbricks.ui.mainPage.model.Activities;
import com.example.falconbricks.ui.mainPage.model.Units;
import com.example.falconbricks.ui.searchPage.adapter.SearchBlockAdapter;
import com.example.falconbricks.ui.searchPage.viewModel.SearchViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    View rootView;
    SearchViewModel searchViewModel;
    TabLayout tabLayout;

    private List<Units> unitsList = new ArrayList<>();
    private List<Activities> activitiesList = new ArrayList<>();
    RecyclerView recycler_view;
    LinearLayout ll_search, ll_no_record_found;
    TextView tv_term_not_found;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search, container, false);

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        recycler_view = rootView.findViewById(R.id.recycler_view);
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
        int close_btn = searchView.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
        ImageView iv_close = (ImageView) searchView.findViewById(close_btn);
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                ll_search.setVisibility(View.VISIBLE);
                ll_no_record_found.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                recycler_view.setVisibility(View.GONE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
// do something on text submit
                getUnitByTitle(query);
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


    private void getUnitByTitle(final String unitTitle) {
        searchViewModel.getBlockData(getActivity());
        searchViewModel.getBlockData().observe(getActivity(), new Observer<List<TableBlockMaster>>() {
            @Override
            public void onChanged(List<TableBlockMaster> blocks) {
                for (int i = 0; i < blocks.size(); i++) {
                    blocks.get(i).getBlock_name();
                    int blockId = blocks.get(i).getBlock_table_id();
                    //Get Units Data from DB using blockId
                    unitsList.clear();
                    searchViewModel.getUnitsByTitle(getActivity(), unitTitle);
                    searchViewModel.getUnitsByTitle().observe(getActivity(), new Observer<List<TableUnitsMaster>>() {
                        @Override
                        public void onChanged(final List<TableUnitsMaster> units) {

                            if (units.size() > 0) {
                                recycler_view.setVisibility(View.VISIBLE);
                                for (int j = 0; j < units.size(); j++) {
                                    int unitId = units.get(j).getUnit_id();
                                    //Get Activities Data from DB using unitId
                                    searchViewModel.getActivitiesData(getActivity(), String.valueOf(unitId));
                                    final int finalJ = j;
                                    searchViewModel.getActivitiesData().observe(getActivity(), new Observer<List<TableActivities>>() {
                                        @Override
                                        public void onChanged(List<TableActivities> tableActivities) {
                                            activitiesList.clear();
                                            for (int k = 0; k < tableActivities.size(); k++) {
                                                int unitId = tableActivities.get(k).getUnit_id();
                                                Activities activities = new Activities();
                                                activities.setActivity_name(tableActivities.get(k).getActivity_name());
                                                activities.setActivity_status(tableActivities.get(k).getActivity_status());
                                                activities.setCurrent_user_name(tableActivities.get(k).getCurrent_user_name());
                                                activities.setStep_name(tableActivities.get(k).getStep_name());
                                                activities.setProgress(tableActivities.get(k).getProgress());
                                                activities.setWf(tableActivities.get(k).getWf());
                                                activities.setUnit_title(units.get(finalJ).getFld_title());
                                                activitiesList.add(activities);
                                            }

                                            if (searchViewModel != null && searchViewModel.getActivitiesData().hasObservers()) {
                                                searchViewModel.getActivitiesData().removeObservers(getActivity());
                                            }
                                            ll_no_record_found.setVisibility(View.GONE);
                                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                                            recycler_view.setLayoutManager(mLayoutManager);
                                            SearchBlockAdapter searchBlockAdapter = new SearchBlockAdapter(getActivity(), activitiesList);
                                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                                            recycler_view.setLayoutManager(linearLayoutManager);
                                            recycler_view.setAdapter(searchBlockAdapter);
                                            searchBlockAdapter.notifyDataSetChanged();
                                        }
                                    });

                                    Units units1 = new Units();
                                    units1.setActivities(activitiesList);
                                    units1.setApt(units.get(j).getFld_apt());
                                    units1.setBlock_id(units.get(j).getFld_block_id());
                                    units1.setBlock_name(units.get(j).getFld_block_name());
                                    units1.setFloor(units.get(j).getFld_floor());
                                    units1.setId(units.get(j).getFld_id());
                                    units1.setProperty_id(units.get(j).getFld_property_id());
                                    units1.setTitle(units.get(j).getFld_title());
                                    units1.setUnit_type(units.get(j).getFld_unit_type());
                                    unitsList.add(units1);
                                }
                            } else {
                                tabLayout.setVisibility(View.GONE);
                                recycler_view.setVisibility(View.GONE);
                                ll_no_record_found.setVisibility(View.VISIBLE);
                                String styledText = "Term <font color='#FFCE32'>" + unitTitle + "</font> not found.";
                                tv_term_not_found.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                            }

                           /* if (searchViewModel != null && searchViewModel.getUnitsData().hasObservers()) {
                                searchViewModel.getUnitsData().removeObservers(getActivity());
                            }*/
                        }
                    });

                   /* Block block = new Block();
                    block.setUnits(unitsList);
                    block.setBlock_name(blocks.get(i).getBlock_name());
                    blockList.add(block);*/
                }

                if (searchViewModel != null && searchViewModel.getBlockData().hasObservers()) {
                    searchViewModel.getBlockData().removeObservers(getActivity());
                }
                /*tabLayout.setVisibility(View.VISIBLE);
                tabLayout.removeAllTabs();
                tabLayout.addTab(tabLayout.newTab().setText("ALL"));
                for (int l = 0; l < blockList.size(); l++) {
                    tabLayout.addTab(tabLayout.newTab().setText(blockList.get(l).getBlock_name()));
                }*/
            }
        });
    }
}