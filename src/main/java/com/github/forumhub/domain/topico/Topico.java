package com.github.forumhub.domain.topico;

import com.github.forumhub.domain.resposta.Resposta;
import com.github.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    private String titulo;

    private String mensagem;

    @Column(name = "data")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    private String curso;

    public Topico(DadosNovoTopicoDTO dados) {
        this.autor = dados.autor();
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.status = dados.status();
        this.curso = dados.curso();
    }

    public Topico(String autor, String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, String curso) {
    }

    public Topico(){}

    public Topico(DadosTopicoDTO dto) {
        this.autor = dto.autor();
        this.titulo = dto.titulo();
        this.mensagem = dto.mensagem();
        this.dataCriacao = dto.dataCriacao();
        this.status = (StatusTopico) dto.status();
        this.curso = dto.curso();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setStatus(StatusTopico status) {
        this.status = status;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getCurso() {
        return curso;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getTitulo() {
        return titulo;
    }



    public void setAutor(String autorNome) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Topico{" +
               "id=" + id +
               ", autor=" + autor +
               ", titulo='" + titulo + '\'' +
               ", mensagem='" + mensagem + '\'' +
               ", dataCriacao=" + dataCriacao +
               ", status=" + status +
               ", curso='" + curso + '\'' +
               '}';
    }

    public String getAutor() {
        return autor;
    }

    public void atualizar(DadosAtualizarTopicoDTO dados) {

        if(dados.autor()!=null){
            this.autor=dados.autor();
        }

        if(dados.titulo()!=null){
            this.titulo=dados.titulo();
        }

        if(dados.mensagem()!=null){
            this.mensagem=dados.mensagem();
        }

        if(dados.curso()!=null){
            this.curso=dados.curso();
        }
    }
}
