package Services;

import Exceptions.InvalidPasswordException;
import Exceptions.InvalidUserNameException;
import Exceptions.UserNameExistException;
import Model.Diary;
import Model.Entry;
import Repository.DiaryRepository;
import Repository.DiaryRepositoryImpl;
import Repository.EntryRepository;
import Repository.EntryRepositoryImpl;
import dtos.request.EntryCreation;
import dtos.request.RegisterRequest;

public class DiaryServicesImplement implements DiaryServices{

        private final DiaryRepository diaryRepositories = new DiaryRepositoryImpl();
        private final EntryRepository entryRepositories = new EntryRepositoryImpl();

        @Override
        public void register(RegisterRequest request) {
            if(isDiaryExisting(request.getUsername()))throw new UserNameExistException("User Name Existed Already");
            Diary diary = new Diary(request.getUsername(),request.getPassword());
            diaryRepositories.save(diary);
        }

        @Override
        public void login(String username, String password) {
            Diary diary  = findDiaryById(username);
            validateUsername(diary);
            validatePassword(password, diary);
            diary.unLock();
        }

        private static void validatePassword(String password, Diary diary) {
            if(!diary.getPassword().equals(password))throw new InvalidPasswordException("Invalid Password ");
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
        public Diary findDiaryById(String username) {
            return diaryRepositories.findById(username);
        }

    @Override
    public void logout(String password) {
        Diary diary  = findDiaryById(password);
        validatePassword(password, diary);
        diary.isLocked();
    }

    @Override
        public void addEntry(Diary diary, EntryCreation entryCreation) {
            Entry entry = new Entry();
            entry.setTitle(entryCreation.getTitle());
            entry.setBody(entryCreation.getBody());
            Diary diary1 = diaryRepositories.findById(diary.getUsername());
            diary.createEntry(entryRepositories.save(entry));
        }

        @Override
        public void deleteAEntry(Diary diary, int entryNumber) {
            Diary diary1 = diaryRepositories.findById(diary.getUsername());
            diary1.deleteEntry(entryNumber);
        }
    }

