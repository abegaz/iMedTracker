package imedtracker.csci3300.csci.mccb.ung.edu.imedtracker;

public class UserModel {

    private static String firstName;
    private static String lastName;
    private String password;
    private String email;
    private int userId;

    private String oldPassword;
    private String newPassword;

    public static String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public static String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getOldPassword() {

        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {

        this.oldPassword = oldPassword;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public UserModel() {

    }

    public UserModel(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userId=" + userId +
                '}';
    }
}


