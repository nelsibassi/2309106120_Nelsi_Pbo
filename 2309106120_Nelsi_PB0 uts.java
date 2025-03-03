import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Nama Item: " + name + ", Jumlah: " + quantity + ", Harga: " + price);
    }
}

class Inventory {
    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item " + item.getName() + " berhasil ditambahkan.");
    }

    public void removeItem(String name) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(name)) {
                items.remove(i);
                System.out.println("Item " + name + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Item " + name + " tidak ditemukan.");
    }

    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Inventaris kosong.");
        } else {
            System.out.println("Daftar Item:");
            for (Item item : items) {
                item.displayInfo();
            }
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n=== Sistem Manajemen Inventaris ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Tampilkan Semua Item");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan jumlah item: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Masukkan harga item: ");
                    double price = scanner.nextDouble();
                    Item newItem = new Item(name, quantity, price);
                    inventory.addItem(newItem);
                    break;

                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String itemName = scanner.nextLine();
                    inventory.removeItem(itemName);
                    break;

                case 3:
                    inventory.displayItems();
                    break;

                case 4:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        } while (choice != 4);

        scanner.close();
    }
}