package Repository;

import Model.Diary;

import java.util.ArrayList;
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
        }
        return null;
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
    public void deleteDiary(Diary diary) {
        for (Diary diary1 : diaries) {
            if (diary.equals(diary1)) diaries.remove(diary);
            break;
        }
    }
}
