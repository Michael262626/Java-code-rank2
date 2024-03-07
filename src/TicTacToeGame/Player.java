package TicTacToeGame;

public class Player {
        private String name;
        private Cell cell;
        public Player(String name, Cell cell){
            this.name = name;
            this.cell = cell;
        }
        public Cell getCell(){
            return cell;
        }
        public String getName(){
            return name;
        }



}

