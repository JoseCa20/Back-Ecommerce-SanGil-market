package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.domain.dto.OrderItemDto;
import com.sangil_market.virtual.domain.useCase.IOrderItemUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/orderItem")
public class OrderItemController {

    private final IOrderItemUseCase iOrderItemUseCase;

    @GetMapping()
    public ResponseEntity<List<OrderItemDto>> getAll(){
        return ResponseEntity.ok(iOrderItemUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable Long id){
        return ResponseEntity.of(iOrderItemUseCase.getOrderItemById(id));
    }

    @PostMapping()
    public ResponseEntity<OrderItemDto> save(@RequestBody OrderItemDto newOrderItemDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iOrderItemUseCase.save(newOrderItemDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<OrderItemDto> update(@PathVariable Long id, @RequestBody OrderItemDto updateOrderItemDto){
        if (updateOrderItemDto.getId() == null || !updateOrderItemDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iOrderItemUseCase.update(updateOrderItemDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iOrderItemUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
