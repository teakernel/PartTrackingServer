package com.auto.warehouse.partserver.repository;

import com.auto.warehouse.partserver.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {


}
