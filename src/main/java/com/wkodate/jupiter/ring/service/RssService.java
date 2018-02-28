package com.wkodate.jupiter.ring.service;

import com.wkodate.jupiter.ring.domain.Rss;
import com.wkodate.jupiter.ring.domain.RssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wkodate on 2018/02/23.
 */
@Service
public class RssService {

    @Autowired
    RssRepository rssRepository;

    public Iterable<Rss> findAll() {
        return rssRepository.findAll();
    }

    public Rss findOne(Long id) {
        return rssRepository.findOne(id);
    }

    public Rss save(Rss rss) {
        return rssRepository.save(rss);
    }

    public void delete(Long id) {
        rssRepository.delete(id);
    }

}
