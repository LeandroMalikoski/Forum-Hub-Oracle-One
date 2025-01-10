package com.github.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosListarTopicosDTO(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {
    public DadosListarTopicosDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao());
    }
}
