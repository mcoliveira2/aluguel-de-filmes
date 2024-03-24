package dev.mcoliveira.aluguelfilmes.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {
    ACAO("Ação"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    TERROR("Terror"),
    ROMANCE("Romance"),
    ANIMACAO("Animação"),
    AVENTURA("Aventura"),
    SUSPENSE("Suspense"),
    DOCUMENTARIO("Documentário"),
    OUTRO("Outro");

    private final String descricao;
}