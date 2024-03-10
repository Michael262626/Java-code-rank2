package eCommerceApp;

public enum Category {
    ELECTRONICS,
    GROCERIES,
    UTENSILS,
    CLOTHING;

    private final String[] category;
    Category(String... category){
        this.category = category;
    }
    public String[] getCategory(){
        return category;
    }
}
