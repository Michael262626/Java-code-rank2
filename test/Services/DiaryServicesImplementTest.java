package Services;

import Model.Diary;
import dtos.request.RegisterRequest;
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
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");
        Diary diary = new Diary();
        diary.unLock();
        assertFalse(diary.isLocked());
    }
    @Test
    public void testToRegister(){
        RegisterRequest request = new RegisterRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);
        assertEquals(1, diaryServicesImplement.count());
    }
    @Test
    public void testToFindDiaryByUsername(){
        RegisterRequest request = new RegisterRequest();
        request.setPassword("password");
        request.setUsername("username");
        diaryServicesImplement.register(request);
        assertEquals("username", diaryServicesImplement.findDiaryByUsername("username"));
    }

}