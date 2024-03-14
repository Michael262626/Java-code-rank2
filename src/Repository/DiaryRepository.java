package Repository;

import Model.Diary;

import java.util.List;

public interface DiaryRepository {
    Diary save(Diary diary);
    List<Diary> findAll();
    Diary findById(String username);
    long count();
    void deleteUsername(String username);
    void deleteDiary(Diary diary);
}
