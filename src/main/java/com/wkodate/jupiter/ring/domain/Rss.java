package com.wkodate.jupiter.ring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wkodate on 2018/02/23.
 */
@Entity
@Getter
@Setter
public class Rss {

    @Id
    @GeneratedValue
    private Long id;

    private String feedUrl;

    private String title;

    private String siteUrl;

    private String description;

}
