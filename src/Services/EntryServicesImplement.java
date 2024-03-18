package Services;

import Model.Entry;
import Repository.EntryRepositoryImpl;

public class EntryServicesImplement implements EntryServices{

    private EntryRepositoryImpl entryRepository = new EntryRepositoryImpl();
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
    public long numberOfEntries() {
        return entryRepository.findAll().size();
    }

    @Override
    public void updateEntry() {

    }

    @Override
    public void updateEntry(String title) {

    }


    @Override
    public void findAll() {

    }

    @Override
    public void findById() {

    }
}
