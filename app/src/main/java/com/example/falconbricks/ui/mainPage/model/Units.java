package com.example.falconbricks.ui.mainPage.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Units {

    @SerializedName("activities")
    @Expose
    List<Activities> activities;

    @SerializedName("apt")
    @Expose
    String apt;

    @SerializedName("block_id")
    @Expose
    String block_id;

    @SerializedName("block_name")
    @Expose
    String block_name;

    @SerializedName("floor")
    @Expose
    String floor;

    @SerializedName("id")
    @Expose
    String id;

    @SerializedName("property_id")
    @Expose
    String property_id;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("unit_type")
    @Expose
    String unit_type;


    public void setActivities(List<Activities> activities) {
        this.activities = activities;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public void setBlock_id(String block_id) {
        this.block_id = block_id;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }

    public List<Activities> getActivities() {
        return activities;
    }

    public String getApt() {
        return apt;
    }

    public String getBlock_id() {
        return block_id;
    }

    public String getBlock_name() {
        return block_name;
    }

    public String getFloor() {
        return floor;
    }

    public String getId() {
        return id;
    }

    public String getProperty_id() {
        return property_id;
    }

    public String getTitle() {
        return title;
    }

    public String getUnit_type() {
        return unit_type;
    }
}
