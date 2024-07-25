package com.sangil_market.virtual.domain.service;

import com.sangil_market.virtual.domain.dto.AssessmentDto;
import com.sangil_market.virtual.domain.repository.IAssessmentRepository;
import com.sangil_market.virtual.domain.useCase.IAssessmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AssessmentService implements IAssessmentUseCase {

    private final IAssessmentRepository iAssessmentRepository;

    @Override
    public List<AssessmentDto> getAll() {
        return iAssessmentRepository.getAll();
    }

    @Override
    public Optional<AssessmentDto> getAssessmentByPunctuation(Integer punctuation) {
        return iAssessmentRepository.getAssessmentByPunctuation(punctuation);
    }

    @Override
    public Optional<AssessmentDto> getAssessmentById(Long id) {
        return iAssessmentRepository.getAssessmentById(id);
    }

    @Override
    public AssessmentDto save(AssessmentDto newAssessmentDto) {
        return iAssessmentRepository.save(newAssessmentDto);
    }

    @Override
    public boolean delete(Long id) {
        if (iAssessmentRepository.getAssessmentById(id).isEmpty()){
            return false;
        }
        iAssessmentRepository.delete(id);
        return true;
    }
}
