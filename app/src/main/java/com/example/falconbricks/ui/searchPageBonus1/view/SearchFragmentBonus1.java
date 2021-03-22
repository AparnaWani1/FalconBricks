package com.example.falconbricks.ui.searchPageBonus1.view;

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

import com.example.falconbricks.Database.Table.UnitsAndActivities;
import com.example.falconbricks.R;
import com.example.falconbricks.ui.mainPage.model.Activities;
import com.example.falconbricks.ui.mainPage.model.Block;
import com.example.falconbricks.ui.mainPage.model.Units;
import com.example.falconbricks.ui.searchPageBonus1.adapter.SearchBlockAdapterForAllSearch;
import com.example.falconbricks.ui.searchPageBonus1.viewModel.SearchViewModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchFragmentBonus1 extends Fragment {

    View rootView;
    SearchViewModel searchViewModel;
    TabLayout tabLayout;

    private List<Block> blockList = new ArrayList<>();
    private List<Units> unitsList = new ArrayList<>();
    private List<Activities> activitiesList = new ArrayList<>();
    private List<UnitsAndActivities> unitsAndActivitiesList = new ArrayList<>();
    RecyclerView recycler_view;
    LinearLayout ll_search, ll_no_record_found;
    TextView tv_term_not_found;

    public static SearchFragmentBonus1 newInstance() {
        return new SearchFragmentBonus1();
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
                recycler_view.setVisibility(View.GONE);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getUnitsByAll(query);
                ll_search.setVisibility(View.GONE);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return rootView;
    }

    private void getUnitsByAll(final String unitTitle) {
        unitsAndActivitiesList.clear();
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
                    }

                    recycler_view.setVisibility(View.VISIBLE);
                    ll_no_record_found.setVisibility(View.GONE);
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                    recycler_view.setLayoutManager(mLayoutManager);
                    SearchBlockAdapterForAllSearch searchBlockAdapter = new SearchBlockAdapterForAllSearch(getActivity(), unitsAndActivitiesList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                    recycler_view.setLayoutManager(linearLayoutManager);
                    recycler_view.setAdapter(searchBlockAdapter);
                    searchBlockAdapter.notifyDataSetChanged();
                } else {
                    recycler_view.setVisibility(View.GONE);
                    ll_no_record_found.setVisibility(View.VISIBLE);
                    tv_term_not_found.setVisibility(View.VISIBLE);
                    String styledText = "Term <font color='#FFCE32'>" + unitTitle + "</font> not found.";
                    tv_term_not_found.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);
                }
            }
        });
    }
}