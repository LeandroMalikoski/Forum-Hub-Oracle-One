package com.github.forumhub.domain.topico;

import com.github.forumhub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class ServiceTopico {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public LocalDateTime obterHoraAtual() {
        LocalDateTime dataCriacao = LocalDateTime.from(LocalDateTime.now());
        LocalDateTime dataTruncad = dataCriacao.truncatedTo(ChronoUnit.SECONDS);
        return dataTruncad;
    }

    public Topico criarTopico(DadosNovoTopicoDTO dados) {
        var autor = dados.autor();
        var titulo = dados.titulo();
        var mensagem = dados.mensagem();
        var status = StatusTopico.NAO_RESPONDIDO;
        var dataCriacao = obterHoraAtual();
        var curso = dados.curso();

        if(topicoRepository.existsByTitulo(titulo)){
            throw new RuntimeException("Este tópico já existe");
        }
        if(topicoRepository.existsByMensagem(mensagem)){
            throw new RuntimeException("Esta mensagem ja existe");
        }

        DadosTopicoDTO dto = new DadosTopicoDTO(autor, titulo, mensagem, curso, status, dataCriacao);
        System.out.println(dto);
        Topico topico = new Topico(dto);
        topicoRepository.save(topico);
        return topico;
    }
}
