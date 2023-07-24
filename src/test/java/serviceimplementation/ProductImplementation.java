package serviceimplementation;

import DAO.Category;
import DAO.InventoryManagement;
import DAO.Product;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


    public class ProductImplementation implements InventoryManagement {
        Product p1 = new Product();
        Category c1 = new Category();
        Scanner sc;
        ArrayList<Product> prod_al;
        HashMap<Integer, ArrayList<Product>> hs;

        public ProductImplementation() {
            this.sc = new Scanner(System.in);
            this.prod_al = new ArrayList();
            this.hs = new HashMap();
        }

        public void addProduct() {
            System.out.println("Enter the total number of product : ");
            int productSize = this.sc.nextInt();

            for(int i = 0; i < productSize; ++i) {
                System.out.println("Enter  product id");
                int prodId = this.sc.nextInt();
                System.out.println("Enter  product name");
                String prodName = this.sc.next();
                System.out.println("Enter  product price");
                double prodPrice = this.sc.nextDouble();
                System.out.println("Enter  product category details below : id and name ");
                System.out.println();
                System.out.println("Enter  product category id");
                int prodCategoryId = this.sc.nextInt();
                System.out.println("Enter  product category name");
                String prodCategoryName = this.sc.next();
                System.out.println("Enter  total quntity");
                int prodQuntity = this.sc.nextInt();
                this.prod_al.add(new Product(prodId, prodName, new Category(prodCategoryId, prodCategoryName), prodPrice, prodQuntity));
                this.hs.put(prodId, this.prod_al);
            }

        }

        public void removeProduct() {
            System.out.println("enter the product id you want to remove");
            int productId = this.sc.nextInt();
            if (this.prod_al.isEmpty()) {
                System.out.println("product not found");
            } else {
                for(int i = 0; i < this.prod_al.size(); ++i) {
                    if (productId == ((Product)this.prod_al.get(i)).getId()) {
                        this.prod_al.remove(i);
                        System.out.println("product sucessfully removed  ");
                    }
                }
            }

        }

        public void updateInventory() {
            char ch;
            do {
                System.out.println("enter the choice");
                System.out.println("1: Update Product price \n2: Update Quntity");
                int choice = this.sc.nextInt();
                System.out.println(" Enter the product Id for  Update : ");
                int productId = this.sc.nextInt();
                int i;
                int updatedPrice;
                label:
                switch (choice) {
                    case 1:
                        if (this.prod_al.isEmpty()) {
                            System.out.println("Product not Found :");
                            break;
                        } else {
                            i = 0;

                            while(true) {
                                if (i >= this.prod_al.size()) {
                                    break label;
                                }

                                if (productId == ((Product)this.prod_al.get(i)).getId()) {
                                    System.out.println("Enter the new Price :");
                                    updatedPrice = this.sc.nextInt();
                                    ((Product)this.prod_al.get(i)).setPrice((double)updatedPrice);
                                }

                                ++i;
                            }
                        }
                    case 2:
                        if (this.prod_al.isEmpty()) {
                            System.out.println("Product Not Found :");
                        } else {
                            for(i = 0; i < this.prod_al.size(); ++i) {
                                if (productId == ((Product)this.prod_al.get(i)).getId()) {
                                    System.out.println("Enter Qty :");
                                    updatedPrice = this.sc.nextInt();
                                    ((Product)this.prod_al.get(i)).setQuntity(updatedPrice);
                                }
                            }
                        }
                }
                System.out.println("Do you want to continue");
                ch = this.sc.next().charAt(0);
            } while(ch =='Y'||ch=='y');
        }
        public void displayInventory() {
            if (this.prod_al.isEmpty()) {
                System.out.println("product not found");
            } else {
                for(int i = 0; i < this.prod_al.size(); ++i) {
                    System.out.println(this.prod_al.get(i));
                }
            }
        }

        public void disaplayTotalValue() {
            HashMap<String, Double> hm = new HashMap();
            Iterator<Product> itr = this.prod_al.iterator();

            while(itr.hasNext()) {
                Product pd = (Product)itr.next();
                double totalvalue = (double)pd.getQuntity() * pd.getPrice();
                if (hm.containsKey(pd.getName())) {
                    double total = (Double)hm.get(pd.getName());
                    totalvalue += total;
                    hm.put(pd.getName(), totalvalue);
                } else {
                    hm.put(pd.getName(), totalvalue);
                }
            }

            Iterator itr1 = hm.entrySet().iterator();

            while(itr1.hasNext()) {
                Map.Entry<String, Double> me = (Map.Entry)itr1.next();
                System.out.println((String)me.getKey() + " " + me.getValue());
            }

        }
        public void searchName() {
            System.out.println("enter the product name you want search");
            String name = this.sc.next();
            if (this.prod_al.isEmpty()) {
                System.out.println("product not found");
            } else {
                for(int i = 0; i < this.prod_al.size(); ++i) {
                    if (name.equalsIgnoreCase(((Product)this.prod_al.get(i)).getName())) {
                        System.out.println("product found");
                        System.out.println(this.prod_al.get(i));
                    }
                }
            }

        }
        public void searchCategory() {
            System.out.println("enter the product category you want search");
            String category = this.sc.next();
            if (this.prod_al.isEmpty()) {
                System.out.println("product not found");
            } else {
                for(int i = 0; i < this.prod_al.size(); ++i) {
                    if (category.equalsIgnoreCase(((Product)this.prod_al.get(i)).getC().getName())) {
                        System.out.println("product found");
                        System.out.println(this.prod_al.get(i));
                    }
                }
            }

        }
    }


