package br.com.sabrinamariha.med.voll.controller;

import br.com.sabrinamariha.med.voll.medico.DadosCadastroMedico;
import br.com.sabrinamariha.med.voll.medico.DadosListagemMedico;
import br.com.sabrinamariha.med.voll.medico.Medico;
import br.com.sabrinamariha.med.voll.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListagemMedico> listar(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return repository.findAll(paginacao)
                .map(DadosListagemMedico::new);
              /* anteriormente havia o retorno de uma lista, então usávamos map e to list
              mas agora temos a interface Pageable que já faz a paginação, então não
              precisamos mais do to list, apenas do map porque a sobrecarga do método findAll
              tem um Pageable como parâmetro, então ele já faz a paginação automaticamente
              e suporta o map.
                */

        /*.map(DadosListagemMedico::new) transforma um Medico em DadosListagemMedico
        usar um DTO ao invés da entidade médico torna a aplicação mais rápida e
        evita ataques como Mass Assignment, mas se for necessário ignorar determinados
        atributos da entidade, pode-se usar a anotação @JsonIgnore na classe da entidade
        assim quando ela for serializada, o atributo será ignorado, mas feito isso
        nunca esse atributo será enviado ao JSON */

    }
}
