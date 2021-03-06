package it.euris.restapi.model;

import it.euris.restapi.util.IMappablePro;

public class Item implements IMappablePro {
    private int id;
    private String name;
    private String price;

    public Item(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{\"Item\":{"
                + "  \"id\":\"" + id + "\""
                + ", \"name\":\"" + name + "\""
                + ", \"price\":\"" + price + "\""
                + "}}";
    }
}
