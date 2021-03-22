package com.example.falconbricks.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.falconbricks.Database.Table.ActivitiesDao;
import com.example.falconbricks.Database.Table.BlockDao;
import com.example.falconbricks.Database.Table.TableActivities;
import com.example.falconbricks.Database.Table.TableBlockMaster;
import com.example.falconbricks.Database.Table.TableUnitsMaster;
import com.example.falconbricks.Database.Table.UnitsAndActivities;
import com.example.falconbricks.Database.Table.UnitsDao;

@Database(entities = {UnitsAndActivities.class,TableBlockMaster.class, TableUnitsMaster.class, TableActivities.class},
        version = 1, exportSchema = false)
public abstract class FalconBricksDB extends RoomDatabase {

    private static volatile FalconBricksDB falconBricksDB;

    public abstract BlockDao blockDao();
    public abstract UnitsDao unitsDao();
    public abstract ActivitiesDao activitiesDao();

    public static FalconBricksDB getDatabase(final Context context) {
        if (falconBricksDB == null) {
            synchronized (FalconBricksDB.class) {
                if (falconBricksDB == null) {
                    falconBricksDB = Room.databaseBuilder(context.getApplicationContext(),
                            FalconBricksDB.class, "Falconbricks_database.db").allowMainThreadQueries()
                           .build();
                }
            }
        }
        return falconBricksDB;
    }
}