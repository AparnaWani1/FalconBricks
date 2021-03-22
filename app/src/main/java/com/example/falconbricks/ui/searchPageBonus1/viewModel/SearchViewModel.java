package com.example.falconbricks.ui.searchPageBonus1.viewModel;

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
    private LiveData<List<TableBlockMaster>> blockList;
    private LiveData<List<TableUnitsMaster>> unitsList;
    private LiveData<List<TableUnitsMaster>> unitsListByTitle;
    private LiveData<List<UnitsAndActivities>> unitsListByAll;
    private LiveData<List<TableActivities>> activitiesList;
    private int count;

    public int getCount(Context context) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        count = falconBricksDB.blockDao().getCount();
        return count;
    }



    public void getBlockData(Context context) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        blockList = falconBricksDB.blockDao().getBlocks();
    }

    public LiveData<List<TableBlockMaster>> getBlockData() {
        return blockList;
    }

    public void getUnitsData(Context context, String blockId) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        unitsList = falconBricksDB.unitsDao().getUnits(blockId);
    }

    public LiveData<List<TableUnitsMaster>> getUnitsData() {
        return unitsList;
    }

    public void getUnitsByTitle(Context context, String unitTitle) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        unitsListByTitle = falconBricksDB.unitsDao().searchUnits(unitTitle);
    }

    public LiveData<List<TableUnitsMaster>> getUnitsByTitle() {
        return unitsListByTitle;
    }
    public void getUnitsByAll(Context context, String unitTitle) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        unitsListByAll = falconBricksDB.unitsDao().searchUnitsByAll(unitTitle);
    }

    public LiveData<List<UnitsAndActivities>> getUnitsByAll() {
        return unitsListByAll;
    }

    public void getActivitiesData(Context context, String unitId) {
        falconBricksDB = FalconBricksDB.getDatabase(context);
        activitiesList = falconBricksDB.activitiesDao().getActivities(unitId);
    }

    public LiveData<List<TableActivities>> getActivitiesData() {
        return activitiesList;
    }
}
