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


