package ru.appline.model;

public class Product {
    private String name;
    private String code;
    private long price;
    private long priceWithWarranty;
    private int quantity = 1;
    private boolean removed = false;


    public Product(String name, String code, long price) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.priceWithWarranty = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPriceWithWarranty() {
        return priceWithWarranty;
    }

    public void setPriceWithWarranty(long priceWithWarranty) {
        this.priceWithWarranty = priceWithWarranty;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", priceWithWarranty=" + priceWithWarranty +
                ", quantity=" + quantity;
    }
}
