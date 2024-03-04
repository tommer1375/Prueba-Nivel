import java.util.*;
class Clothes extends Product {
    private String size;
    private String typetissue;
    private String typeclothe;

    public Clothes(String name, String brand, double price, int stock, Date datepurchase, double discount, String size,
                   String typetissue, String typeclothe) {

        super(name, brand, price, stock, datepurchase, discount);
        this.size = size;
        this.typetissue = typetissue;
        this.typeclothe = typeclothe;
    }
}

