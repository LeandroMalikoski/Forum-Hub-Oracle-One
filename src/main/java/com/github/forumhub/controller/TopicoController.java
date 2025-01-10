package com.github.forumhub.controller;

import com.github.forumhub.domain.topico.*;
import com.github.forumhub.domain.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private ServiceTopico serviceTopico;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody @Valid DadosNovoTopicoDTO dados) {
        Topico topico = serviceTopico.criarTopico(dados);
        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListarTopicosDTO>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable pageable) {
        var page = topicoRepository.findAll(pageable).map(DadosListarTopicosDTO::new);
        System.out.println(page);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarUmTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalharTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopicoDTO dados, @PathVariable Long id) {
        try {
            var topico = topicoRepository.getReferenceById(id);
            topico.atualizar(dados);
            return ResponseEntity.ok(new DadosAtualizarTopicoDTO(topico));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Id não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        var topico = topicoRepository.findById(id).orElse(null);
        if(topico==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID não encontrado.");
        }
        else{
            topicoRepository.deleteById(id);
            return ResponseEntity.ok("Topico excluido com sucesso.");
        }

    }
}
