package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderItemCrudRepository extends JpaRepository<OrderItem, Long> {


}
