package com.sangil_market.virtual.domain.repository;

import com.sangil_market.virtual.domain.dto.AssessmentDto;

import java.util.List;
import java.util.Optional;

public interface IAssessmentRepository {

    List<AssessmentDto> getAll();

    Optional<AssessmentDto> getAssessmentByPunctuation(Integer punctuation);

    AssessmentDto save(AssessmentDto newAssessmentDto);

    void delete(Long id);
}
