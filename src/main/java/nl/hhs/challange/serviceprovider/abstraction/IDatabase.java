package nl.hhs.challange.serviceprovider.abstraction;

import java.sql.ResultSet;

public interface IDatabase {

    Boolean executeUpdate(String SQL);
    ResultSet query(String query );

}