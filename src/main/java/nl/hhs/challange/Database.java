package nl.hhs.challange;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class Database {

	private Database instance;
	private final String serverName;
	private Connection SQLConnection;

	private Database(String serverName, Integer portNumber, String username, String password ) {
		this.serverName = serverName;
		try { SQLConnection = connectToDataBase( portNumber, username, password );
		} catch (SQLException e) { System.err.println("Unable to connect to database"); System.exit(1); }
	}

	public synchronized Database getInstance( String serverName, Integer portNumber, String username, String password ) {
		instance = Objects.isNull(instance) ? new Database( serverName, portNumber, username, password ) : instance;
		return instance;
	}

	public synchronized Database getInstance() {
		if (Objects.nonNull(instance)) return instance;
		throw new RuntimeException("singleton instantiated");
	}

	private Connection connectToDataBase( int portNumber, String username, String password ) throws SQLException {
				 return DriverManager.getConnection( "jdbc:sqlserver://" + this.serverName + ":" + portNumber, username, password);
	}
}
