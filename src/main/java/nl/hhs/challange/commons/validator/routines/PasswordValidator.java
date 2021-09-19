package nl.hhs.challange.commons.validator.routines;

import java.util.Objects;

public class PasswordValidator {

    private static PasswordValidator instance = null;

    public static synchronized PasswordValidator getInstance() {
        instance = Objects.isNull(instance) ? new PasswordValidator() : instance;
        return instance;
    }

    public Boolean isValid( String password ) {
        return password.matches("(?:(?=.{8,2048})(?=.*\\d.*)(?=.*[a-z].*)(?=.*[A-Z].*).*\\W.*)");
    }
}
