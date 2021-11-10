package com.atividadedw.dw.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atividadedw.dw.model.Transeunte;

public interface TranseunteRepository extends JpaRepository <Transeunte, Long> {

    @Query("SELECT t FROM Transeunte t where t.id > :id")
    public List<Transeunte> findAllMoreThen(@Param("id") Long id);

    public List<Transeunte> findByEmailIgnoreCase(String email);
    
}
