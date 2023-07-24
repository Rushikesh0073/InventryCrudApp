package DAO;

    public class Product {
         int id;
         String name;
        Category c;
        double price;

        int quntity;

        public Product() {
        }

        public Product(int id, String name, Category c, double price, int quntity) {
            this.id = id;
            this.name = name;
            this.c = c;
            this.price = price;
            this.quntity = quntity;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Category getC() {
            return this.c;
        }

        public void setC(Category c) {
            this.c = c;
        }

        public double getPrice() {
            return this.price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuntity() {
            return this.quntity;
        }

        public void setQuntity(int quntity) {
            this.quntity = quntity;
        }

        public String toString() {
            return " Product id=" + this.id + " name=" + this.name + " " + this.c + " price=" + this.price + "  quntity=" + this.quntity + "]";
        }
    }

