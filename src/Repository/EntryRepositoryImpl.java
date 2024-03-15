package Repository;

import Model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();
    @Override
    public Entry save(Entry entry) {
        entries.add(entry);
        return entry;
    }

    public Entry findById(int id) {
        for(Entry entry : entries){
            if(entry.getId() == id){
                return entry;
            }
        }
        return null;
    }

    public void delete(Entry entry1) {
        if(entry1 != null){
            entries.remove(entry1);
        }
    }

    public int countEntry() {
        return entries.size();
    }
}
