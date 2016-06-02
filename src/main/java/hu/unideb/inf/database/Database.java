package hu.unideb.inf.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.dao.WeatherDAOImpl;


/**
 * The class which connect to the database.
 * 
 * @author Tímea Szabó
 *
 */
public abstract class Database {
	
	/**
	 * Needs for logging.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WeatherDAOImpl.class);
	
	/**
	 * The database URL.
	 */
	private static final String DB_URL = "jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g";
	/**
	 * The user name.
	 */
	private static final String USER = "hl_mi3xh1";
	/**
	 * The password.
	 */
	private static final String PASS = "kassai";
	
	/**
	 * Connect to the database.
	 * 
	 * @return the connection
	 * @throws SQLException SQLException
	 */
	public static Connection connect() throws SQLException {
		LOG.info("Connecting to the database.");
		return DriverManager.getConnection(DB_URL,USER,PASS);
	}
	
}
