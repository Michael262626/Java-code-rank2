package Repository;

import Model.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findAll();

    boolean findByUsername(String username);

    Entry findById(int id);
    long countEntry();
    void deleteUsername(String username);
    void deleteEntry(Entry entry);
}
