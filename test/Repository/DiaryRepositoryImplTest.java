package Repository;

import Model.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepositoryImplTest {
    private DiaryRepositoryImpl myDiary;
    @BeforeEach
    public void initializer(){
        myDiary = new DiaryRepositoryImpl();
    }
    @Test
    public void testToSaveDiary(){
        Diary  diary1 = new Diary("username", "");
        myDiary.save(diary1);
        assertEquals(1, myDiary.count());
    }
    @Test
    public void testToFindDiary(){
        Diary  diary1 = new Diary("username", "");
        myDiary.save(diary1);
        Diary findDiary = myDiary.findById("username");
        assertEquals("username", myDiary.findById("username").getUsername());
    }
    @Test
    public void testToDeleteUserName(){
        Diary  diary1 = new Diary("username", "");
        myDiary.save(diary1);
        myDiary.deleteUsername("username");
        assertEquals(0, myDiary.count());
    }
    @Test
    public void testToDeleteDiary(){
        Diary  diary1 = new Diary("username", "");
        myDiary.save(diary1);
        myDiary.deleteDiary(diary1);
        assertEquals(0, myDiary.count());
    }



}