# gdx-sqlite

gdx-sqlite is a cross-platform Libgdx extension for SQLite database handling. The extension abstracts databse handling to provide a unified method to handle database transacitons across multiple platforms while also adding SQLite support for desktop version of Libgdx application.

Currently supported platforms:
- Android (Implemented using Android SQLite API)
- Desktop (SQLite JDBC from https://bitbucket.org/xerial/sqlite-jdbc/wiki/Home)

Latest build of this extension can be downloaded from: 

## Extension usage in a Libgdx application:

Note: This setup assumes that you have properly setup your project as follows (or similar to the following):
 - App
 - AppDesktop
 - AppAndroid

#### For App project:
 - Copy gdx-sqlite.jar into your App project libs folder
 - In the Libraries tab of your Java Build Path, add the gdx-sqlite.jar
 - In the Order and Export tab of your Java Build Path, make sure that gdx-sqlite.jar is checked

#### For AppDesktop project:
 - Copy gdx-sqlite-desktop.jar and sqlite-jdbc-3.7.2.jar into your AppDesktop project libs folder
 - In the Libraries tab of your Java Build Path, add the gdx-sqlite-desktop.jar and sqlite-jdbc-3.7.2.jar

#### For AppAndroid project:
 - Copy gdx-sqlite-android.jar into your AppAndroid project libs folder
 - In the Libraries tab of your Java Build Path, add the gdx-sqlite-android.jar
 - In the Order and Export tab of your Java Build Path, make sure that gdx-sqlite-android.jar is checked

## Code Example:
```java
public class DatabaseTest {

	DatabaseHandler dbHandler;

	public static final String TABLE_COMMENTS = "comments";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_COMMENT = "comment";

	private static final String DATABASE_NAME = "comments.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table if not exists " + TABLE_COMMENTS + "(" + COLUMN_ID
		+ " integer primary key autoincrement, " + COLUMN_COMMENT + " text not null);";

	public DatabaseTest () {
		Gdx.app.log("DatabaseTest", "creation started");
		dbHandler = DatabaseHandlerFactory.getNewDatabaseHandler(DATABASE_NAME, DATABASE_VERSION, DATABASE_CREATE, null);

		try {
			dbHandler.setupDatabase();
			dbHandler.openOrCreateDatabase();
			dbHandler.execSQL(DATABASE_CREATE);
			Gdx.app.log("DatabaseTest", "created successfully");
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}

		try {
			dbHandler.execSQL("INSERT INTO comments ('comment') VALUES ('This is a test comment')");
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}

		DatabaseCursor cursor;
		try {
			cursor = dbHandler.rawQuery("SELECT * FROM comments");

		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
		while (cursor.next()) {
			Gdx.app.log("FromDb", String.valueOf(cursor.getString(1)));
		}
		try {
			dbHandler.closeDatabae();
		} catch (SQLiteGdxException e) {
			e.printStackTrace();
		}
		dbHandler = null;
		Gdx.app.log("DatabaseTest", "dispose");
	}
}
```


