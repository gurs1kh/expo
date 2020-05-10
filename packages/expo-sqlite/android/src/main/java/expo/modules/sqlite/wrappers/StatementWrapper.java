package expo.modules.sqlite.wrappers;

public interface StatementWrapper {

  public void bindNull(int i);

  public void bindString(int i, String bindArg);

  public long executeInsert();

  public int executeUpdateDelete();

  public void execute();

  public void close();
}
