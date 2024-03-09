package eCommerceApp;

public class User {
    private final String userName;
    private final String password;
    private final String email;
    private final String homeAddress;
    public User(String userName, String password, String email, String homeAddress){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.homeAddress = homeAddress;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }
}
