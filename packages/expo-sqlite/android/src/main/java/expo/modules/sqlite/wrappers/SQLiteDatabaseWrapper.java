package expo.modules.sqlite.wrappers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class SQLiteDatabaseWrapper implements DatabaseWrapper {
  private SQLiteDatabase database;

  public SQLiteDatabaseWrapper(SQLiteDatabase database) {
    this.database = database;
  }

  public static SQLiteDatabaseWrapper openOrCreateDatabase(String path) {
    SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(path, null);
    return new SQLiteDatabaseWrapper(database);
  }

  public SQLiteStatementWrapper compileStatement(String sql) {
    SQLiteStatement statement = database.compileStatement(sql);
    return new SQLiteStatementWrapper(statement);
  }

  public Cursor rawQuery(String sql, String[] bindArgs) {
    return database.rawQuery(sql, bindArgs);
  }

  public void close() {
    database.close();
  }

  public class SQLiteStatementWrapper implements StatementWrapper {
    private SQLiteStatement statement;

    public SQLiteStatementWrapper(SQLiteStatement statement) {
      this.statement = statement;
    }

    public void bindNull(int i) {
      statement.bindNull(i);
    }

    public void bindString(int i, String bindArg) {
      statement.bindString(i, bindArg);
    }

    public long executeInsert() {
      return statement.executeInsert();
    }

    public int executeUpdateDelete() {
      return statement.executeUpdateDelete();
    }

    public void execute() {
      statement.execute();
    }

    public void close() {
      statement.close();
    }
  }
}
