package Services;

import Model.Diary;
import Model.Entry;
import Repository.DiaryRepositoryImpl;
import dtos.request.EntryCreation;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServicesImplementTest {
    private DiaryServicesImplement diaryServicesImplement;
    private UpdateRequest updateRequest;
    @BeforeEach
    public void initializer(){
        diaryServicesImplement = new DiaryServicesImplement();
    }
    @Test
    public void testToLogin(){
        LoginRequest request = new LoginRequest();
        request.setUsername("username");
        request.setPassword("password");
        Diary diary = new Diary();
        diary.setLocked(false);
        assertFalse(diary.isLocked());
    }
    @Test
    public void testToRegister(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);
        assertEquals(1, diaryServicesImplement.count());
    }
    @Test
    public void testToFindDiaryByUsername(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);
        Diary diary = new Diary();
        diary.setUsername(request.getUsername());
        assertEquals(diary, diaryServicesImplement.findDiaryByUsername("username"));
    }
    @Test
    public void testToLogout(){
        LoginRequest request = new LoginRequest();
        request.setUsername("username");
        request.setPassword("password");
        Diary diary = new Diary();
        diary.setLocked(true);
        assertTrue(diary.isLocked());
    }
    @Test
    public void testToAddEntry(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);
        EntryCreation entryCreation = new EntryCreation();
        entryCreation.setTitle("title");
        entryCreation.setBody("body");
        Diary diary = new Diary();
        diary.setUsername(request.getUsername());
        diaryServicesImplement.addEntry(diary, entryCreation);
        assertEquals(1, diaryServicesImplement.count());
    }
    @Test
    public void testToDeleteEntry(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUsername("username");

        DiaryServicesImplement diaryServicesImplement = new DiaryServicesImplement();
        diaryServicesImplement.register(request);

        EntryCreation entryCreation = new EntryCreation();
        entryCreation.setTitle("title");
        entryCreation.setBody("body");

        Diary diary = new Diary();
        diary.setUsername(request.getUsername());
        diaryServicesImplement.addEntry(diary, entryCreation);
        assertEquals(1, diaryServicesImplement.count());
        diaryServicesImplement.deleteAEntry(entryCreation.getTitle());

        assertEquals(0, diaryServicesImplement.count());
    }
    }

