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

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        return ResponseEntity.of(iUserUseCase.getUser(id));
    }

    @GetMapping(path = "/email/{email}")
    public ResponseEntity<UserDto> getUser(@PathVariable String email){
        return ResponseEntity.of(iUserUseCase.getUserByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<UserDto> save(@RequestBody UserDto newUserDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iUserUseCase.save(newUserDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iUserUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
