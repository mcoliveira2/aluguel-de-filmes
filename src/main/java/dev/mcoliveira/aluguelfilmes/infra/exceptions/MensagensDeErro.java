package dev.mcoliveira.aluguelfilmes.infra.exceptions;

public class MensagensDeErro {

    // Aluguel
    public static final String ERRO_FILME_ID_OBRIGATORIO = "O 'id' do filme é obrigatório.";
    public static final String ERRO_CLINTE_ID_OBRIGATORIO = "O 'id' do cliente é obrigatório.";
    public static final String ERRO_FILME_NAO_ALUGADO = "Este filme não está alugado!";
    public static final String ERRO_FILME_JA_ESTA_ALUGADO = "O filme já está alugado.";
    public static final String ERRO_ALUGUEL_NAO_ENCONTRADO = "Aluguel não encontrado.";

    // Cliente
    public static final String ERRO_NOME_OBRIGATORIO = "O 'nome' do cliente é obrigatório.";
    public static final String ERRO_EMAIL_OBRIGATORIO = "O 'email' do cliente é obrigatório.";
    public static final String ERRO_CLIENTE_EXISTENTE_PARA_O_EMAIL = "Já existe um cliente para este email.";
    public static final String ERRO_DELETAR_CLIENT_COM_FILME_ALUGADOR =
            "O cliente não pode ser deletado, pois possui filme alugado.";
    public static final String ERRO_EMAIL_INVALIDO = "O 'email' do cliente é inválido.";
    public static final String ERRO_CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado.";

    // Filme
    public static final String ERRO_ANO_LANCAMENTO_INVALIDO = "O 'ano de lançamento' do filme deve estar entre %d e %d.";
    public static final String ERRO_TITULO_OBRIGATORIO = "O 'título' do filme é obrigatório.";
    public static final String ERRO_ANO_LANCAMENTO_OBRIGATORIO = "O 'ano de lançamento' do filme é obrigatório.";
    public static final String ERRO_GENERO_OBRIGATORIO = "O 'gênero' do filme é obrigatório.";
    public static final String ERRO_FILME_ALUGADO_NAO_PODE_DELETAR =
            "O filme está atualmente alugado e não pode ser excluído.";
    public static final String ERRO_FILME_EXISTENTE = "Já existe um filme com o mesmo título e ano de lançamento.";
    public static final String ERRO_FILME_NAO_ENCONTRADO = "Filme não encontrado.";
}
