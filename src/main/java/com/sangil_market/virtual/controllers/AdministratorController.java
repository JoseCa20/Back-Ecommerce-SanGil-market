package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.AdministratorDto;
import com.sangil_market.virtual.domain.useCase.IAdministratorUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user/administrator")
public class AdministratorController {

    private final IAdministratorUseCase iAdministratorUseCase;

    @GetMapping()
    public ResponseEntity<List<AdministratorDto>> getAll(){
        return ResponseEntity.ok(iAdministratorUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AdministratorDto> getAdministratorById(@PathVariable Long id){
        return ResponseEntity.of(iAdministratorUseCase.getAdministratorById(id));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<AdministratorDto> getAdministratorByEmail(@PathVariable String email){
        return ResponseEntity.of(iAdministratorUseCase.getAdministratorByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<AdministratorDto> save(@RequestBody AdministratorDto newAdministratorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iAdministratorUseCase.save(newAdministratorDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iAdministratorUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
