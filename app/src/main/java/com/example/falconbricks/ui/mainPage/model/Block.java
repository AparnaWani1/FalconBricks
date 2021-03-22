package com.example.falconbricks.ui.mainPage.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Block {

    @SerializedName("block_name")
    @Expose
    private String block_name;

    @SerializedName("units")
    @Expose
    List<Units> units;

   /* public Block(String block_name, List<Units> units) {
        this.block_name = block_name;
        this.units = units;
    }*/

    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }

    public List<Units> getUnits() {
        return units;
    }

    public void setUnits(List<Units> units) {
        this.units = units;
    }
}
