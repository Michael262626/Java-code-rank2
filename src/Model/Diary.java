package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diary {
    private String username;
    private String password;
    private boolean isLocked = true;
    private List<Entry> entries = new ArrayList<>();

    public Diary() {

    }

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
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Diary diary = (Diary) object;
        return Objects.equals(username, diary.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
    public void deleteEntry(int entryNumber) {
        entries.removeIf(entryId-> entryId.getId() == entryNumber);
    }
    public void createEntry(Entry entry) {
        entries.add(entry);
    }
    @Override
    public String toString() {
        return "Diary with username: " + username;
    }
}
