package com.example.falconbricks.ui.mainPage.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activities {

    @SerializedName("activity_name")
    @Expose
    private String activity_name;

    @SerializedName("activity_status")
    @Expose
    private String activity_status;

    @SerializedName("current_user_name")
    @Expose
    private String current_user_name;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("step_name")
    @Expose
    private String step_name;

    @SerializedName("progress")
    @Expose
    private String progress;

    @SerializedName("wf")
    @Expose
    private String wf;

    @SerializedName("unit_title")
    @Expose
    private String unit_title;

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_status() {
        return activity_status;
    }

    public void setActivity_status(String activity_status) {
        this.activity_status = activity_status;
    }

    public String getCurrent_user_name() {
        return current_user_name;
    }

    public void setCurrent_user_name(String current_user_name) {
        this.current_user_name = current_user_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStep_name() {
        return step_name;
    }

    public void setStep_name(String step_name) {
        this.step_name = step_name;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getWf() {
        return wf;
    }

    public void setWf(String wf) {
        this.wf = wf;
    }

    public String getUnit_title() {
        return unit_title;
    }

    public void setUnit_title(String unit_title) {
        this.unit_title = unit_title;
    }
}
