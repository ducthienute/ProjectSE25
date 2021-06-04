package com.example.project_healthcare_v10.Main.Fragment;

import com.example.project_healthcare_v10.R;

public class Status {
    int priority;
    private String evaluate, description;
    private int imgId;
    private static final int[] bgColorId = {
            R.color.light_red,
            R.color.light_red_x,
            R.color.light_orange,
            R.color.light_green_x,
            R.color.light_green
    } ;
    private static final int[] textColorId = {
            R.color.dark_red,
            R.color.red,
            R.color.orange,
            R.color.green,
            R.color.dark_green
    } ;


    public Status(int priority, String evaluate, String description, int imgId) {
        this.evaluate = evaluate;
        this.description = description;
        this.imgId = imgId;
        this.priority = priority;
    }

    public void merge(Status status) {
        if (this.getPriority() <= status.getPriority()) {
            this.setDescription(status.getDescription() + "\n" + this.getDescription());
        } else {
            this.setPriority(status.getPriority());
            this.setDescription(this.getDescription() + "\n" + status.getDescription());
            this.setEvaluate(status.getEvaluate());
            this.setImgId(status.getImgId());
        }
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }


    public int getPriority() {
        return priority;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public String getDescription() {
        return description;
    }

    public int getBgColorId() {
        return bgColorId[priority];
    }

    public int getImgId() {
        return imgId;
    }

    public int getTextColorId() {
        return textColorId[priority];
    }

    public Status clone() {
        return new Status(getPriority(),getEvaluate(),getDescription(),getImgId());

    }
}
