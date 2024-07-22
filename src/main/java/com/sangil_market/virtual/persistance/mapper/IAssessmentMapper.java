package com.sangil_market.virtual.persistance.mapper;

import com.sangil_market.virtual.domain.dto.AssessmentDto;
import com.sangil_market.virtual.persistance.entity.Assessment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAssessmentMapper {

    AssessmentDto toAssessmentDto(Assessment assessment);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "product", ignore = true)
    Assessment toAssessment(AssessmentDto assessmentDto);

    List<AssessmentDto> toAssessmentDtoList(List<Assessment> assessmentList);
}
