package com.example.falconbricks.ui.searchPageBonus3.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falconbricks.Database.Table.UnitsAndActivities;
import com.example.falconbricks.R;

import java.util.List;


public class SearchBlockAdapterForAllSearch extends RecyclerView.Adapter<SearchBlockAdapterForAllSearch.SearchBlockViewHolder> {

    Context context;
    List<UnitsAndActivities> activitiesList;
    List<UnitsAndActivities> activitiesListFiltered;
    String unitTitle = " ";

    public SearchBlockAdapterForAllSearch(Context context, List<UnitsAndActivities> activitiesList) {
        this.context = context;
        this.activitiesList = activitiesList;
        this.activitiesListFiltered = activitiesList;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public SearchBlockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_search_bonus_3, parent, false);
        return new SearchBlockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SearchBlockViewHolder holder, final int position) {

        try {
            UnitsAndActivities blocks = activitiesList.get(position);

            if (unitTitle.equalsIgnoreCase(blocks.getFld_title())) {
                holder.cv_unit.setVisibility(View.GONE);

                unitTitle = blocks.getFld_title();
            } else {
                holder.cv_unit.setVisibility(View.VISIBLE);

                unitTitle = blocks.getFld_title();
            }
            holder.tv_unit_title.setText(blocks.getFld_title());
            holder.tv_step_name.setText("Step Name - " + blocks.getFld_step_name());
            holder.tv_activity_name.setText(blocks.getFld_activity_name());
            holder.tv_progress.setText(blocks.getFld_progress() + "%");

            LinearLayout.LayoutParams rpms2, rprms;
            LinearLayout l3 = new LinearLayout(context);
            Float weight = ((Float.parseFloat(blocks.getFld_progress())));
            LinearLayout ll2 = new LinearLayout(context);
            ll2.setOrientation(LinearLayout.HORIZONTAL);
            ll2.setPadding(10, 10, 10, 10);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor("#FFCE32"));
            ll2.setBackground(gradientDrawable);
            ll2.setMinimumHeight(15);
            rprms = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            rprms.setMargins(0, 0, 0, 0);
            rpms2 = new LinearLayout.LayoutParams(0,
                    ViewGroup.LayoutParams.MATCH_PARENT, weight);
            rpms2.setMargins(0, 0, 0, 0);
            l3.setLayoutParams(rprms);
            l3.setWeightSum(100);
            l3.setMinimumHeight(40);


            l3.addView(ll2, rpms2);
            holder.lin_graph.addView(l3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        Log.e("Size==>", "" + activitiesList.size());
        return activitiesList.size();
    }

    public class SearchBlockViewHolder extends RecyclerView.ViewHolder {

        TextView tv_unit_title, tv_step_name, tv_activity_name, tv_progress;
        CardView cv_unit;
        LinearLayout lin_graph;

        public SearchBlockViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_unit_title = itemView.findViewById(R.id.tv_unit_title);
            tv_step_name = itemView.findViewById(R.id.tv_step_name);
            tv_activity_name = itemView.findViewById(R.id.tv_activity_name);
            tv_progress = itemView.findViewById(R.id.tv_progress);
            cv_unit = itemView.findViewById(R.id.cv_unit);
            lin_graph = itemView.findViewById(R.id.lin_graph);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

}