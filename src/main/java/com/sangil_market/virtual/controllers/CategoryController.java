package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.CashOrderDto;
import com.sangil_market.virtual.domain.dto.CategoryDto;
import com.sangil_market.virtual.domain.useCase.ICategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    private final ICategoryUseCase iCategoryUseCase;

    @GetMapping()
    public ResponseEntity<List<CategoryDto>> getAll(){
        return ResponseEntity.ok(iCategoryUseCase.getAll());
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable String name){
        return ResponseEntity.of(iCategoryUseCase.getCategoryByName(name));
    }

    @PostMapping()
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto newCategoryDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCategoryUseCase.save(newCategoryDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto updateCategoryDto){
        if (updateCategoryDto.getId() == null || !updateCategoryDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iCategoryUseCase.update(updateCategoryDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<Boolean> delete(@PathVariable String name){
        return new ResponseEntity<>(this.iCategoryUseCase.delete(name) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
