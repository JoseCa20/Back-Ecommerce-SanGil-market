package com.sangil_market.virtual.domain.useCase;

import com.sangil_market.virtual.domain.dto.AssessmentDto;

import java.util.List;
import java.util.Optional;

public interface IAssessmentUseCase {

    List<AssessmentDto> getAll();

    Optional<AssessmentDto> getAssessmentByPunctuation(Integer punctuation);

    Optional<AssessmentDto> getAssessmentById(Long id);

    AssessmentDto save(AssessmentDto newAssessmentDto);

    boolean delete(Long id);
}
