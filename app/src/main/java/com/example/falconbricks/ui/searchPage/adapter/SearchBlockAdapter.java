package com.example.falconbricks.ui.searchPage.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falconbricks.R;
import com.example.falconbricks.ui.mainPage.model.Activities;

import java.util.List;


public class SearchBlockAdapter extends RecyclerView.Adapter<SearchBlockAdapter.SearchBlockViewHolder> {

    Context context;
    List<Activities> activitiesList;
    List<Activities> activitiesListFiltered;
    public SearchBlockAdapter(Context context, List<Activities> activitiesList) {
        this.context = context;
        this.activitiesList = activitiesList;
        this.activitiesListFiltered = activitiesList;
    }

    @NonNull
    @Override
    public SearchBlockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_block, parent, false);
        return new SearchBlockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchBlockViewHolder holder, final int position) {

        try {
            Activities blocks = activitiesList.get(position);
           holder.tv_unit_title.setText(blocks.getUnit_title());
           holder.tv_step_name.setText("Step Name - "+blocks.getStep_name());
           holder.tv_activity_name.setText(blocks.getActivity_name());
           holder.tv_progress.setText(blocks.getProgress()+"%");
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

        TextView tv_unit_title, tv_step_name, tv_activity_name, tv_progress;

        public SearchBlockViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_unit_title = itemView.findViewById(R.id.tv_unit_title);
            tv_step_name = itemView.findViewById(R.id.tv_step_name);
            tv_activity_name = itemView.findViewById(R.id.tv_activity_name);
            tv_progress = itemView.findViewById(R.id.tv_progress);
        }
    }

}