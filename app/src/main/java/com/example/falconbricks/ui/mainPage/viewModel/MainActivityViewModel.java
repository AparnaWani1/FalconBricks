package com.example.falconbricks.ui.mainPage.viewModel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.falconbricks.Database.FalconBricksDB;
import com.example.falconbricks.Database.Table.TableActivities;
import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.Database.Table.TableUnitsMaster;
import com.example.falconbricks.ui.mainPage.model.Activities;
import com.example.falconbricks.ui.mainPage.model.Block;
import com.example.falconbricks.ui.mainPage.model.Units;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    FalconBricksDB falconBricksDB;


    public String getJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");

            byte[] bytes = new byte[is.available()];
            is.read(bytes, 0, bytes.length);
            json = new String(bytes);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Log.e("data===>", json);
        return json;
    }

    public void insertIntoDb(Context context, List<Block> blocks) {
        falconBricksDB = FalconBricksDB.getDatabase(context);

        for (int i = 0; i < blocks.size(); i++) {
            TableBlockMaster tableBlockMaster = new TableBlockMaster();
            tableBlockMaster.setBlock_name(blocks.get(i).getBlock_name());
            falconBricksDB.blockDao().insertBlock(tableBlockMaster);

            int block_id = falconBricksDB.blockDao().getCount();

            List<Units> unitsList = blocks.get(i).getUnits();
            for (int j = 0; j < unitsList.size(); j++) {
                TableUnitsMaster tableUnitsMaster = new TableUnitsMaster();
                tableUnitsMaster.setFld_block_table_id(String.valueOf(block_id));
                tableUnitsMaster.setFld_block_name(unitsList.get(j).getBlock_name());
                tableUnitsMaster.setFld_block_id(unitsList.get(j).getBlock_id());
                tableUnitsMaster.setFld_apt(unitsList.get(j).getApt());
                tableUnitsMaster.setFld_floor(unitsList.get(j).getFloor());
                tableUnitsMaster.setFld_id(unitsList.get(j).getId());
                tableUnitsMaster.setFld_property_id(unitsList.get(j).getProperty_id());
                tableUnitsMaster.setFld_title(unitsList.get(j).getTitle());
                tableUnitsMaster.setFld_unit_type(unitsList.get(j).getUnit_type());

                String strUnitTitle = unitsList.get(j).getTitle();
                falconBricksDB.unitsDao().insertUnits(tableUnitsMaster);

                int units_id = falconBricksDB.unitsDao().getUnitsCount();
                List<Activities> activitiesList = blocks.get(i).getUnits().get(j).getActivities();
                for (int k = 0; k < activitiesList.size(); k++) {
                    TableActivities tableActivities = new TableActivities();
                    tableActivities.setUnit_id(units_id);
                    tableActivities.setFld_block_table_id(String.valueOf(block_id));
                    tableActivities.setActivity_name(activitiesList.get(k).getActivity_name());
                    tableActivities.setActivity_status(activitiesList.get(k).getActivity_status());
                    tableActivities.setCurrent_user_name(activitiesList.get(k).getCurrent_user_name());
                    //tableActivities.setId(activitiesList.get(k).getId());
                    tableActivities.setStep_name(activitiesList.get(k).getStep_name());
                    tableActivities.setProgress(activitiesList.get(k).getProgress());
                    tableActivities.setWf(activitiesList.get(k).getWf());
                    tableActivities.setUnit_title(strUnitTitle);

                    falconBricksDB.activitiesDao().insertActivities(tableActivities);
                }
            }
        }
    }


}
