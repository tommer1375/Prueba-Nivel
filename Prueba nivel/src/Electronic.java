import java.util.*;
class Electronic extends Product{

    private Integer resolution;
    private Integer battery;
    private static final int warranty=9;

    public Electronic (String name, String brand, double price, int stock, Date datepruchase, double discount, int resolution,
                    int battery) {
        super (name, brand, price, stock, datepruchase, discount);
        this.resolution=resolution;
        this.battery=battery;
    }



}
