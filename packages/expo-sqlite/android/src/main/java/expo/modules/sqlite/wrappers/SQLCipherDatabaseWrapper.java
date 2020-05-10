package expo.modules.sqlite.wrappers;

import android.content.Context;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteStatement;

public class SQLCipherDatabaseWrapper implements DatabaseWrapper {
  private SQLiteDatabase database;

  public SQLCipherDatabaseWrapper(SQLiteDatabase database) {
    this.database = database;
  }

  public static void loadLibs(Context context) {
    SQLiteDatabase.loadLibs(context);
  }

  public static SQLCipherDatabaseWrapper openOrCreateDatabase(String path, String key) {
    SQLiteDatabase database = SQLiteDatabase.openOrCreateDatabase(path, key, null);
    return new SQLCipherDatabaseWrapper(database);
  }

  public SQLCipherStatementWrapper compileStatement(String sql) {
    SQLiteStatement statement = database.compileStatement(sql);
    return new SQLCipherStatementWrapper(statement);
  }

  public Cursor rawQuery(String sql, String[] bindArgs) {
    return database.rawQuery(sql, bindArgs);
  }

  public void close() {
    database.close();
  }

  public class SQLCipherStatementWrapper implements StatementWrapper {
    private SQLiteStatement statement;

    public SQLCipherStatementWrapper(SQLiteStatement statement) {
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
