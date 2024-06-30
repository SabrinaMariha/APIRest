package br.com.sabrinamariha.med.voll.controller;

import br.com.sabrinamariha.med.voll.medico.DadosCadastroMedico;
import br.com.sabrinamariha.med.voll.medico.Medico;
import br.com.sabrinamariha.med.voll.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
