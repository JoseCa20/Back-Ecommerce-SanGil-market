package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.AssessmentDto;
import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.domain.useCase.ICashOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/cashOrder")
public class CashOrderController {

    private final ICashOrderUseCase iCashOrderUseCase;

    @GetMapping()
    public ResponseEntity<List<CashOrderDto>> getAll(){
        return ResponseEntity.ok(iCashOrderUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CashOrderDto> getCashOrderById(@PathVariable Long id){
        return ResponseEntity.of(iCashOrderUseCase.getCashOrderById(id));
    }

    @GetMapping(path = "/{date}")
    public ResponseEntity<CashOrderDto> getCashOrderByDate(@PathVariable LocalDateTime date){
        return ResponseEntity.of(iCashOrderUseCase.getCashOrderByDate(date));
    }

    @PostMapping()
    public ResponseEntity<CashOrderDto> save(@RequestBody CashOrderDto newCashOrderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCashOrderUseCase.save(newCashOrderDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CashOrderDto> update(@PathVariable Long id, @RequestBody CashOrderDto updateCashOrderDto){
        if (updateCashOrderDto.getId() == null || !updateCashOrderDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iCashOrderUseCase.update(updateCashOrderDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iCashOrderUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
