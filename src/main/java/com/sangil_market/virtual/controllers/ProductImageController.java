package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.ProductDto;
import com.sangil_market.virtual.domain.dto.ProductImageDto;
import com.sangil_market.virtual.domain.useCase.IProductImageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/productImage")
public class ProductImageController {

    private final IProductImageUseCase iProductImageUseCase;

    @GetMapping()
    public ResponseEntity<List<ProductImageDto>> getAll(){
        return ResponseEntity.ok(iProductImageUseCase.getAll());
    }

    @GetMapping(path = "/product/{imageUrl}")
    public ResponseEntity<ProductImageDto> getProductDtoByName(@PathVariable String imageUrl){
        return ResponseEntity.of(iProductImageUseCase.getProductImageByUrl(imageUrl));
    }

    @PostMapping()
    public ResponseEntity<ProductImageDto> save(@RequestBody ProductImageDto newProductImageDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iProductImageUseCase.save(newProductImageDto));
    }

    @PutMapping(path = "/product/{id}")
    public ResponseEntity<ProductImageDto> update(@PathVariable Long id, @RequestBody ProductImageDto updateProductImageDto){
        if (updateProductImageDto.getId() == null || !updateProductImageDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iProductImageUseCase.update(updateProductImageDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{imageUrl}")
    public ResponseEntity<Boolean> delete(@PathVariable String imageUrl){
        return new ResponseEntity<>(this.iProductImageUseCase.deleteByImageUrl(imageUrl) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
