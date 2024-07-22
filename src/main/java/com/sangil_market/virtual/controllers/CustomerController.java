package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.CustomerDto;
import com.sangil_market.virtual.domain.dto.UserDto;
import com.sangil_market.virtual.domain.useCase.ICustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "customer")
public class CustomerController {

    private final ICustomerUseCase iCustomerUseCase;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.ok(iCustomerUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        return ResponseEntity.of(iCustomerUseCase.getCustomerById(id));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerUseCase.getCustomerByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> save(@RequestBody CustomerDto newCustomerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iCustomerUseCase.save(newCustomerDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iCustomerUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
