package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.UserDto;
import com.sangil_market.virtual.domain.useCase.IUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final IUserUseCase iUserUseCase;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll(){
        return ResponseEntity.ok(iUserUseCase.getAll());
    }

    @GetMapping(path = "/{idCard}")
    public ResponseEntity<UserDto> getUserByIdCard(@PathVariable Long idCard){
        return ResponseEntity.of(iUserUseCase.getUserByIdCard(idCard));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        return ResponseEntity.of(iUserUseCase.getUserByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto newUserDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iUserUseCase.save(newUserDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto updateUserDto){
        if (updateUserDto.getId() == null || !updateUserDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iUserUseCase.update(updateUserDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{idCard}")
    public ResponseEntity<Boolean> delete(@PathVariable Long idCard){
        return new ResponseEntity<>(this.iUserUseCase.delete(idCard) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
