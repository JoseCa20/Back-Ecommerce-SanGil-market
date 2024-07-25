package com.sangil_market.virtual.persistance.crud;

import com.sangil_market.virtual.persistance.entity.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAssessmentCrudRepository extends JpaRepository<Assessment, Long> {

    Optional<Assessment> findByPunctuation(Integer punctuation);

    Optional<Assessment> findById(Long id);
}
