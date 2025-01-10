package com.github.forumhub.domain.topico;

import com.github.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosTopicoDTO(String autor, String titulo, String mensagem, String curso, Enum<StatusTopico> status,
                             LocalDateTime dataCriacao) {
    public DadosTopicoDTO(Topico topico) {
        this(topico.getAutor(), topico.getTitulo(), topico.getMensagem(), topico.getCurso(), topico.getStatus(), topico.getDataCriacao());
    }
}
