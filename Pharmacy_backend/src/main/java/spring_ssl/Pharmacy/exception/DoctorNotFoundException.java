package spring_ssl.Pharmacy.exception;


public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(int id) {
        super("Could not find doctor " + id);
    }

}
