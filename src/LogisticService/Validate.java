package LogisticService;

public class Validate {
        static int validate(int number){
            if(number <= 0)  throw new InvalidNumberError("Error: number is low");
            else if(number < 50) return number * 160 + 5000;
            else if (number < 60) return number * 200 + 5000;
            else if(number < 70) return number * 250 + 5000;
            else return number * 500 + 5000;
        }
    }

