package Repository;

import Model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepositoryTest {
    private EntryRepositoryImpl myEntry;
    @BeforeEach
    public void initializer(){
        myEntry = new EntryRepositoryImpl();
    }
    @Test
    public void testToCreateEntry(){
        Entry entry = new Entry(1, "Semicolon", "Coding", "michael" );
        myEntry.save(entry);
        Entry entry1 = myEntry.findById(1);
        assertEquals(1, myEntry.countEntry());
    }
    @Test
    public void testToCreateTwoEntryThenDeleteOneEntry(){
        Entry entry1 = new Entry(1, "Semicolon", "Coding", "michael" );
        Entry entry2 = new Entry(2, "Solo leveling", "Sun jin wo", "michael" );
        myEntry.save(entry1);
        myEntry.save(entry2);
        myEntry.delete(entry1);
        assertEquals(1, myEntry.countEntry());
    }
    @Test
    public void testToFindEntryById(){
        Entry entry = new Entry(1, "Semicolon", "Coding", "michael" );
        myEntry.save(entry);
        Entry entry1 = myEntry.findById(1);
        assertEquals(1,myEntry.findById(1).getId());
    }

}