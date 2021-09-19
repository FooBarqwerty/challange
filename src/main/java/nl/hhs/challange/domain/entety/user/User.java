package nl.hhs.challange.domain.entety.user;

import nl.hhs.challange.commons.validator.routines.PasswordValidator;
import nl.hhs.challange.domain.abstraction.IUser;
import org.apache.commons.validator.routines.EmailValidator;

public class User implements IUser {

    private String _email;
    private String _password;

    public User( String email, String password ){
        setEmail( email );
        setPassword( password );
    }

    public synchronized void setEmail( String email ) {
        _email = EmailValidator.getInstance().isValid( email ) ? email : _email;
    }

    public String getEmail() {
        return _email;
    }

    public synchronized void setPassword(String password ){
        _password = PasswordValidator.getInstance().isValid( password ) ? password : _password;
    }

    public String getPassword() {
        return _password;
    }
}
