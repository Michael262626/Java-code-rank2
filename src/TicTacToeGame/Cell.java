package TicTacToeGame;
    public enum Cell {
        X("X"),
        O("O"),
        EMPTY("   ");
        private final String value;

        Cell (String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }


