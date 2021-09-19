package nl.hhs.challange.serviceprovider.database;

import nl.hhs.challange.serviceprovider.abstraction.IDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SQLDatabase implements IDatabase {

	private static SQLDatabase instance = null;
	private final Connection SQLConnection;

	public static SQLDatabase getInstance() {
		synchronized ( instance ) { if ( Objects.nonNull( instance )) return instance; throw new NullPointerException(); }
	}

	public static SQLDatabase getInstance(Integer portNumber, String password ) {
		synchronized ( instance ) {
			try { instance = Objects.isNull(instance) ? new SQLDatabase(portNumber, password) : instance;
				return instance;
			} catch (Exception e) { return null; }
		}
	}

	private SQLDatabase(Integer portNumber, String password ) throws SQLException {
		SQLConnection = connectToDataBase( portNumber, password );
	}

	private Connection connectToDataBase( int portNumber, String password ) throws SQLException {
		return DriverManager.getConnection("jdbc:sqlserver://localhost:" + portNumber + ";databaseName=master;user=sa;password=" + password);
	}

	public Boolean executeUpdate( String SQL ) {
		try { SQLConnection.createStatement().executeUpdate( SQL ); }
		catch( SQLException e ) { e.printStackTrace(); return false; } return true;
	}

	public ResultSet query( String query ) {
		try { return SQLConnection.createStatement().executeQuery( query ); }
		catch ( SQLException e ) { e.printStackTrace(); return null; }
	}
}
