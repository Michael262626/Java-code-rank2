package Services;

import Exceptions.*;
import Model.Diary;
import Model.Entry;
import Repository.DiaryRepository;
import Repository.DiaryRepositoryImpl;
import Repository.EntryRepository;
import Repository.EntryRepositoryImpl;
import dtos.request.EntryCreation;
import dtos.request.LogOutRequest;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;

import java.util.ArrayList;
import java.util.List;

public class DiaryServicesImplement implements DiaryServices{

        private final DiaryRepository diaryRepositories = new DiaryRepositoryImpl();
        private final EntryRepository entryRepositories = new EntryRepositoryImpl();
        private final LogOutRequest logOutRequest = new LogOutRequest();
        private final EntryServicesImplement entryServicesImplement = new EntryServicesImplement();

        @Override
        public void register(LoginRequest request) {
            if(isDiaryExisting(request.getUsername()))throw new UserNameExistException("User Name Existed Already");
            Diary diary = new Diary(request.getUsername(),request.getPassword());
            diaryRepositories.save(diary);
        }

        @Override
        public void login(String username, String password) {
            Diary diary  = findDiaryByUsername(username);
            validateUsername(diary);
            validatePassword(password, diary);
            diary.setLocked(false);
        }

     private static void validatePassword(String password, Diary diary) {
            if (diary == null) {
                throw new NullPointerException("Diary object is null");
            }

            if (!diary.getPassword().equals(password)) {
                throw new InvalidPasswordException("Invalid Password");
            }
     }
        private  void validateUsername(Diary diary) {
            if(diary ==null)throw new InvalidUserNameException("InValid UserName Provide A Valid Username");
        }

        private boolean isDiaryExisting(String username){
            for(Diary diary: diaryRepositories.findAll()){
                if(diary.getUsername().equals(username))return true;
            }
            return false;
        }
        @Override
        public long count() {
            return diaryRepositories.count();
        }
        @Override
        public long numberOfEntries() {
            return entryRepositories.findAll().size();
    }
        @Override
        public Diary findDiaryByUsername(String username) {
            return diaryRepositories.findById(username);
        }

    @Override
    public void logout(String username) {
        Diary diary = findDiaryByUsername(username);
        if (diary == null) {
            throw new DiaryNotFoundException("Diary not found for username: " + username);
        }
        validateUsername(diary);
        diary.setLocked(true);
    }

    @Override
    public void updateEntry(UpdateRequest updateEntryRequest) {
        Entry entry = new Entry();
        entry.setId(updateEntryRequest.getId());
        entry.setAuthor(updateEntryRequest.getName());
        entry.setTitle(updateEntryRequest.getTitle());
        entry.setBody(updateEntryRequest.getBody());
        entryServicesImplement.save(entry);
    }

    @Override
        public void addEntry(Diary diary, EntryCreation entryCreation) {
            Entry entry = new Entry();
            entry.setTitle(entryCreation.getTitle());
            entry.setBody(entryCreation.getBody());
            diaryRepositories.findById(diary.getUsername());
            entryRepositories.save(entry);
        }

        @Override
        public void deleteAnEntry(String title) {
            entryRepositories.findAll().removeIf(entry -> entry.getTitle().equals(title));
        }
    }

