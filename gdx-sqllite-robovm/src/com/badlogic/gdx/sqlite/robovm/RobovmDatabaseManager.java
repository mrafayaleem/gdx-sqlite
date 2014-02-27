package com.badlogic.gdx.sqlite.robovm;

import com.badlogic.gdx.sql.Database;
import com.badlogic.gdx.sql.DatabaseManager;


/**
 * 
 * @author truongps
 * 
 */
public class RobovmDatabaseManager implements DatabaseManager {

	@Override
	public Database getNewDatabase(String dbName, int dbVersion,
			String dbOnCreateQuery, String dbOnUpgradeQuery) {
		return new RobovmDatabase(dbName, dbVersion, dbOnCreateQuery,
				dbOnUpgradeQuery);
	}
}
