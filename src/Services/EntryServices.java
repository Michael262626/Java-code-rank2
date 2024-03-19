package Services;

import Model.Diary;
import Model.Entry;

public interface EntryServices {
    void createEntry(Entry entry);
    void deleteEntry(Entry entry);
    void findById(String title);
    long numberOfEntries();
    void findAll();

    void findById();
}
