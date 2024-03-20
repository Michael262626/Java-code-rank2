package Repository;

import Exceptions.InvalidUserNameException;
import Model.Diary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private List<Diary> diaries = new ArrayList<>();
    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        return diary;
    }

    @Override
    public List<Diary> findAll() {
        return diaries;
    }

    @Override
    public Diary findById(String username) {
        for(Diary diary : diaries){
            if(diary.getUsername().equals(username)) return diary;
            break;
        }
        throw new InvalidUserNameException("user not found");
    }
    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void deleteUsername(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) diaries.remove(diary);
            break;
        }
    }

    @Override
    public boolean deleteDiary(Diary diary) {
        Iterator<Diary> iterator = diaries.iterator();
        while (iterator.hasNext()) {
            Diary currentDiary = iterator.next();
            if (diary.equals(currentDiary)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
