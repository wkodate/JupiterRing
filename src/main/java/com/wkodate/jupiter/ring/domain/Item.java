package com.wkodate.jupiter.ring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Item.java
 */
@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String url;

    private String title;

    private String description;

    private Date date;

    private String imageUrl;

}
