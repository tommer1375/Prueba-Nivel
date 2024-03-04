import java.util.*;
public class Product {
    private static int contadorCodigo = 1;
    protected Integer code;
    protected String name;
    protected String brand;
    protected double price;
    protected Integer stock;
    protected Date datepurchase;
    protected  double discount;

    public Product ( String name, String brand, double price, int stock, Date datepurchase, double discount) {
        code = contadorCodigo++;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.datepurchase = datepurchase;
        this.stock = stock;

    }
    public int getCode(){

        return code;
    }
    public String getName() {

        return name;
    }

    public double getPrice(){
        return price;
    }
    public int getStock() {
        return stock;
    }

    public Date getDatepurchase() {
        return datepurchase;
    }

    public double getDiscount() {
        return discount;
    }

    public void setStock (int Stock) {
        this.stock = stock;
    }

    public void applyDiscount() {
        double newPrice = price * (discount / 100);
        newPrice -= discount;
    }
    public String toString() {
        return "Código: " + code + ", Nombre: " + name + ", Marca: " + brand + ", Precio: " + price+ " Stock "+stock+ " Fecha compra " +datepurchase+" Descuento "+discount;
    }
}




