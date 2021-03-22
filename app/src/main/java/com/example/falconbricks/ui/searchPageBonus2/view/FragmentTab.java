package com.example.falconbricks.ui.searchPageBonus2.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.Database.Table.UnitsAndActivities;
import com.example.falconbricks.R;
import com.example.falconbricks.ui.searchPageBonus2.adapter.SearchBlockAdapterForAllSearch;
import com.example.falconbricks.ui.searchPageBonus2.viewModel.SearchViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTab extends Fragment {

    View rootView;
    RecyclerView recycler_view;
    private List<TableBlockMaster> blockList = new ArrayList<>();
    private List<UnitsAndActivities> unitsAndActivitiesList = new ArrayList<>();
    int blockId, index;
    String searchTerm;
    SearchViewModel searchViewModel;

    public static FragmentTab newInstance(int index, int blockId, String searchTerm) {
        FragmentTab f = new FragmentTab();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("blockId", blockId);
        args.putString("searchTerm", searchTerm);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_tab, container, false);

        Bundle args = getArguments();
        index = args.getInt("index", 0);
        blockId = args.getInt("blockId", 0);
        searchTerm = args.getString("searchTerm", "");

        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        recycler_view = rootView.findViewById(R.id.recycler_view);


        getUnitsByBlockId(index, searchTerm, blockId);
        return rootView;
    }

    private void getUnitsByBlockId(int index, final String unitTitle, int blockId) {
        unitsAndActivitiesList.clear();
        blockList.clear();
        if (blockId == 0) {
            getUnitsByAll(unitTitle);
        } else {
            searchViewModel.getUnitsByBlockId(getActivity(), unitTitle, String.valueOf(blockId));
            searchViewModel.getUnitsByBlockId().observe(getActivity(), new Observer<List<UnitsAndActivities>>() {
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
                        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                        recycler_view.setLayoutManager(mLayoutManager);
                        SearchBlockAdapterForAllSearch searchBlockAdapter = new SearchBlockAdapterForAllSearch(getActivity(), unitsAndActivitiesList);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                        recycler_view.setLayoutManager(linearLayoutManager);
                        recycler_view.setAdapter(searchBlockAdapter);
                        searchBlockAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getActivity(), "No record found", Toast.LENGTH_SHORT).show();
                        recycler_view.setVisibility(View.GONE);
                        }
                }
            });
        }
    }

    private void getUnitsByAll(final String unitTitle) {
        unitsAndActivitiesList.clear();
        blockList.clear();
        searchViewModel.getUnitsByAll(getActivity(), unitTitle);
        searchViewModel.getUnitsByAll().observe(getActivity(), new Observer<List<UnitsAndActivities>>() {
            @Override
            public void onChanged(List<UnitsAndActivities> unitsAndActivities) {

                if(unitsAndActivities.size() > 0) {
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
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
                    recycler_view.setLayoutManager(mLayoutManager);
                    SearchBlockAdapterForAllSearch searchBlockAdapter = new SearchBlockAdapterForAllSearch(getActivity(), unitsAndActivitiesList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                    recycler_view.setLayoutManager(linearLayoutManager);
                    recycler_view.setAdapter(searchBlockAdapter);
                    searchBlockAdapter.notifyDataSetChanged();
                }
            }
        });
    }

}
