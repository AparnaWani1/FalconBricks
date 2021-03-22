package com.example.falconbricks.Database.Table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "tbl_activity")
public class TableActivities {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "fld_activity_id")
    int activity_id;
    @ColumnInfo(name = "fld_unit_id_by_unit_table")
    int unit_id;

    @ForeignKey(entity = TableBlockMaster.class, parentColumns = "fld_unit_id", childColumns = "fld_unit_id_by_unit_table")
    @ColumnInfo(name = "fld_block_table_id_from_block_table")
    String fld_block_table_id;
    @ColumnInfo(name = "fld_activity_name")
    String activity_name;
    @ColumnInfo(name = "fld_activity_status")
    String activity_status;
    @ColumnInfo(name = "fld_current_user_name")
    String current_user_name;
   /* @ColumnInfo(name = "fld_id")
    String id;*/
    @ColumnInfo(name = "fld_step_name")
    String step_name;
    @ColumnInfo(name = "fld_progress")
    String progress;
    @ColumnInfo(name = "fld_wf")
    String wf;
    @ColumnInfo(name = "fld_unit_title")
    String unit_title;

    public String getUnit_title() {
        return unit_title;
    }

    public void setUnit_title(String unit_title) {
        this.unit_title = unit_title;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getFld_block_table_id() {
        return fld_block_table_id;
    }

    public void setFld_block_table_id(String fld_block_table_id) {
        this.fld_block_table_id = fld_block_table_id;
    }

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

/*    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

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
}
