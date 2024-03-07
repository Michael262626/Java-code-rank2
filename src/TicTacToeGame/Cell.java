package TicTacToeGame;
    public enum Cell {
        X('X'),
        O('O'),
        EMPTY('-');
        private final char value;

        Cell (char value){
            this.value = value;
        }
        public char getValue() {
            return value;
        }
    }


