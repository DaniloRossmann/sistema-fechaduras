package com.atividadedw.dw.controllers;

import com.atividadedw.dw.repository.TranseunteRepository;
//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.atividadedw.dw.model.Transeunte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/transeuntes")

public class TranseunteController {

    @Autowired
    private TranseunteRepository transeunteRepository;

    @GetMapping("/{id}")
    public Transeunte transeunte(@PathVariable("id") Long id){
        
       
        Optional<Transeunte> transeunteFind = this.transeunteRepository.findById(id);
        if(transeunteFind.isPresent()){
            return transeunteFind.get();
        }
        
        return null;
        
    }

    @PostMapping("/")
    public Transeunte transeunte(@RequestBody Transeunte transeunte){
        return this.transeunteRepository.save(transeunte);
    }

    @GetMapping("/list")
    public List<Transeunte> lista(){
        return this.transeunteRepository.findAll();
    }


    @GetMapping("/email/{email}")
    public List<Transeunte> listByEmail(@PathVariable("email") String email){
        return this.transeunteRepository.findByEmailIgnoreCase(email);
    }

    @DeleteMapping("/del/{id}")
    public String deleteTranseunte (@PathVariable("id") Long id){
        this.transeunteRepository.deleteById(id);
        return "Transeunte Excluido!";
        
    }
    
}
