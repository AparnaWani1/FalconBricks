package com.example.falconbricks.Database.Table;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ActivitiesDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertActivities(TableActivities tableActivities);


    @Query("SELECT * from tbl_activity WHERE fld_unit_id_by_unit_table=:unitId")
    public LiveData<List<TableActivities>> getActivities(String unitId);
}
