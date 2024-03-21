package Services;

import Exceptions.DiaryNotFoundException;
import Exceptions.EntryNotFoundException;
import Exceptions.InvalidPasswordException;
import Exceptions.InvalidUserNameException;
import Model.Diary;
import dtos.request.*;
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
    public  void testLoginWithIncorrectPassword(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);
        assertThrows(InvalidPasswordException.class, ()->  diaryServicesImplement.login("Michael", "wrongPassword"));
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
    public void testToLogOutWithIncorrectPassword(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);
        LogOutRequest logOutRequest = new LogOutRequest();
        logOutRequest.setUsername("Michael");
        assertThrows(InvalidUserNameException.class, ()-> diaryServicesImplement.logout("wrongName"));
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
        diaryServicesImplement.deleteAnEntry(entryCreation.getTitle());

        assertEquals(0, diaryServicesImplement.numberOfEntries());
    }
    @Test
    public void testToDeleteEntryWithWrongTitle(){
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
        assertThrows(EntryNotFoundException.class, ()-> diaryServicesImplement.deleteAnEntry("wrongTitle"));
    }
    @Test
    public void testToUpdateEntry(){
        LoginRequest request = new LoginRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);

        // Add an entry to the diary
        EntryCreation entryCreation = new EntryCreation();
        entryCreation.setTitle("title");
        entryCreation.setBody("body");
        Diary diary = new Diary();
        diary.setUsername(request.getUsername());
        diaryServicesImplement.addEntry(diary, entryCreation);

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setTitle("title");
        updateRequest.setBody("newBody");
        diaryServicesImplement.updateEntry(updateRequest);
        assertEquals(1, diaryServicesImplement.count());
    }
    @Test
    public void testToDeleteDiary(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setPassword(loginRequest.getPassword());
        deleteRequest.setUsername(loginRequest.getUsername());
        diaryServicesImplement.deleteDiary(deleteRequest);
        assertEquals(0, diaryServicesImplement.count());
    }
    @Test
    public void testToDeleteDiaryWithIncorrectUsername(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setPassword(loginRequest.getPassword());
        deleteRequest.setUsername("wrongUsername");
        assertThrows(InvalidUserNameException.class, ()-> diaryServicesImplement.deleteDiary(deleteRequest));
    }
    @Test
    public void testToDeleteDiaryWithIncorrectPassword(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("Michael");
        diaryServicesImplement.register(loginRequest);

        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.setPassword("wrongPassword");
        deleteRequest.setUsername(loginRequest.getUsername());
        assertThrows(InvalidPasswordException.class, ()-> diaryServicesImplement.deleteDiary(deleteRequest));
    }
}

