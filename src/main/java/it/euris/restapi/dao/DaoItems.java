package it.euris.restapi.dao;

import it.euris.restapi.model.Item;
import it.euris.restapi.util.BasicDao;
import it.euris.restapi.util.IMappablePro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DaoItems extends BasicDao implements IDaoItems {

    private static final String SELECT_FROM_ITEMS = "SELECT * FROM items";
    private static final String WHERE_ID = " WHERE id=?";
    private static final String INSERT_ITEM = "INSERT INTO items (name, price) values (?, ?)";
    private static final String DELETE_ITEM = "DELETE FROM ITEMS";
    private static final String EDIT_ITEM = "UPDATE items SET name=?, price=?";

    public DaoItems(
            @Value("${db.address}") String dbAddress,
            @Value("${db.user}") String user,
            @Value("${db.psw}") String password
    ) {
        super(dbAddress, user, password);
    }

    /**
     * This method returns a list containing all the products in the database.
     *
     * @return List <Items> items;
     */
    @Override
    public List<Item> items() {
        List<Item> items = new ArrayList<>();
        List<Map<String, String>> maps = getAll(SELECT_FROM_ITEMS);
        for (Map<String, String> map : maps) {
            items.add(IMappablePro.fromMap(Item.class, map));
        }
        return items;
    }

    /**
     * This method returns an object of type Items which has a precise identification code
     *
     * @param id
     * @return Items item;
     */
    @Override
    public Item item(int id) {
        return IMappablePro.fromMap(Item.class, getOne(SELECT_FROM_ITEMS + WHERE_ID, id));
    }

    /**
     * Returns true if it correctly adds an item otherwise returns false.
     *
     * @param item
     * @return boolean value
     */
    @Override
    public boolean add(Item item) {

        return executeAndIsOk(INSERT_ITEM,
                item.getName(),
                item.getPrice());
    }

    /**
     * Returns true if it correctly deletes an item with a specific identification code, otherwise returns false.
     *
     * @param id
     * @return boolean value
     */
    @Override
    public boolean delete(int id) {
        return executeAndIsOk(DELETE_ITEM + WHERE_ID, id);
    }

    /**
     * Returns true if it correctly edits an item, otherwise returns false.
     *
     * @param item
     * @return boolean value
     */
    @Override
    public boolean edit(Item item) {
        return executeAndIsOk(EDIT_ITEM + WHERE_ID,
                item.getName(),
                item.getPrice(),
                item.getId());
    }
}
