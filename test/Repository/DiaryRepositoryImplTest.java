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
    }


}