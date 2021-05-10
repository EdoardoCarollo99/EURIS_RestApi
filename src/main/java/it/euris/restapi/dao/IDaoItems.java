package it.euris.restapi.dao;

import it.euris.restapi.model.Item;

import java.util.List;

public interface IDaoItems {

    /**
     * This method returns a list containing all the products in the database.
     * @return List <Items> items;
     */
    public List <Item> items();

    /**
     * This method returns an object of type Items which has a precise identification code
     * @param id
     * @return Items item;
     */
    public Item item(int id);

    /**
     * Returns true if it correctly adds an item otherwise returns false.
     * @param item
     * @return boolean value
     */
    public boolean add(Item item);

    /**
     * Returns true if it correctly deletes an item with a specific identification code, otherwise returns false.
     * @param id
     * @return boolean value
     */
    public boolean delete(int id);

    /**
     * Returns true if it correctly edits an item, otherwise returns false.
     * @param item
     * @return boolean value
     */
    public boolean edit (Item item);
}
