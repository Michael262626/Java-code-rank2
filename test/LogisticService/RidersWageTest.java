package LogisticService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    class RidersWageTest {
        @Test
        public void testToReturnWage(){
            int number = 80;
            assertEquals(45000, RidersWage.wage(number));
        }
        @Test
        public void testToReturnWage2(){
            int number = 25;
            assertEquals(9000, RidersWage.wage(number));
        }
        @Test
        public void testToThrowExceptionForNumberLessThan0(){
            int number = -1;
            assertThrows(InvalidNumberError.class, ()-> RidersWage.wage(number));


        }


    }