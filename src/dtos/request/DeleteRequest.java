package dtos.request;

public class DeleteRequest {
    private String username;

    public DeleteRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public DeleteRequest(){

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
}
