package nl.hhs.challange.entety;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Database {

	private static Database instance = null;
	private final String serverName;
	private Connection SQLConnection;

	private Database( String serverName, Integer portNumber, String username, String password ) {
		this.serverName = serverName;
		try { SQLConnection = connectToDataBase( portNumber, username, password );
		} catch ( SQLException e ) { e.printStackTrace(); System.exit( 1 ); }
	}

	public static synchronized Database getInstance( String serverName, Integer portNumber, String username, String password ) {
		instance = Objects.isNull( instance ) ? new Database( serverName, portNumber, username, password ) : instance;
		return instance;
	}

	public static synchronized Database getInstance() {
		if ( Objects.nonNull( instance )) return instance;
		throw new RuntimeException( "singleton not instantiated" );
	}

	private Connection connectToDataBase( int portNumber, String username, String password ) throws SQLException {
			 return DriverManager.getConnection( "jdbc:sqlserver://" + this.serverName + ":" + portNumber, username, password );
	}

	public Boolean executeUpdate( String SQL ) {
		try { SQLConnection.createStatement().executeUpdate( SQL ); }
		catch( SQLException e ) { return false; } return true;
	}

	public ResultSet query( String query ) {
		try { return SQLConnection.createStatement().executeQuery( query ); }
		catch ( SQLException e ) { return null; }
	}
}