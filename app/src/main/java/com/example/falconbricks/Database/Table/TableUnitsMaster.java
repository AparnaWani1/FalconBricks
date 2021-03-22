package com.example.falconbricks.Database.Table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "tbl_units_master")
public class TableUnitsMaster {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "fld_unit_id")
    int unit_id;

    @ColumnInfo(name = "fld_block_table_id")
    String fld_block_table_id;
    @ColumnInfo(name = "fld_apt")
    String fld_apt;
    @ColumnInfo(name = "fld_block_id")
    String fld_block_id;
    @ColumnInfo(name = "fld_block_name")
    String fld_block_name;
    @ColumnInfo(name = "fld_floor")
    String fld_floor;
    @ColumnInfo(name = "fld_id")
    String fld_id;
    @ColumnInfo(name = "fld_property_id")
    String fld_property_id;
    @ColumnInfo(name = "fld_title")
    String fld_title;
    @ColumnInfo(name = "fld_unit_type")
    String fld_unit_type;


    public String getFld_block_table_id() {
        return fld_block_table_id;
    }

    public void setFld_block_table_id(String fld_block_table_id) {
        this.fld_block_table_id = fld_block_table_id;
    }

    public String getFld_block_name() {
        return fld_block_name;
    }

    public void setFld_block_name(String fld_block_name) {
        this.fld_block_name = fld_block_name;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getFld_block_id() {
        return fld_block_id;
    }

    public void setFld_block_id(String fld_block_id) {
        this.fld_block_id = fld_block_id;
    }

    public String getFld_apt() {
        return fld_apt;
    }

    public void setFld_apt(String fld_apt) {
        this.fld_apt = fld_apt;
    }

    public String getFld_floor() {
        return fld_floor;
    }

    public void setFld_floor(String fld_floor) {
        this.fld_floor = fld_floor;
    }

    public String getFld_id() {
        return fld_id;
    }

    public void setFld_id(String fld_id) {
        this.fld_id = fld_id;
    }

    public String getFld_property_id() {
        return fld_property_id;
    }

    public void setFld_property_id(String fld_property_id) {
        this.fld_property_id = fld_property_id;
    }

    public String getFld_title() {
        return fld_title;
    }

    public void setFld_title(String fld_title) {
        this.fld_title = fld_title;
    }

    public String getFld_unit_type() {
        return fld_unit_type;
    }

    public void setFld_unit_type(String fld_unit_type) {
        this.fld_unit_type = fld_unit_type;
    }
}
