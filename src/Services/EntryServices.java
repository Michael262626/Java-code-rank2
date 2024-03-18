package Services;

import Model.Entry;

public interface EntryServices {
    void createEntry(Entry entry);
    void deleteEntry(Entry entry);
    void findById(String title);
    long numberOfEntries();
    void updateEntry();

    void updateEntry(String title);

    void findAll();

    void findById();
}
