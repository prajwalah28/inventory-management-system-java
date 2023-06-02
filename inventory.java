import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private int stock;

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

public class inventory {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add product");
            System.out.println("2. Update product stock");
            System.out.println("3. Remove product");
            System.out.println("4. Check available stock");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProductStock();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    checkAvailableStock();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(name, stock);
        products.add(product);

        System.out.println("Product added successfully!");
    }

    private static void updateProductStock() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.setStock(stock);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Stock updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void removeProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        boolean removed = products.removeIf(product -> product.getName().equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void checkAvailableStock() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Available stock: " + product.getStock());
                return;
            }
        }

        System.out.println("Product not found!");
    }
}
