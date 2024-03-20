package dtos.request;

public class LoginRequest {
        private String username;
        private String password;
        private boolean isLocked = true;

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public LoginRequest(String username, String password, boolean isLocked){
            this.username = username;
            this.password = password;
            this.isLocked = isLocked;
        }

    public LoginRequest() {

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
    }

