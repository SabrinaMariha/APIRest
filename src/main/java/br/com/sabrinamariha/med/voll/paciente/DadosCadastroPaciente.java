package br.com.sabrinamariha.med.voll.paciente;

import br.com.sabrinamariha.med.voll.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotNull @Valid
        DadosEndereco endereco
) {
}
