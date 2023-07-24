package Bean;

import serviceimplementation.ProductImplementation;

import java.util.Scanner;

public class InventoryManagementSystem {
    public InventoryManagementSystem() {
    }

    public static void main(String[] args) {
        ProductImplementation ilm = new ProductImplementation();
        Scanner sc = new Scanner(System.in);
        System.out.println("...Welcome to Inventory Management System App...");

        char ch;
        do {
            System.out.println("enter the choice");
            System.out.println();
            System.out.println("1: Add product\n2: Remove Product\n3: Update Product\n4: Display Inventory\n5: Display Total Value\n6: Serach Product by product name\n7:Search Product by Category ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ilm.addProduct();
                    break;
                case 2:
                    ilm.removeProduct();
                    break;
                case 3:
                    ilm.updateInventory();
                    break;
                case 4:
                    ilm.displayInventory();
                    break;
                case 5:
                    ilm.disaplayTotalValue();
                    break;
                case 6:
                    ilm.searchName();
                    break;
                case 7:
                    ilm.searchCategory();
                    break;
                default:
                    System.out.println("Invalid choice......");
            }

            System.out.println("Do you want to continue");
            ch = sc.next().charAt(0);
        } while(ch == 'y' || ch == 'Y');

    }
}
