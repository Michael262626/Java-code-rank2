package Services;

import Model.Diary;
import dtos.request.EntryCreation;
import dtos.request.RegisterRequest;

public interface DiaryServices {
    void register(RegisterRequest request);
    void login(String username, String password);

    long count();

    Diary findDiaryById(String username);

    void addEntry(Diary diary, EntryCreation entryCreation);

    void deleteAEntry(Diary diary, int entryNumber);

}
