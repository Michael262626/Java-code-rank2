package eCommerceApp;

public class Product {
    private final int id;
    private String name;
    private final double price;
    private final String description;
    private Category category;
    public Product(int id, String name, double price, String description, Category category){
        this.id = id;
        this.name= name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    public int getId(){
        return id;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
