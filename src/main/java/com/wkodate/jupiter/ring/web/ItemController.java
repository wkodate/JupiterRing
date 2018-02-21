package com.wkodate.jupiter.ring.web;

import com.wkodate.jupiter.ring.domain.Item;
import com.wkodate.jupiter.ring.domain.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created by wkodate on 2018/02/19.
 */
@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    ItemRepository itemRepository;

    @RequestMapping("/hello")
    String hello(Model model, Locale locale) {
        model.addAttribute("title", messageSource.getMessage("app.title", null, locale));
        model.addAttribute("hello", "Hello World!");
        return "hello";
    }

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
