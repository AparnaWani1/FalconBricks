package com.example.falconbricks.Database.Table;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UnitsDao_Impl implements UnitsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TableUnitsMaster> __insertionAdapterOfTableUnitsMaster;

  public UnitsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTableUnitsMaster = new EntityInsertionAdapter<TableUnitsMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tbl_units_master` (`fld_unit_id`,`fld_block_table_id`,`fld_apt`,`fld_block_id`,`fld_block_name`,`fld_floor`,`fld_id`,`fld_property_id`,`fld_title`,`fld_unit_type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableUnitsMaster value) {
        stmt.bindLong(1, value.getUnit_id());
        if (value.getFld_block_table_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFld_block_table_id());
        }
        if (value.getFld_apt() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFld_apt());
        }
        if (value.getFld_block_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFld_block_id());
        }
        if (value.getFld_block_name() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFld_block_name());
        }
        if (value.getFld_floor() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFld_floor());
        }
        if (value.getFld_id() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFld_id());
        }
        if (value.getFld_property_id() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFld_property_id());
        }
        if (value.getFld_title() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFld_title());
        }
        if (value.getFld_unit_type() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFld_unit_type());
        }
      }
    };
  }

  @Override
  public void insertUnits(final TableUnitsMaster tableUnitsMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTableUnitsMaster.insert(tableUnitsMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int getUnitsCount() {
    final String _sql = "SELECT COUNT(fld_unit_id) FROM tbl_units_master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<TableUnitsMaster>> getUnits(final String blockId) {
    final String _sql = "SELECT * from tbl_units_master WHERE fld_block_table_id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (blockId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, blockId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_units_master"}, false, new Callable<List<TableUnitsMaster>>() {
      @Override
      public List<TableUnitsMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_id");
          final int _cursorIndexOfFldBlockTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id");
          final int _cursorIndexOfFldApt = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_apt");
          final int _cursorIndexOfFldBlockId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_id");
          final int _cursorIndexOfFldBlockName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_name");
          final int _cursorIndexOfFldFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_floor");
          final int _cursorIndexOfFldId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_id");
          final int _cursorIndexOfFldPropertyId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_property_id");
          final int _cursorIndexOfFldTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_title");
          final int _cursorIndexOfFldUnitType = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_type");
          final List<TableUnitsMaster> _result = new ArrayList<TableUnitsMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TableUnitsMaster _item;
            _item = new TableUnitsMaster();
            final int _tmpUnit_id;
            _tmpUnit_id = _cursor.getInt(_cursorIndexOfUnitId);
            _item.setUnit_id(_tmpUnit_id);
            final String _tmpFld_block_table_id;
            _tmpFld_block_table_id = _cursor.getString(_cursorIndexOfFldBlockTableId);
            _item.setFld_block_table_id(_tmpFld_block_table_id);
            final String _tmpFld_apt;
            _tmpFld_apt = _cursor.getString(_cursorIndexOfFldApt);
            _item.setFld_apt(_tmpFld_apt);
            final String _tmpFld_block_id;
            _tmpFld_block_id = _cursor.getString(_cursorIndexOfFldBlockId);
            _item.setFld_block_id(_tmpFld_block_id);
            final String _tmpFld_block_name;
            _tmpFld_block_name = _cursor.getString(_cursorIndexOfFldBlockName);
            _item.setFld_block_name(_tmpFld_block_name);
            final String _tmpFld_floor;
            _tmpFld_floor = _cursor.getString(_cursorIndexOfFldFloor);
            _item.setFld_floor(_tmpFld_floor);
            final String _tmpFld_id;
            _tmpFld_id = _cursor.getString(_cursorIndexOfFldId);
            _item.setFld_id(_tmpFld_id);
            final String _tmpFld_property_id;
            _tmpFld_property_id = _cursor.getString(_cursorIndexOfFldPropertyId);
            _item.setFld_property_id(_tmpFld_property_id);
            final String _tmpFld_title;
            _tmpFld_title = _cursor.getString(_cursorIndexOfFldTitle);
            _item.setFld_title(_tmpFld_title);
            final String _tmpFld_unit_type;
            _tmpFld_unit_type = _cursor.getString(_cursorIndexOfFldUnitType);
            _item.setFld_unit_type(_tmpFld_unit_type);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<TableUnitsMaster>> searchUnits(final String unitTitle) {
    final String _sql = "SELECT * from tbl_units_master WHERE fld_title LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitTitle == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitTitle);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_units_master"}, false, new Callable<List<TableUnitsMaster>>() {
      @Override
      public List<TableUnitsMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_id");
          final int _cursorIndexOfFldBlockTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id");
          final int _cursorIndexOfFldApt = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_apt");
          final int _cursorIndexOfFldBlockId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_id");
          final int _cursorIndexOfFldBlockName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_name");
          final int _cursorIndexOfFldFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_floor");
          final int _cursorIndexOfFldId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_id");
          final int _cursorIndexOfFldPropertyId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_property_id");
          final int _cursorIndexOfFldTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_title");
          final int _cursorIndexOfFldUnitType = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_type");
          final List<TableUnitsMaster> _result = new ArrayList<TableUnitsMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TableUnitsMaster _item;
            _item = new TableUnitsMaster();
            final int _tmpUnit_id;
            _tmpUnit_id = _cursor.getInt(_cursorIndexOfUnitId);
            _item.setUnit_id(_tmpUnit_id);
            final String _tmpFld_block_table_id;
            _tmpFld_block_table_id = _cursor.getString(_cursorIndexOfFldBlockTableId);
            _item.setFld_block_table_id(_tmpFld_block_table_id);
            final String _tmpFld_apt;
            _tmpFld_apt = _cursor.getString(_cursorIndexOfFldApt);
            _item.setFld_apt(_tmpFld_apt);
            final String _tmpFld_block_id;
            _tmpFld_block_id = _cursor.getString(_cursorIndexOfFldBlockId);
            _item.setFld_block_id(_tmpFld_block_id);
            final String _tmpFld_block_name;
            _tmpFld_block_name = _cursor.getString(_cursorIndexOfFldBlockName);
            _item.setFld_block_name(_tmpFld_block_name);
            final String _tmpFld_floor;
            _tmpFld_floor = _cursor.getString(_cursorIndexOfFldFloor);
            _item.setFld_floor(_tmpFld_floor);
            final String _tmpFld_id;
            _tmpFld_id = _cursor.getString(_cursorIndexOfFldId);
            _item.setFld_id(_tmpFld_id);
            final String _tmpFld_property_id;
            _tmpFld_property_id = _cursor.getString(_cursorIndexOfFldPropertyId);
            _item.setFld_property_id(_tmpFld_property_id);
            final String _tmpFld_title;
            _tmpFld_title = _cursor.getString(_cursorIndexOfFldTitle);
            _item.setFld_title(_tmpFld_title);
            final String _tmpFld_unit_type;
            _tmpFld_unit_type = _cursor.getString(_cursorIndexOfFldUnitType);
            _item.setFld_unit_type(_tmpFld_unit_type);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<UnitsAndActivities>> searchUnitsByAll(final String searchTerm) {
    final String _sql = "SELECT um.* ,ac.* from tbl_units_master as um left join tbl_activity as ac ON um.fld_block_table_id = ac.fld_block_table_id_from_block_table WHERE um.fld_title LIKE '%' || ? || '%' OR ac.fld_activity_status LIKE '%' || ? || '%' OR ac.fld_activity_name LIKE '%' || ? || '%' GROUP BY ac.fld_unit_id_by_unit_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (searchTerm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchTerm);
    }
    _argIndex = 2;
    if (searchTerm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchTerm);
    }
    _argIndex = 3;
    if (searchTerm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchTerm);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_units_master","tbl_activity"}, false, new Callable<List<UnitsAndActivities>>() {
      @Override
      public List<UnitsAndActivities> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFldTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_title");
          final int _cursorIndexOfFldUnitType = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_type");
          final int _cursorIndexOfFldActivityId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_id");
          final int _cursorIndexOfFldUnitIdByUnitTable = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_id_by_unit_table");
          final int _cursorIndexOfFldBlockTableIdFromBlockTable = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id_from_block_table");
          final int _cursorIndexOfFldActivityName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_name");
          final int _cursorIndexOfFldActivityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_status");
          final int _cursorIndexOfFldCurrentUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_current_user_name");
          final int _cursorIndexOfFldStepName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_step_name");
          final int _cursorIndexOfFldProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_progress");
          final int _cursorIndexOfFldWf = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_wf");
          final List<UnitsAndActivities> _result = new ArrayList<UnitsAndActivities>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UnitsAndActivities _item;
            _item = new UnitsAndActivities();
            final String _tmpFld_title;
            _tmpFld_title = _cursor.getString(_cursorIndexOfFldTitle);
            _item.setFld_title(_tmpFld_title);
            _item.fld_unit_type = _cursor.getString(_cursorIndexOfFldUnitType);
            _item.fld_activity_id = _cursor.getString(_cursorIndexOfFldActivityId);
            _item.fld_unit_id_by_unit_table = _cursor.getString(_cursorIndexOfFldUnitIdByUnitTable);
            final String _tmpFld_block_table_id_from_block_table;
            _tmpFld_block_table_id_from_block_table = _cursor.getString(_cursorIndexOfFldBlockTableIdFromBlockTable);
            _item.setFld_block_table_id_from_block_table(_tmpFld_block_table_id_from_block_table);
            final String _tmpFld_activity_name;
            _tmpFld_activity_name = _cursor.getString(_cursorIndexOfFldActivityName);
            _item.setFld_activity_name(_tmpFld_activity_name);
            final String _tmpFld_activity_status;
            _tmpFld_activity_status = _cursor.getString(_cursorIndexOfFldActivityStatus);
            _item.setFld_activity_status(_tmpFld_activity_status);
            final String _tmpFld_current_user_name;
            _tmpFld_current_user_name = _cursor.getString(_cursorIndexOfFldCurrentUserName);
            _item.setFld_current_user_name(_tmpFld_current_user_name);
            final String _tmpFld_step_name;
            _tmpFld_step_name = _cursor.getString(_cursorIndexOfFldStepName);
            _item.setFld_step_name(_tmpFld_step_name);
            final String _tmpFld_progress;
            _tmpFld_progress = _cursor.getString(_cursorIndexOfFldProgress);
            _item.setFld_progress(_tmpFld_progress);
            final String _tmpFld_wf;
            _tmpFld_wf = _cursor.getString(_cursorIndexOfFldWf);
            _item.setFld_wf(_tmpFld_wf);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<UnitsAndActivities>> searchUnitsByBlockId(final String searchTerm,
      final String blockId) {
    final String _sql = "SELECT um.* ,ac.* from tbl_units_master as um left join tbl_activity as ac ON um.fld_block_table_id = ac.fld_block_table_id_from_block_table WHERE ac.fld_block_table_id_from_block_table=? AND (um.fld_title LIKE '%' || ? || '%' OR ac.fld_activity_status LIKE '%' || ? || '%' OR ac.fld_activity_name LIKE '%' || ? || '%') GROUP BY ac.fld_unit_id_by_unit_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (blockId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, blockId);
    }
    _argIndex = 2;
    if (searchTerm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchTerm);
    }
    _argIndex = 3;
    if (searchTerm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchTerm);
    }
    _argIndex = 4;
    if (searchTerm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchTerm);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_units_master","tbl_activity"}, false, new Callable<List<UnitsAndActivities>>() {
      @Override
      public List<UnitsAndActivities> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFldTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_title");
          final int _cursorIndexOfFldUnitType = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_type");
          final int _cursorIndexOfFldActivityId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_id");
          final int _cursorIndexOfFldUnitIdByUnitTable = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_id_by_unit_table");
          final int _cursorIndexOfFldBlockTableIdFromBlockTable = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id_from_block_table");
          final int _cursorIndexOfFldActivityName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_name");
          final int _cursorIndexOfFldActivityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_status");
          final int _cursorIndexOfFldCurrentUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_current_user_name");
          final int _cursorIndexOfFldStepName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_step_name");
          final int _cursorIndexOfFldProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_progress");
          final int _cursorIndexOfFldWf = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_wf");
          final List<UnitsAndActivities> _result = new ArrayList<UnitsAndActivities>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UnitsAndActivities _item;
            _item = new UnitsAndActivities();
            final String _tmpFld_title;
            _tmpFld_title = _cursor.getString(_cursorIndexOfFldTitle);
            _item.setFld_title(_tmpFld_title);
            _item.fld_unit_type = _cursor.getString(_cursorIndexOfFldUnitType);
            _item.fld_activity_id = _cursor.getString(_cursorIndexOfFldActivityId);
            _item.fld_unit_id_by_unit_table = _cursor.getString(_cursorIndexOfFldUnitIdByUnitTable);
            final String _tmpFld_block_table_id_from_block_table;
            _tmpFld_block_table_id_from_block_table = _cursor.getString(_cursorIndexOfFldBlockTableIdFromBlockTable);
            _item.setFld_block_table_id_from_block_table(_tmpFld_block_table_id_from_block_table);
            final String _tmpFld_activity_name;
            _tmpFld_activity_name = _cursor.getString(_cursorIndexOfFldActivityName);
            _item.setFld_activity_name(_tmpFld_activity_name);
            final String _tmpFld_activity_status;
            _tmpFld_activity_status = _cursor.getString(_cursorIndexOfFldActivityStatus);
            _item.setFld_activity_status(_tmpFld_activity_status);
            final String _tmpFld_current_user_name;
            _tmpFld_current_user_name = _cursor.getString(_cursorIndexOfFldCurrentUserName);
            _item.setFld_current_user_name(_tmpFld_current_user_name);
            final String _tmpFld_step_name;
            _tmpFld_step_name = _cursor.getString(_cursorIndexOfFldStepName);
            _item.setFld_step_name(_tmpFld_step_name);
            final String _tmpFld_progress;
            _tmpFld_progress = _cursor.getString(_cursorIndexOfFldProgress);
            _item.setFld_progress(_tmpFld_progress);
            final String _tmpFld_wf;
            _tmpFld_wf = _cursor.getString(_cursorIndexOfFldWf);
            _item.setFld_wf(_tmpFld_wf);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
