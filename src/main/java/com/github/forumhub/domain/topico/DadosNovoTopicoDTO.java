package com.github.forumhub.domain.topico;

import com.github.forumhub.domain.usuario.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosNovoTopicoDTO(

        @NotBlank
        String autor,

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        LocalDateTime dataCriacao,

        StatusTopico status,

        @NotBlank
        String curso) {
}
