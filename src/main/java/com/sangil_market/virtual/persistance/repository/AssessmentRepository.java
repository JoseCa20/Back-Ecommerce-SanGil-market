package com.sangil_market.virtual.persistance.repository;

import com.sangil_market.virtual.domain.dto.AssessmentDto;
import com.sangil_market.virtual.domain.repository.IAssessmentRepository;
import com.sangil_market.virtual.persistance.crud.IAdministratorCrudRepository;
import com.sangil_market.virtual.persistance.crud.IAssessmentCrudRepository;
import com.sangil_market.virtual.persistance.entity.Assessment;
import com.sangil_market.virtual.persistance.mapper.IAssessmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AssessmentRepository implements IAssessmentRepository {

    private final IAssessmentCrudRepository iAssessmentCrudRepository;

    private final IAssessmentMapper iAssessmentMapper;

    @Override
    public List<AssessmentDto> getAll() {
        return iAssessmentMapper.toAssessmentDtoList(iAssessmentCrudRepository.findAll());
    }

    @Override
    public Optional<AssessmentDto> getAssessmentByPunctuation(Integer punctuation) {
        return iAssessmentCrudRepository.findByPunctuation(punctuation).map(iAssessmentMapper::toAssessmentDto);
    }

    @Override
    public AssessmentDto save(AssessmentDto newAssessmentDto) {
        Assessment assessment = iAssessmentMapper.toAssessment(newAssessmentDto);
        return iAssessmentMapper.toAssessmentDto(iAssessmentCrudRepository.save(assessment));
    }

    @Override
    public void delete(Long id) {
        iAssessmentCrudRepository.deleteById(id);
    }
}
