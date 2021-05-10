package it.euris.restapi.controller;

import it.euris.restapi.dao.IDaoItems;
import it.euris.restapi.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class controllerItems {

    @Autowired
    IDaoItems dao;

    @GetMapping
    public List<Item> get() {
        return dao.items();
    }

    @GetMapping("/{id}")
    public Item get(@PathVariable int id) {
        return dao.item(id);
    }

    @PostMapping
    public String add(@RequestBody Item item) {
        String message = "";
        if(dao.add(item)) {
            message = "Successfully added";
        }
        return message;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        String message = "";
        if(dao.delete(id)) {
            message = "Correctly deleted";
        }
        return message;
    }

    @PutMapping
    public String update(@RequestBody Item item) {
        String message = "";
        if(dao.edit(item)) {
            message = "Correctly modified";
        }
        return message;
    }
}
