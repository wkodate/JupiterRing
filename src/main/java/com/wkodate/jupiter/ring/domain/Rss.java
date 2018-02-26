package com.wkodate.jupiter.ring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wkodate on 2018/02/23.
 */
@Entity
@Table(name = "rss")
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

    private Date created;

    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

}
