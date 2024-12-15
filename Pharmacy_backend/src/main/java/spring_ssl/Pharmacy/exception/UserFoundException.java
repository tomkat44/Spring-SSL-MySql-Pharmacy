package spring_ssl.Pharmacy.exception;

public class UserFoundException extends RuntimeException {

    public UserFoundException() {
        super("User is exist ");
    }
}
