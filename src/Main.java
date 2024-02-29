public class Student extends User {
    private static final String STUDENT_AWALAN= "20";
    private static final int STUDENT_IDENTIFIKASI_PANJANG= 15;

    public Student(String identifier) {
        super(identifier);
    }

    @Override
    public boolean authenticate() {
        return getIdentifier().startsWith(STUDENT_AWALAN) && getIdentifier().length() == STUDENT_IDENTIFIKASI_PANJANG;
    }
}

class Admin extends User {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adm1n";

    public Admin(String identifier, String password) {
        super(identifier);
        // Admin authentication is checked during the login process,
        // so we assume it's correct here to prevent storing the password.
        this.password = password;
    }

    private final String password;

    @Override
    public boolean authenticate() {
        return getIdentifier().equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }
}