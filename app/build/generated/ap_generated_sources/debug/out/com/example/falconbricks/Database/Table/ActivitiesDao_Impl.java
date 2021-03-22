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
public final class ActivitiesDao_Impl implements ActivitiesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TableActivities> __insertionAdapterOfTableActivities;

  public ActivitiesDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTableActivities = new EntityInsertionAdapter<TableActivities>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tbl_activity` (`fld_activity_id`,`fld_unit_id_by_unit_table`,`fld_block_table_id_from_block_table`,`fld_activity_name`,`fld_activity_status`,`fld_current_user_name`,`fld_step_name`,`fld_progress`,`fld_wf`,`fld_unit_title`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableActivities value) {
        stmt.bindLong(1, value.getActivity_id());
        stmt.bindLong(2, value.getUnit_id());
        if (value.getFld_block_table_id() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getFld_block_table_id());
        }
        if (value.getActivity_name() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getActivity_name());
        }
        if (value.getActivity_status() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getActivity_status());
        }
        if (value.getCurrent_user_name() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCurrent_user_name());
        }
        if (value.getStep_name() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStep_name());
        }
        if (value.getProgress() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getProgress());
        }
        if (value.getWf() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getWf());
        }
        if (value.getUnit_title() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUnit_title());
        }
      }
    };
  }

  @Override
  public void insertActivities(final TableActivities tableActivities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTableActivities.insert(tableActivities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<TableActivities>> getActivities(final String unitId) {
    final String _sql = "SELECT * from tbl_activity WHERE fld_unit_id_by_unit_table=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_activity"}, false, new Callable<List<TableActivities>>() {
      @Override
      public List<TableActivities> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfActivityId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_id_by_unit_table");
          final int _cursorIndexOfFldBlockTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id_from_block_table");
          final int _cursorIndexOfActivityName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_name");
          final int _cursorIndexOfActivityStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_activity_status");
          final int _cursorIndexOfCurrentUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_current_user_name");
          final int _cursorIndexOfStepName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_step_name");
          final int _cursorIndexOfProgress = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_progress");
          final int _cursorIndexOfWf = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_wf");
          final int _cursorIndexOfUnitTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_unit_title");
          final List<TableActivities> _result = new ArrayList<TableActivities>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TableActivities _item;
            _item = new TableActivities();
            final int _tmpActivity_id;
            _tmpActivity_id = _cursor.getInt(_cursorIndexOfActivityId);
            _item.setActivity_id(_tmpActivity_id);
            final int _tmpUnit_id;
            _tmpUnit_id = _cursor.getInt(_cursorIndexOfUnitId);
            _item.setUnit_id(_tmpUnit_id);
            final String _tmpFld_block_table_id;
            _tmpFld_block_table_id = _cursor.getString(_cursorIndexOfFldBlockTableId);
            _item.setFld_block_table_id(_tmpFld_block_table_id);
            final String _tmpActivity_name;
            _tmpActivity_name = _cursor.getString(_cursorIndexOfActivityName);
            _item.setActivity_name(_tmpActivity_name);
            final String _tmpActivity_status;
            _tmpActivity_status = _cursor.getString(_cursorIndexOfActivityStatus);
            _item.setActivity_status(_tmpActivity_status);
            final String _tmpCurrent_user_name;
            _tmpCurrent_user_name = _cursor.getString(_cursorIndexOfCurrentUserName);
            _item.setCurrent_user_name(_tmpCurrent_user_name);
            final String _tmpStep_name;
            _tmpStep_name = _cursor.getString(_cursorIndexOfStepName);
            _item.setStep_name(_tmpStep_name);
            final String _tmpProgress;
            _tmpProgress = _cursor.getString(_cursorIndexOfProgress);
            _item.setProgress(_tmpProgress);
            final String _tmpWf;
            _tmpWf = _cursor.getString(_cursorIndexOfWf);
            _item.setWf(_tmpWf);
            final String _tmpUnit_title;
            _tmpUnit_title = _cursor.getString(_cursorIndexOfUnitTitle);
            _item.setUnit_title(_tmpUnit_title);
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
