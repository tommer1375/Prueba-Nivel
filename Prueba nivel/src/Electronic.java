import java.util.*;
class Electronic extends Product{

    private Integer resolution;
    private Integer battery;
    private static final int warranty=9;

    public Electronic (String name, String brand, double price, int stock, Date datepurchase, double discount, int resolution,
                    int battery) {
        super (name, brand, price, stock, datepurchase, discount);
        this.resolution=resolution;
        this.battery=battery;
    }



}
