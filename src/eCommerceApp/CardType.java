package eCommerceApp;

public enum CardType {
    MASTER_CARD("5"+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "),
    VISA_CARD("4"+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "),
    AMERICAN_EXPRESS("37"+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "),
    DISCOVER("6"+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "+" "),
    UNKNOWN;

    private String[] types;
    CardType(String... types){
        this.types = types;
    }
    public String[] getTypes(){
        return types;
    }
}
