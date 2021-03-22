package com.example.falconbricks.Database.Table;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity
public class UnitsAndActivities {


    @PrimaryKey()
    @NonNull
    String fld_title;
    String fld_unit_type;
    String fld_activity_id;
    String fld_unit_id_by_unit_table;
    String fld_block_table_id_from_block_table;
    String fld_activity_name;
    String fld_activity_status;
    String fld_current_user_name;
    String fld_step_name;
    String fld_progress;
    String fld_wf;

    public String getFld_title() {
        return fld_title;
    }

    public void setFld_title(String fld_title) {
        this.fld_title = fld_title;
    }

    public String getFld_block_table_id_from_block_table() {
        return fld_block_table_id_from_block_table;
    }

    public void setFld_block_table_id_from_block_table(String fld_block_table_id_from_block_table) {
        this.fld_block_table_id_from_block_table = fld_block_table_id_from_block_table;
    }

    public String getFld_activity_name() {
        return fld_activity_name;
    }

    public void setFld_activity_name(String fld_activity_name) {
        this.fld_activity_name = fld_activity_name;
    }

    public String getFld_activity_status() {
        return fld_activity_status;
    }

    public void setFld_activity_status(String fld_activity_status) {
        this.fld_activity_status = fld_activity_status;
    }

    public String getFld_current_user_name() {
        return fld_current_user_name;
    }

    public void setFld_current_user_name(String fld_current_user_name) {
        this.fld_current_user_name = fld_current_user_name;
    }

    public String getFld_step_name() {
        return fld_step_name;
    }

    public void setFld_step_name(String fld_step_name) {
        this.fld_step_name = fld_step_name;
    }

    public String getFld_progress() {
        return fld_progress;
    }

    public void setFld_progress(String fld_progress) {
        this.fld_progress = fld_progress;
    }

    public String getFld_wf() {
        return fld_wf;
    }

    public void setFld_wf(String fld_wf) {
        this.fld_wf = fld_wf;
    }

}
