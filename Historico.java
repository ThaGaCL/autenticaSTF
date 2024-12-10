import java.util.Date;

public class Historico {
    private Publicacao publicacao;
    private String acao;
    private Date data;
    private Usuario usuario;

    // Construtor padrão
    public Historico() {
    }

    // Construtor com argumentos
    public Historico(Publicacao publicacao, String acao, Date data, Usuario usuario) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Outros métodos
    public void registrarHistorico(Publicacao publicacao, String acao, Usuario usuario) {
        if (publicacao == null) {
            throw new IllegalArgumentException("A publicação não pode ser nula.");
        }

        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }

        new Historico(publicacao, acao, new Date(), usuario);

    }
}
