package Repository;

import Model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository {
    private final List<Entry>entries = new ArrayList<>();
    private int id;
    @Override
    public Entry save(Entry entry) {
        if(isNewEntry(entry)){
            entry.setId(generateId());
            entries.add(entry);
        }else{
            for(Entry entry1: entries){
                if(entry1.getId() == entry.getId()){
                    entries.remove(entry1);
                    entries.add(entry);
                }

            }
        }

        return entry;
    }

    public int generateId() {
        return ++id;
    }

    private boolean isNewEntry(Entry entry) {
        return entry.getId() == 0 || isEntryPresent(entry);
    }
    private boolean isEntryPresent(Entry entry1) {
        for (Entry entry : entries) {
            if (entry.getId() == entry1.getId()) {
                return false;
            }
        }
        return true;
    }
    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public Entry findByUsername(String username) {
        for(Entry entry : entries){
            if(entry.getAuthor().equals(username)){
                return entry;
            }
        }
        return null;
    }

    @Override
    public Entry findById(int id) {
        for(Entry entry : entries){
            if(entry.getId()==id){
                return entry;
            }
        }
        return null;
    }

    @Override
    public long countEntry() {
        return entries.size();
    }

    @Override
    public void deleteUsername(String username) {
        entries.removeIf(entry -> entry.getAuthor().equals(username));
    }

    @Override
    public void deleteEntry(Entry entry) {
        entries.remove(entry);
        }
    }
