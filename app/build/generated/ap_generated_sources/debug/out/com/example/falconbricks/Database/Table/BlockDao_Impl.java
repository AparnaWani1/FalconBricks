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
public final class BlockDao_Impl implements BlockDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TableBlockMaster> __insertionAdapterOfTableBlockMaster;

  public BlockDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTableBlockMaster = new EntityInsertionAdapter<TableBlockMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tbl_block_master` (`fld_block_table_id`,`fld_block_name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TableBlockMaster value) {
        stmt.bindLong(1, value.getBlock_table_id());
        if (value.getBlock_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBlock_name());
        }
      }
    };
  }

  @Override
  public void insertBlock(final TableBlockMaster tableBlockMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTableBlockMaster.insert(tableBlockMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int getCount() {
    final String _sql = "SELECT COUNT(fld_block_table_id) FROM tbl_block_master";
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
  public LiveData<List<TableBlockMaster>> getBlocks() {
    final String _sql = "SELECT * from tbl_block_master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_block_master"}, false, new Callable<List<TableBlockMaster>>() {
      @Override
      public List<TableBlockMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBlockTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id");
          final int _cursorIndexOfBlockName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_name");
          final List<TableBlockMaster> _result = new ArrayList<TableBlockMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TableBlockMaster _item;
            _item = new TableBlockMaster();
            final int _tmpBlock_table_id;
            _tmpBlock_table_id = _cursor.getInt(_cursorIndexOfBlockTableId);
            _item.setBlock_table_id(_tmpBlock_table_id);
            final String _tmpBlock_name;
            _tmpBlock_name = _cursor.getString(_cursorIndexOfBlockName);
            _item.setBlock_name(_tmpBlock_name);
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
  public LiveData<List<TableBlockMaster>> getBlockNameById(final String blockId) {
    final String _sql = "SELECT * from tbl_block_master where fld_block_table_id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (blockId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, blockId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_block_master"}, false, new Callable<List<TableBlockMaster>>() {
      @Override
      public List<TableBlockMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBlockTableId = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_table_id");
          final int _cursorIndexOfBlockName = CursorUtil.getColumnIndexOrThrow(_cursor, "fld_block_name");
          final List<TableBlockMaster> _result = new ArrayList<TableBlockMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TableBlockMaster _item;
            _item = new TableBlockMaster();
            final int _tmpBlock_table_id;
            _tmpBlock_table_id = _cursor.getInt(_cursorIndexOfBlockTableId);
            _item.setBlock_table_id(_tmpBlock_table_id);
            final String _tmpBlock_name;
            _tmpBlock_name = _cursor.getString(_cursorIndexOfBlockName);
            _item.setBlock_name(_tmpBlock_name);
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
