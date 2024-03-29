package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String author;
    public Entry(int id, String title, String body, String author){
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }
    public Entry(){

    }
    @Override
    public String toString() {
        return "Entry{" +
                "id =" + id +
                ", title ='" + title + '\'' +
                ", body ='" + body + '\'' +
                ", localDateTime =" + localDateTime +
                '}';
    }
}
