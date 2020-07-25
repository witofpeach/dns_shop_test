package ru.appline.model;

import java.util.LinkedList;

public class ProductList extends LinkedList<Product> {

    public boolean remove(String name) {
        for (Product product : this) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                product.setRemoved(true);
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (Product product : this) {
            if (!product.isRemoved())
                System.out.println(product.toString());
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : this) {
            if (!product.isRemoved())
                totalPrice += product.getQuantity() * product.getPriceWithWarranty();
        }
        return totalPrice;
    }

    public String getFullNameByQuery(String name) {
        for (Product product : this) {
            if (product.getName().toLowerCase().contains(name.toLowerCase()) && !(product.isRemoved())) {
                return product.getName();
            }
        }
        return "";
    }

    public void incrementQuantityByName(String name) {
        for (Product product : this) {
            if (product.getName().toLowerCase().contains(name.toLowerCase()) && !(product.isRemoved())) {
                product.setQuantity(product.getQuantity() + 1);
            }
        }
    }

    public boolean restoreProduct(String name) {
        for (Product product : this) {
            if (product.getName().toLowerCase().contains(name.toLowerCase()) && product.isRemoved()) {
                product.setRemoved(false);
                return true;
            }
        }
        return false;
    }
}
