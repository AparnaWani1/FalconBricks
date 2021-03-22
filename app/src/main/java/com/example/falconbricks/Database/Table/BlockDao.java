package com.example.falconbricks.Database.Table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BlockDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertBlock(TableBlockMaster tableBlockMaster);

    @Query("SELECT COUNT(fld_block_table_id) FROM tbl_block_master")
    int getCount();

    @Query("SELECT * from tbl_block_master")
    public LiveData<List<TableBlockMaster>> getBlocks();

    @Query("SELECT * from tbl_block_master where fld_block_table_id=:blockId")
    public LiveData<List<TableBlockMaster>> getBlockNameById(String blockId);

}
