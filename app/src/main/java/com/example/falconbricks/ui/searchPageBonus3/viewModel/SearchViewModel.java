package com.example.falconbricks.ui.searchPageBonus3.viewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.falconbricks.Database.FalconBricksDB;
import com.example.falconbricks.Database.Table.TableActivities;
import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.Database.Table.TableUnitsMaster;
import com.example.falconbricks.Database.Table.UnitsAndActivities;

import java.util.List;

public class SearchViewModel extends ViewModel {

    FalconBricksDB falconBricksDB;
    private LiveData<List<TableBlockMaster>> blockListById;
    private LiveData<List<UnitsAndActivities>> unitsListByAll;
    private int count;

    public int getCount(Context context) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        count = falconBricksDB.blockDao().getCount();
        return count;
    }



    public void getBlockNameById(Context context,String blockId) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        blockListById = falconBricksDB.blockDao().getBlockNameById(blockId);
    }

    public LiveData<List<TableBlockMaster>> getBlockNameById() {
        return blockListById;
    }

    public void getUnitsByAll(Context context, String unitTitle) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        unitsListByAll = falconBricksDB.unitsDao().searchUnitsByAll(unitTitle);
    }

    public LiveData<List<UnitsAndActivities>> getUnitsByAll() {
        return unitsListByAll;
    }

    public void getUnitsByBlockId(Context context, String unitTitle,String blockId) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        unitsListByAll = falconBricksDB.unitsDao().searchUnitsByBlockId(unitTitle,blockId);
    }

    public LiveData<List<UnitsAndActivities>> getUnitsByBlockId() {
        return unitsListByAll;
    }

}
