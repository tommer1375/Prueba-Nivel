import java.text.SimpleDateFormat;
import java.util.*;

public class CorteIrlandes {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        ArrayList<Product> inventory = new ArrayList<Product>();
        menuProgram(inventory);
    }


    public static void menuProgram(ArrayList<Product> inventory) {
        int option;
        do {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Crear un producto");
            System.out.println("2. Listar productos ordenados por precio");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Calcular fecha vencimiento de la garantía");
            System.out.println("5. Aplicar rebajas a productos");
            System.out.println("6. Productos en rebajas");
            System.out.println("7. Consultar stock de un producto");
            System.out.println("8. Aumentar stock de un producto");
            System.out.println("9. Quitar stock de un producto");
            System.out.println("0. Salir");

            System.out.print("Ingrese la opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    createProduct(inventory);
                    break;
                case 2:
                    listProductPrice(inventory);
                    break;
                case 3:
                    removeProduct(inventory);
                    break;
                case 4:
                    reviewDateWarranty(inventory);
                    break;
                case 5:
                    applyDiscount(inventory);
                    break;
                case 6:
                    productSales(inventory);
                    break;
                case 7:
                    reviewStock(inventory);
                    break;
                case 8:
                    upStock(inventory);
                    break;
                case 9:
                    removeStock(inventory);
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (option != 0);
    }

    static void createProduct(ArrayList<Product> inventory) {
        System.out.println("----- Crear Producto -----");
        System.out.print("Ingrese el nombre del producto: ");
        String name =scanner.next();

        System.out.print("Ingrese la marca del producto: ");
        String brand = scanner.next();

        System.out.print("Ingrese el precio del producto: ");
        double price = scanner.nextDouble();

        System.out.print("Ingrese la cantidad de stock del producto: ");
        int stock = scanner.nextInt();

        System.out.print("Ingrese la fecha de compra del producto (formato dd/MM/yyyy): ");
        String datePurchaseStr = scanner.next();
        Date datePurchase = parseDate(datePurchaseStr);

        System.out.print("Ingrese el % de rebaja del producto: ");
        double discount = scanner.nextDouble();
        System.out.print("Seleccione el tipo de producto (1. Ropa, 2. Electrodoméstico, 3. Componente electrónico, 4. Belleza): ");
        int typeProduct = scanner.nextInt();

        switch (typeProduct) {
            case 1:
                createClothe(inventory, name, brand, price, stock, datePurchase, discount);
                break;
            case 2:
                createMachine(inventory, name, brand, price, stock, datePurchase, discount);
                break;
            case 3:
                createElectronic(inventory, name, brand, price, stock, datePurchase, discount);
                break;

            case 4:
                createBeauty(inventory, name, brand, price, stock, datePurchase, discount);
                break;

            default:
                System.out.println("Tipo de producto no válido.");
                break;
        }
    }

    static void createClothe(ArrayList<Product> inventory, String name, String brand, double price, int stock, Date datePurchase, double discount) {
        System.out.print("Ingrese la talla de la ropa: ");
        String size = scanner.next();

        System.out.print("Ingrese el tipo de tejido de la ropa: ");
        String typetissu = scanner.next();

        System.out.print("Ingrese el tipo de prenda de la ropa: ");
        String typeclothe = scanner.next();

        Clothes clothe = new Clothes(name, brand, price, stock, datePurchase, discount, size, typetissu, typeclothe);
        inventory.add(clothe);

        System.out.println("Ropa creada con éxito.");
    }

    static void createMachine(ArrayList<Product> inventory, String name, String brand, double price, int stock, Date datePurchase, double discount) {
        System.out.print("Ingrese el consumo energético del electrodoméstico: ");
        String energy = scanner.next();

        System.out.print("Ingrese la fecha de fabricación del electrodoméstico (formato dd/MM/yyyy): ");
        String dateManufactureStr = scanner.next();
       Date dateManufacture = parseDate(dateManufactureStr);

        System.out.print("Ingrese la capacidad del electrodoméstico: ");
        int capacity = scanner.nextInt();

        Machine machine = new Machine(name, brand, price, stock, datePurchase, discount, energy, dateManufacture, capacity);
        inventory.add(machine);

        System.out.println("Electrodoméstico creado con éxito.");
    }

    static void createElectronic(ArrayList<Product> inventory, String name, String brand, double price, int stock, Date datePurchase, double discount) {
        System.out.print("Ingrese la resolución del componente eléctronico: ");
        int resolution = scanner.nextInt();

        System.out.print("Ingrese la capacidad de la batería: ");
        int battery = scanner.nextInt();

        Electronic electronic = new Electronic(name, brand, price, stock, datePurchase, discount, resolution, battery);
        inventory.add(electronic);

        System.out.println("Componente eléctronico creado con éxito.");
    }

    static void createBeauty(ArrayList<Product> inventory, String name, String brand, double price, int stock, Date datePurchase, double discount) {
        System.out.print("Ingrese si el producto de belleza es Vegano: (Si/No)");
        String vegane = scanner.next();

        System.out.print("Ingrese la estación de uso (Verano, Invierno...) : ");
        String season = scanner.next();

        Beauty beauty = new Beauty(name, brand, price, stock, datePurchase, discount, vegane, season);
        inventory.add(beauty);

        System.out.println("Producto de belleza con éxito.");

    }


    static void listProductPrice(ArrayList<Product> inventory) {

        for (int i = 0; i < inventory.size() - 1; i++) {
            for (int j = 0; j < inventory.size() - 1 - i; j++) {
                if (inventory.get(j).getPrice() > inventory.get(j + 1).getPrice()) {

                    Product temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }

        for (Product products : inventory) {
            System.out.println(products.getCode() + ". " + products.getName() + " - Precio: " + products.getPrice());
        }
    }

    static void removeProduct(ArrayList<Product> inventory) {
        System.out.print("Ingrese el código del producto que desea eliminar: ");
        int codeRemove = scanner.nextInt();

        Product productRemove = null;
        for (Product products : inventory) {
            if (products.getCode() == codeRemove) {
                productRemove = products;
                break;
            }
        }

        if (productRemove != null) {
            inventory.remove(productRemove);
            System.out.println("Producto eliminado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static void reviewDateWarranty(ArrayList<Product> inventory) {
        System.out.println("metodo no creado");
    }

    static void applyDiscount(ArrayList<Product> inventory) {
        System.out.println("metodo no creado");
    }

    static void productSales(ArrayList<Product> inventory) {
        System.out.println("metodo no creado");
    }

    static void reviewStock(ArrayList<Product> inventory) {
        System.out.print("Ingrese el código del producto: ");
        int codeConsult = scanner.nextInt();

        Product newcodeConsult = null;
        for (Product products : inventory) {
            if (products.getCode() == codeConsult) {
                newcodeConsult = products;
                break;
            }
        }

        if (newcodeConsult != null) {
            System.out.println("Stock de " + newcodeConsult.getName() + " es " + newcodeConsult.getStock());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static void upStock(ArrayList<Product> inventory) {
        System.out.print("Ingrese el código del producto: ");
        int codeConsult = scanner.nextInt();
        System.out.print("Ingrese el nuevo stock del producto: ");
        int newstock = scanner.nextInt();

        Product newcodeConsult = null;
        for (Product products : inventory) {
            if (products.getCode() == codeConsult) {
                newcodeConsult = products;
                break;
            }
        }

        if (newcodeConsult != null) {
            newcodeConsult.setStock(newstock);
        System.out.println("Se ha modificar del stock del producto"+newcodeConsult.getName()+" a "+newstock);

    } else {
        System.out.println("Producto no encontrado.");
    }

    }

    static void removeStock(ArrayList<Product> inventory) {
        System.out.println("metodo no creado");
    }


    static Date parseDate(String dateManufactureStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(dateManufactureStr);
        } catch (Exception e) {
            System.out.println("Error al poner la fecha.");
            return new Date();
        }

    }
}








