package com.github.forumhub.domain.topico;

public record DadosAtualizarTopicoDTO(
        String autor,
        String titulo,
        String mensagem,
        String curso) {
    public DadosAtualizarTopicoDTO(Topico topico){
        this(topico.getAutor(), topico.getTitulo(), topico.getMensagem(), topico.getCurso());
    }
}