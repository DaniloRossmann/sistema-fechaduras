package com.atividadedw.dw.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atividadedw.dw.model.Fechadura;

public interface FechaduraRepository extends JpaRepository <Fechadura, Long>{

    @Query("SELECT f FROM Fechadura f where f.id > :id")
    public List<Fechadura> findAllMoreThen(@Param("id") Long id);

    public List<Fechadura> findByIdGreaterThan(Long id);
    public List<Fechadura> findByDescricaoIgnoreCase(String descricao);
   
    /*@Query("DELETE f FROM Fechadura f where f.id = :id")
    public List<Fechadura> deleteF(@Param("id") Long id);*/
    //public List<Fechadura> findByNomeIgnoreCase(String nome);
    
}
