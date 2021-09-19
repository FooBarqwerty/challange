package nl.hhs.challange.domain.abstraction;

import nl.hhs.challange.commons.validator.routines.PasswordValidator;
import org.apache.commons.validator.routines.EmailValidator;

public interface IUser {

    void setEmail( String email );

    String getEmail();

    void setPassword(String password);

    String getPassword();
}
