import java.util.*;
public class Machine extends Product{

    private String energy;
    private Date dateStar;
    private Integer capacity;
    private static final int warranty=18;

    public Machine (String name, String brand, double price, int stock, Date datepruchase, double discount, String size,
                   String typetissue, String typeclothe) {

        super (name, brand, price, stock, datepruchase, discount);
        this.energy=energy;
        this.dateStar=dateStar;
        this.capacity=capacity;
    }
}
