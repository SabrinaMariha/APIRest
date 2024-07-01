package br.com.sabrinamariha.med.voll.controller;

import br.com.sabrinamariha.med.voll.medico.DadosCadastroMedico;
import br.com.sabrinamariha.med.voll.medico.DadosListagemMedico;
import br.com.sabrinamariha.med.voll.medico.Medico;
import br.com.sabrinamariha.med.voll.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream()
                .map(DadosListagemMedico::new)
                .toList();
        //.map(DadosListagemMedico::new) transforma um Medico em DadosListagemMedico
    }
}
