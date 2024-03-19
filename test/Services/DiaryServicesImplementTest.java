package Services;

import Model.Diary;
import dtos.request.LoginRequest;
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
        LoginRequest request = new LoginRequest();
        request.setUsername("username");
        request.setPassword("password");
        Diary diary = new Diary();
        diary.unLock();
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

}