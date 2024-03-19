package Services;

import Model.Entry;
import Repository.EntryRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class EntryServicesImplement implements EntryServices{

    private EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
    private List<Entry>entries = new ArrayList<>();
    @Override
    public void createEntry(Entry entry) {
       entryRepository.save(entry);
    }

    @Override
    public void deleteEntry(Entry entry) {
        entryRepository.deleteEntry(entry);
    }

    @Override
    public void findById(String title) {
        entryRepository.findByUsername(title);
    }

    @Override
    public void save(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public long numberOfEntries() {
        return entryRepository.findAll().size();
    }
    @Override
    public List<Entry> findAll(Entry entry) {
        return entries;
    }

    @Override
    public void findById() {

    }
}
