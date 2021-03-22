package com.example.falconbricks.ui.searchPageBonus1.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falconbricks.Database.Table.UnitsAndActivities;
import com.example.falconbricks.R;

import java.util.List;


public class SearchBlockAdapterForAllSearch extends RecyclerView.Adapter<SearchBlockAdapterForAllSearch.SearchBlockViewHolder> {

    Context context;
    List<UnitsAndActivities> activitiesList;
    List<UnitsAndActivities> activitiesListFiltered;
    public SearchBlockAdapterForAllSearch(Context context, List<UnitsAndActivities> activitiesList) {
        this.context = context;
        this.activitiesList = activitiesList;
        this.activitiesListFiltered = activitiesList;
    }

    @NonNull
    @Override
    public SearchBlockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_search, parent, false);
        return new SearchBlockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchBlockViewHolder holder, final int position) {

        try {
            UnitsAndActivities blocks = activitiesList.get(position);
           holder.tv_unit_title.setText(blocks.getFld_title());
           holder.tv_step_name.setText("Step Name - "+blocks.getFld_step_name());
           holder.tv_activity_name.setText(blocks.getFld_activity_name());
           holder.tv_progress.setText(blocks.getFld_progress()+"%");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        Log.e("Size==>",""+ activitiesList.size());
        return activitiesList.size();
    }

    public class SearchBlockViewHolder extends RecyclerView.ViewHolder {

        TextView tv_unit_title, tv_step_name, tv_activity_name, tv_progress,tv_sr_no;

        public SearchBlockViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_unit_title = itemView.findViewById(R.id.tv_unit_title);
            tv_step_name = itemView.findViewById(R.id.tv_step_name);
            tv_activity_name = itemView.findViewById(R.id.tv_activity_name);
            tv_progress = itemView.findViewById(R.id.tv_progress);
        }
    }

}