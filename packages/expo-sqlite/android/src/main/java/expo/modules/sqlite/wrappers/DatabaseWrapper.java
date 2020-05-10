package expo.modules.sqlite.wrappers;

import android.database.Cursor;

public interface DatabaseWrapper {
  public StatementWrapper compileStatement(String sql);

  public Cursor rawQuery(String sql, String[] bindArgs);

  public void close();
}
