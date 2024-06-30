package br.com.sabrinamariha.med.voll.controller;


import br.com.sabrinamariha.med.voll.paciente.DadosCadastroPaciente;
import br.com.sabrinamariha.med.voll.paciente.Paciente;
import br.com.sabrinamariha.med.voll.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
}