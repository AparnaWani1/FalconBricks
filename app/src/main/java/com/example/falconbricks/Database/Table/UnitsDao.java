package com.example.falconbricks.Database.Table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UnitsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertUnits(TableUnitsMaster tableUnitsMaster);

    @Query("SELECT COUNT(fld_unit_id) FROM tbl_units_master")
    int getUnitsCount();

    @Query("SELECT * from tbl_units_master WHERE fld_block_table_id=:blockId")
    public LiveData<List<TableUnitsMaster>> getUnits(String blockId);

    // @Query("SELECT * from tbl_units_master WHERE fld_title=:unitTitle")
    @Query("SELECT * from tbl_units_master WHERE fld_title LIKE '%' || :unitTitle || '%'")
    public LiveData<List<TableUnitsMaster>> searchUnits(String unitTitle);

    @Query("SELECT um.* ,ac.* from tbl_units_master as um left join tbl_activity as ac ON um.fld_block_table_id = ac.fld_block_table_id_from_block_table " +
            "WHERE um.fld_title LIKE '%' || :searchTerm || '%' " +
            "OR ac.fld_activity_status LIKE '%' || :searchTerm || '%' " +
            "OR ac.fld_activity_name LIKE '%' || :searchTerm || '%' GROUP BY ac.fld_unit_id_by_unit_table" )
            public LiveData<List<UnitsAndActivities>> searchUnitsByAll(String searchTerm);

    @Query("SELECT um.* ,ac.* from tbl_units_master as um left join tbl_activity as ac ON um.fld_block_table_id = ac.fld_block_table_id_from_block_table " +
            "WHERE ac.fld_block_table_id_from_block_table=:blockId AND (um.fld_title LIKE '%' || :searchTerm || '%' " +
            "OR ac.fld_activity_status LIKE '%' || :searchTerm || '%' " +
            "OR ac.fld_activity_name LIKE '%' || :searchTerm || '%') GROUP BY ac.fld_unit_id_by_unit_table" )
    public LiveData<List<UnitsAndActivities>> searchUnitsByBlockId(String searchTerm,String blockId);
}