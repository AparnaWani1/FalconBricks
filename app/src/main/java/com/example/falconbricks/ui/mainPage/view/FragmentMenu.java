package com.example.falconbricks.ui.mainPage.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.falconbricks.R;
import com.example.falconbricks.ui.searchPage.view.SearchFragment;
import com.example.falconbricks.ui.searchPageBonus1.view.SearchFragmentBonus1;
import com.example.falconbricks.ui.searchPageBonus2.view.SearchFragmentBonus2;
import com.example.falconbricks.ui.searchPageBonus3.view.SearchFragmentBonus3;

public class FragmentMenu extends Fragment {

    View rootView;
    Button button_basic_requirement, button_bonus_one, button_bonus_two, button_bonus_three;

    public static FragmentMenu newInstance() {
        return new FragmentMenu();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_menu, container, false);
        button_basic_requirement = rootView.findViewById(R.id.button_basic_requirement);
        button_bonus_one = rootView.findViewById(R.id.button_bonus_one);
        button_bonus_two = rootView.findViewById(R.id.button_bonus_two);
        button_bonus_three = rootView.findViewById(R.id.button_bonus_three);

        button_basic_requirement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment searchFragment = SearchFragment.newInstance();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_frame, searchFragment, "")
                        .addToBackStack(null)
                        .commit();
            }
        });
        button_bonus_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragmentBonus1 searchFragment = SearchFragmentBonus1.newInstance();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_frame, searchFragment, "")
                        .addToBackStack(null)
                        .commit();
            }
        });
        button_bonus_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragmentBonus2 searchFragment = SearchFragmentBonus2.newInstance();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_frame, searchFragment, "")
                        .addToBackStack(null)
                        .commit();
            }
        });
        button_bonus_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragmentBonus3 searchFragment = SearchFragmentBonus3.newInstance();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_frame, searchFragment, "")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }
}