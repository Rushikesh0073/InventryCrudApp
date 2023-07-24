package DAO;

public class InventoryItems{
    Product p;
    int quntity;

    public InventoryItems(Product p, int quntity) {
        this.p = p;
        this.quntity = quntity;
    }

    public Product getP() {
        return this.p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQuntity() {
        return this.quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public String toString() {
        return "InventoryItem p :" + this.p + " Quntity :"+ this.quntity + " ";
    }
}


