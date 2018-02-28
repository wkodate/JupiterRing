package com.wkodate.jupiter.ring.web;

import com.wkodate.jupiter.ring.domain.Rss;
import com.wkodate.jupiter.ring.domain.RssRepository;
import com.wkodate.jupiter.ring.service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wkodate on 2018/02/24.
 */
@RestController
@RequestMapping("rss")
public class RssController {

    @Autowired
    RssService rssService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Rss> getRsses() {
        return rssService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Rss getRss(@PathVariable Long id) {
        return rssService.findOne(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Rss postRss(@RequestBody Rss rss) {
        return rssService.save(rss);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Rss putRss(@RequestBody Rss rss) {
        return rssService.save(rss);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRss(@PathVariable Long id) {
        rssService.delete(id);
    }

}
