package ru.fotostrana.socketapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.fotostrana.socketapp.R;
import ru.fotostrana.socketapp.model.LevelMaster;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {
    Context context;
    ArrayList<LevelMaster> DataOfLevelView = new ArrayList<>();
    Boolean issecond;
    public LevelAdapter(Context context, ArrayList<LevelMaster> DataOfLevelView, Boolean issecond) {
        this.context = context;
        this.DataOfLevelView = DataOfLevelView;
        this.issecond = issecond;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgofLevel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgofLevel = itemView.findViewById(R.id.imgofLevel);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.raw_level, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LevelMaster levelMaster = DataOfLevelView.get(position);
        if (!issecond)
            if (levelMaster.getIslevelCompleted()) {
                Drawable drawable = context.getResources().getDrawable(context.getResources()
                        .getIdentifier("y" + (position + 1), "drawable", context.getPackageName()));
                holder.imgofLevel.setImageDrawable(drawable);
            } else {
                holder.imgofLevel.setImageDrawable(levelMaster.getLevelImages());
            }
        else {
            if (levelMaster.getIslevelCompleted()) {
                Drawable drawable = context.getResources().getDrawable(context.getResources()
                        .getIdentifier("y" + (position + 1+12), "drawable", context.getPackageName()));
                holder.imgofLevel.setImageDrawable(drawable);

            } else {
                holder.imgofLevel.setImageDrawable(levelMaster.getLevelImages());
            }
        }
    }
    @Override
    public int getItemCount() {
        return DataOfLevelView.size();
    }
}

