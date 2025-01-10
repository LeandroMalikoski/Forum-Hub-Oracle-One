package com.github.forumhub.domain.topico;

import com.github.forumhub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DadosDetalharTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String autor, StatusTopico status, String curso) {
    public DadosDetalharTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor(), topico.getStatus(), topico.getCurso());
    }
}
