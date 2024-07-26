package com.sangil_market.virtual.controllers;

import com.sangil_market.virtual.domain.dto.AssessmentDto;
import com.sangil_market.virtual.domain.dto.UserDto;
import com.sangil_market.virtual.domain.useCase.IAssessmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/assessment")
public class AssessmentController {

    private final IAssessmentUseCase iAssessmentUseCase;

    @GetMapping()
    public ResponseEntity<List<AssessmentDto>> getAll(){
        return ResponseEntity.ok(iAssessmentUseCase.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssessmentDto> getAssessmentById(@PathVariable Long id){
        return ResponseEntity.of(iAssessmentUseCase.getAssessmentById(id));
    }

    @GetMapping(path = "/{punctuation}")
    public ResponseEntity<AssessmentDto> getAssessmentByPunctuation(@PathVariable Integer punctuation){
        return ResponseEntity.of(iAssessmentUseCase.getAssessmentByPunctuation(punctuation));
    }

    @PostMapping()
    public ResponseEntity<AssessmentDto> save(@RequestBody AssessmentDto newAssessmentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iAssessmentUseCase.save(newAssessmentDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AssessmentDto> update(@PathVariable Long id, @RequestBody AssessmentDto updateAssessmentDto){
        if (updateAssessmentDto.getId() == null || !updateAssessmentDto.getId().equals(id)){
            return ResponseEntity.badRequest().build();
        }
        return iAssessmentUseCase.update(updateAssessmentDto).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(this.iAssessmentUseCase.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
