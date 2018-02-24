package com.wkodate.jupiter.ring.web;

import com.wkodate.jupiter.ring.domain.Rss;
import com.wkodate.jupiter.ring.domain.RssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wkodate on 2018/02/24.
 */
@Controller
@RequestMapping("/rsses")
public class RssController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    RssRepository rssRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Rss> getRsses() {
        return rssRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rss getRss(@PathVariable Long id) {
        return rssRepository.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Rss postRss(@RequestBody Rss rss) {
        return rssRepository.save(rss);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRss(@PathVariable Long id) {
        rssRepository.delete(id);
    }

}
