import java.time.LocalDateTime;

public class Historico {
    private Publicacao publicacao;
    private String acao;
    private LocalDateTime data;
    private Usuario usuario;

    // Construtor padrão
    public Historico() {}

    // Construtor com argumentos
    public Historico(Publicacao publicacao, String acao, LocalDateTime data, Usuario usuario) {
        this.publicacao = publicacao;
        this.acao = acao;
        this.data = data;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Métodos
}
