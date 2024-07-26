package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.domain.dto.ProductDto;
import com.sangil_market.virtual.domain.useCase.IProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private final IProductUseCase iProductUseCase;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(iProductUseCase.getAll());
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<ProductDto> getProductDtoByName(@PathVariable String name){
        return ResponseEntity.of(iProductUseCase.getProductByName(name));
    }

    @GetMapping(path = "/{price}")
    public ResponseEntity<ProductDto> getProductDtoByPrice(@PathVariable Double price){
        return ResponseEntity.of(iProductUseCase.getProductByPrice(price));
    }

    @PostMapping()
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto newProductDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iProductUseCase.save(newProductDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto updateProductDto){
        if (updateProductDto.getId() == null || !updateProductDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iProductUseCase.update(updateProductDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Boolean> delete(@PathVariable String name){
        return new ResponseEntity<>(this.iProductUseCase.deleteByName(name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
