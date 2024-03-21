package Services;

import Model.Diary;
import Model.Entry;
import dtos.request.UpdateRequest;

import java.util.List;

public interface EntryServices {
    void createEntry(Entry entry);
    void deleteEntry(Entry entry);

    void findById(String title);
    void save(Entry entry);
    List<Entry> findAll(Entry entry);
    void updateEntry(Entry updateEntryRequest);
}
