package Services;

import Exceptions.DiaryNotFoundException;
import Exceptions.InvalidUserNameException;
import Model.Diary;
import Model.Entry;
import Repository.DiaryRepositoryImpl;
import dtos.request.EntryCreation;
import dtos.request.LogOutRequest;
import dtos.request.LoginRequest;
import dtos.request.UpdateRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServicesImplementTest {
    private DiaryServicesImplement diaryServicesImplement;


    @BeforeEach
    public void initializer(){
        diaryServicesImplement = new DiaryServicesImplement();
    }
    @Test
    public void testToLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);
        diaryServicesImplement.login("Michael", "password");
        assertFalse(diaryServicesImplement.findDiaryByUsername(loginRequest.getUsername()).isLocked());
    }
    @Test
    public void testToLoginWithWrongPasswordOrUsernameRegistering(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);
        assertThrows(InvalidUserNameException.class, ()->  diaryServicesImplement.login("username", "password"));
    }

    @Test
    public void testToRegister(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);
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
    public void testToFindDiaryWithIncorrectUsername(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);
        Diary diary = new Diary();
        diary.setUsername(request.getUsername());
        assertThrows(InvalidUserNameException.class, ()-> diaryServicesImplement.findDiaryByUsername("wrongName"));
    }
    @Test
    public void testToLogout(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);
        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUsername("Michael");
        diaryServicesImplement.logout("Michael");
        assertTrue(diaryServicesImplement.findDiaryByUsername(logOutRequest.getUsername()).isLocked());
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

        assertEquals(0, diaryServicesImplement.numberOfEntries());
    }
    }

