package ru.fotostrana.socketapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.adapter.LevelAdapter;
import ru.fotostrana.socketapp.constant.Preference;
import ru.fotostrana.socketapp.model.LevelMaster;

public class FirstFragment extends Fragment {
    View view;
    RecyclerView recycleview;
    ArrayList<LevelMaster> DataOfLevelView = new ArrayList<>();
    LevelAdapter levelAdapter;


    public FirstFragment(Activity context, ArrayList<LevelMaster> DataOfLevelView) {
        this.DataOfLevelView = new ArrayList<>();
        this.DataOfLevelView = DataOfLevelView;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_level, container, false);
        recycleview = view.findViewById(R.id.recycleview);
        recycleview.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        levelAdapter = new LevelAdapter(getActivity(), DataOfLevelView,false);


        if (Preference.getLevel() < 12)
            for (int i = 0; i < Preference.getLevel(); i++) {
                DataOfLevelView.get(i).setIslevelCompleted(true);
            }
        else {
            for (int i = 0; i < 12; i++) {
                DataOfLevelView.get(i).setIslevelCompleted(true);
            }
        }


        recycleview.setAdapter(levelAdapter);
        return view;

    }
}
