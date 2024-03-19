package Services;

import Model.Diary;
import dtos.request.EntryCreation;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;

public interface DiaryServices {
    void register(LoginRequest request);
    void login(String username, String password);
    long count();
    Diary findDiaryByUsername(String username);

    void logout(String password);

    void updateEntry(UpdateRequest updateEntryRequest);

    void addEntry(Diary diary, EntryCreation entryCreation);

    void deleteAEntry(Diary diary, int entryNumber);
}
