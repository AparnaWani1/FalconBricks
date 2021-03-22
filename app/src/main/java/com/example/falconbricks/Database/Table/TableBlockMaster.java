package com.example.falconbricks.Database.Table;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_block_master")
public class TableBlockMaster {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "fld_block_table_id")
    int block_table_id;
    @ColumnInfo(name = "fld_block_name")
    String block_name;


    public int getBlock_table_id() {
        return block_table_id;
    }

    public void setBlock_table_id(int block_table_id) {
        this.block_table_id = block_table_id;
    }


    public String getBlock_name() {
        return block_name;
    }

    public void setBlock_name(String block_name) {
        this.block_name = block_name;
    }
}
