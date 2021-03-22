package com.example.falconbricks.Database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.falconbricks.Database.Table.ActivitiesDao;
import com.example.falconbricks.Database.Table.ActivitiesDao_Impl;
import com.example.falconbricks.Database.Table.BlockDao;
import com.example.falconbricks.Database.Table.BlockDao_Impl;
import com.example.falconbricks.Database.Table.UnitsDao;
import com.example.falconbricks.Database.Table.UnitsDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FalconBricksDB_Impl extends FalconBricksDB {
  private volatile BlockDao _blockDao;

  private volatile UnitsDao _unitsDao;

  private volatile ActivitiesDao _activitiesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `UnitsAndActivities` (`fld_title` TEXT NOT NULL, `fld_unit_type` TEXT, `fld_activity_id` TEXT, `fld_unit_id_by_unit_table` TEXT, `fld_block_table_id_from_block_table` TEXT, `fld_activity_name` TEXT, `fld_activity_status` TEXT, `fld_current_user_name` TEXT, `fld_step_name` TEXT, `fld_progress` TEXT, `fld_wf` TEXT, PRIMARY KEY(`fld_title`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_block_master` (`fld_block_table_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fld_block_name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_units_master` (`fld_unit_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fld_block_table_id` TEXT, `fld_apt` TEXT, `fld_block_id` TEXT, `fld_block_name` TEXT, `fld_floor` TEXT, `fld_id` TEXT, `fld_property_id` TEXT, `fld_title` TEXT, `fld_unit_type` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_activity` (`fld_activity_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fld_unit_id_by_unit_table` INTEGER NOT NULL, `fld_block_table_id_from_block_table` TEXT, `fld_activity_name` TEXT, `fld_activity_status` TEXT, `fld_current_user_name` TEXT, `fld_step_name` TEXT, `fld_progress` TEXT, `fld_wf` TEXT, `fld_unit_title` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '42b8719c16dc814f159b2863ec93bd3c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `UnitsAndActivities`");
        _db.execSQL("DROP TABLE IF EXISTS `tbl_block_master`");
        _db.execSQL("DROP TABLE IF EXISTS `tbl_units_master`");
        _db.execSQL("DROP TABLE IF EXISTS `tbl_activity`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUnitsAndActivities = new HashMap<String, TableInfo.Column>(11);
        _columnsUnitsAndActivities.put("fld_title", new TableInfo.Column("fld_title", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_unit_type", new TableInfo.Column("fld_unit_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_activity_id", new TableInfo.Column("fld_activity_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_unit_id_by_unit_table", new TableInfo.Column("fld_unit_id_by_unit_table", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_block_table_id_from_block_table", new TableInfo.Column("fld_block_table_id_from_block_table", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_activity_name", new TableInfo.Column("fld_activity_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_activity_status", new TableInfo.Column("fld_activity_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_current_user_name", new TableInfo.Column("fld_current_user_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_step_name", new TableInfo.Column("fld_step_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_progress", new TableInfo.Column("fld_progress", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnitsAndActivities.put("fld_wf", new TableInfo.Column("fld_wf", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnitsAndActivities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUnitsAndActivities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUnitsAndActivities = new TableInfo("UnitsAndActivities", _columnsUnitsAndActivities, _foreignKeysUnitsAndActivities, _indicesUnitsAndActivities);
        final TableInfo _existingUnitsAndActivities = TableInfo.read(_db, "UnitsAndActivities");
        if (! _infoUnitsAndActivities.equals(_existingUnitsAndActivities)) {
          return new RoomOpenHelper.ValidationResult(false, "UnitsAndActivities(com.example.falconbricks.Database.Table.UnitsAndActivities).\n"
                  + " Expected:\n" + _infoUnitsAndActivities + "\n"
                  + " Found:\n" + _existingUnitsAndActivities);
        }
        final HashMap<String, TableInfo.Column> _columnsTblBlockMaster = new HashMap<String, TableInfo.Column>(2);
        _columnsTblBlockMaster.put("fld_block_table_id", new TableInfo.Column("fld_block_table_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblBlockMaster.put("fld_block_name", new TableInfo.Column("fld_block_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblBlockMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblBlockMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblBlockMaster = new TableInfo("tbl_block_master", _columnsTblBlockMaster, _foreignKeysTblBlockMaster, _indicesTblBlockMaster);
        final TableInfo _existingTblBlockMaster = TableInfo.read(_db, "tbl_block_master");
        if (! _infoTblBlockMaster.equals(_existingTblBlockMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_block_master(com.example.falconbricks.Database.Table.TableBlockMaster).\n"
                  + " Expected:\n" + _infoTblBlockMaster + "\n"
                  + " Found:\n" + _existingTblBlockMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsTblUnitsMaster = new HashMap<String, TableInfo.Column>(10);
        _columnsTblUnitsMaster.put("fld_unit_id", new TableInfo.Column("fld_unit_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_block_table_id", new TableInfo.Column("fld_block_table_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_apt", new TableInfo.Column("fld_apt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_block_id", new TableInfo.Column("fld_block_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_block_name", new TableInfo.Column("fld_block_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_floor", new TableInfo.Column("fld_floor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_id", new TableInfo.Column("fld_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_property_id", new TableInfo.Column("fld_property_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_title", new TableInfo.Column("fld_title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUnitsMaster.put("fld_unit_type", new TableInfo.Column("fld_unit_type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblUnitsMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblUnitsMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblUnitsMaster = new TableInfo("tbl_units_master", _columnsTblUnitsMaster, _foreignKeysTblUnitsMaster, _indicesTblUnitsMaster);
        final TableInfo _existingTblUnitsMaster = TableInfo.read(_db, "tbl_units_master");
        if (! _infoTblUnitsMaster.equals(_existingTblUnitsMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_units_master(com.example.falconbricks.Database.Table.TableUnitsMaster).\n"
                  + " Expected:\n" + _infoTblUnitsMaster + "\n"
                  + " Found:\n" + _existingTblUnitsMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsTblActivity = new HashMap<String, TableInfo.Column>(10);
        _columnsTblActivity.put("fld_activity_id", new TableInfo.Column("fld_activity_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_unit_id_by_unit_table", new TableInfo.Column("fld_unit_id_by_unit_table", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_block_table_id_from_block_table", new TableInfo.Column("fld_block_table_id_from_block_table", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_activity_name", new TableInfo.Column("fld_activity_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_activity_status", new TableInfo.Column("fld_activity_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_current_user_name", new TableInfo.Column("fld_current_user_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_step_name", new TableInfo.Column("fld_step_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_progress", new TableInfo.Column("fld_progress", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_wf", new TableInfo.Column("fld_wf", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblActivity.put("fld_unit_title", new TableInfo.Column("fld_unit_title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblActivity = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblActivity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblActivity = new TableInfo("tbl_activity", _columnsTblActivity, _foreignKeysTblActivity, _indicesTblActivity);
        final TableInfo _existingTblActivity = TableInfo.read(_db, "tbl_activity");
        if (! _infoTblActivity.equals(_existingTblActivity)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_activity(com.example.falconbricks.Database.Table.TableActivities).\n"
                  + " Expected:\n" + _infoTblActivity + "\n"
                  + " Found:\n" + _existingTblActivity);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "42b8719c16dc814f159b2863ec93bd3c", "b6a00dada9a06879250e57216a1ce55d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "UnitsAndActivities","tbl_block_master","tbl_units_master","tbl_activity");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `UnitsAndActivities`");
      _db.execSQL("DELETE FROM `tbl_block_master`");
      _db.execSQL("DELETE FROM `tbl_units_master`");
      _db.execSQL("DELETE FROM `tbl_activity`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public BlockDao blockDao() {
    if (_blockDao != null) {
      return _blockDao;
    } else {
      synchronized(this) {
        if(_blockDao == null) {
          _blockDao = new BlockDao_Impl(this);
        }
        return _blockDao;
      }
    }
  }

  @Override
  public UnitsDao unitsDao() {
    if (_unitsDao != null) {
      return _unitsDao;
    } else {
      synchronized(this) {
        if(_unitsDao == null) {
          _unitsDao = new UnitsDao_Impl(this);
        }
        return _unitsDao;
      }
    }
  }

  @Override
  public ActivitiesDao activitiesDao() {
    if (_activitiesDao != null) {
      return _activitiesDao;
    } else {
      synchronized(this) {
        if(_activitiesDao == null) {
          _activitiesDao = new ActivitiesDao_Impl(this);
        }
        return _activitiesDao;
      }
    }
  }
}
