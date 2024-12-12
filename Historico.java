import java.time.LocalDateTime;

public class Historico {
    
    private Publicacao publicacao;
    private Object acao;
    private LocalDateTime data;
    private Usuario usuario;

    // Construtor padrão
    public Historico() {}

    // Construtor com argumentos
    public Historico(Publicacao publicacao, Object acao, Usuario usuario) {
        this.setPublicacao(publicacao);
        this.setAcao(acao);
        this.setData(LocalDateTime.now());
        this.setUsuario(usuario);
    }

    // Getters e Setters
    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Object getAcao() {
        return acao;
    }

    public void setAcao(Object acao) {
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
    @Override
    public String toString() {
        return this.getAcao() + ", ";
    }
}
