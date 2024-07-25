package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.CashOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ICashOrderCrudRepository extends JpaRepository<CashOrder, Long> {

    Optional<CashOrder> getCashOrderById(Long id);

    Optional<CashOrder> findByDate(LocalDateTime date);
}
