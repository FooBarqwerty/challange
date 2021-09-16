package nl.hhs.challange;


import nl.hhs.challange.entety.Database;

public class App {

    public static void main( String[] args ) {
        try { Database.getInstance( args[0], Integer.parseInt( args[1] ), args[2], args[3] ); }
        catch ( NumberFormatException e ) { System.err.println( "invalid port number provided" ); System.exit( 1 );}

    }
}
