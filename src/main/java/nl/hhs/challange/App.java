package nl.hhs.challange;


import nl.hhs.challange.serviceprovider.database.SQLDatabase;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main( String[] args ) {
        List<String> argsR = Arrays.asList("8080","pwd12345");
        try { SQLDatabase.getInstance(Integer.parseInt(argsR.get(0)), argsR.get(1)); }
        catch ( NumberFormatException e ) { System.err.println( "invalid port number provided" ); System.exit( 1 );}

    }
}
