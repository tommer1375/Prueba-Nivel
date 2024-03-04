import java.util.*;
class Beauty extends Product {
        private String vegane;
        private String season;

    public Beauty (String name, String brand, double price, int stock, Date datepurchase, double discount,
                   String vegane, String season) {

        super (name, brand, price, stock, datepurchase, discount);
        this.vegane=vegane;
        this.season=season;

    }

}
