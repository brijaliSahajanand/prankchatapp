package ru.fotostrana.socketapp.model;

import android.graphics.drawable.Drawable;

public class LevelMaster {
    int levelnumber;
    Drawable levelImages;
    Boolean IslevelCompleted =false;

    public LevelMaster(Drawable levelImages) {
        this.levelImages = levelImages;
    }

    public LevelMaster(Boolean islevelCompleted) {
        IslevelCompleted = islevelCompleted;
    }

    public int getLevelnumber() {
        return levelnumber;
    }

    public void setLevelnumber(int levelnumber) {
        this.levelnumber = levelnumber;
    }

    public Boolean getIslevelCompleted() {
        return IslevelCompleted;
    }

    public void setIslevelCompleted(Boolean islevelCompleted) {
        IslevelCompleted = islevelCompleted;
    }

    public Drawable getLevelImages() {
        return levelImages;
    }

    public void setLevelImages(Drawable levelImages) {
        this.levelImages = levelImages;
    }
}
