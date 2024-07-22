package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.CompanyDto;
import com.sangil_market.virtual.domain.useCase.ICompanyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/company")
public class CompanyController {

    private final ICompanyUseCase iCompanyUseCase;

    @GetMapping()
    public ResponseEntity<List<CompanyDto>> getAll(){
        return ResponseEntity.ok(iCompanyUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id){
        return ResponseEntity.of(iCompanyUseCase.getCompanyById(id));
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<CompanyDto> getCompanyByName(@PathVariable String username){
        return ResponseEntity.of(iCompanyUseCase.getCompanyByName(username));
    }

    @PostMapping()
    public ResponseEntity<CompanyDto> save(@RequestBody CompanyDto newCompanyDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCompanyUseCase.save(newCompanyDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iCompanyUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
