package com.wkodate.jupiter.ring.web;

import com.wkodate.jupiter.ring.domain.Item;
import com.wkodate.jupiter.ring.domain.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by wkodate on 2018/02/19.
 */
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable Long id) {
        return itemRepository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Item postItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable Long id) {
        itemRepository.delete(id);
    }

}
