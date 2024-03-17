package Model;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Diary(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean isLocked() {
        return isLocked;
    }

    public void unLock() {
        isLocked = false;
    }
}
