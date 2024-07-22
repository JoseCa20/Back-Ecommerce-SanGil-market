package com.sangil_market.virtual.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class AssessmentDto {

    private Long id;

    private Integer punctuation;

    private String comment;

    private LocalDateTime date;

}
