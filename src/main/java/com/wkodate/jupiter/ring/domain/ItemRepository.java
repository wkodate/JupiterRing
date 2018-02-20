package com.wkodate.jupiter.ring.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wkodate on 2018/02/20.
 */
public interface ItemRepository extends CrudRepository<Item, Long>{

}
