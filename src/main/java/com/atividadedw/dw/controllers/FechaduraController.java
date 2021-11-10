package com.atividadedw.dw.controllers;
import com.atividadedw.dw.repository.FechaduraRepository;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.atividadedw.dw.model.Fechadura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/fechaduras")

public class FechaduraController {

    //private List<Fechadura> fecs = new ArrayList<>();

    @Autowired
    private FechaduraRepository fechaduraRepository;

    //Busca pelo ID
    @GetMapping("/{id}")
    public Fechadura fec(@PathVariable("id") Long id){
        Optional<Fechadura> fecFind = this.fechaduraRepository.findById(id);
        if(fecFind.isPresent()){
            return fecFind.get();
        }
        
        return null;
        
    }

    //Insere pelo ID
    @PostMapping("/")
    public Fechadura fec(@RequestBody Fechadura fec){
        return this.fechaduraRepository.save(fec);
    }

    //Busca todos
    @GetMapping("/list")
    public List<Fechadura> lista(){
        return this.fechaduraRepository.findAll();
    }

    //Busca o maior que
    @GetMapping("/list/{id}")
    public List<Fechadura> listMoreThen(@PathVariable("id") Long id){
        return this.fechaduraRepository.findByIdGreaterThan(id);
    }

    //Busca pela desricao
    @GetMapping("/descricao/{descricao}")
    public List<Fechadura> listByDescricao(@PathVariable("descricao") String descricao){
        return this.fechaduraRepository.findByDescricaoIgnoreCase(descricao);
    }

    //Deleta pelo ID
    @DeleteMapping("/del/{id}")
    public String deleteFechadura (@PathVariable("id") Long id){
        this.fechaduraRepository.deleteById(id);
        return "Fechadura Excluida!";
        
    }

}