import java.util.List;
import java.util.ArrayList;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String estado;
    private List<Publicacao> publicacoes;

    // Construtor padrão
    public Usuario() {}

    // Construtor com parâmetros
    public Usuario(Integer id, String nome, String email, String senha, List<Publicacao> publicacoes) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setPublicacoes(publicacoes);
        this.setEstado("nao autenticado");
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        if (publicacoes == null) {
            this.publicacoes = new ArrayList<>();
        } else {
            this.publicacoes = publicacoes;
        }
    }
    
    // Métodos
    public Usuario achouUsuario(String email, String senha) {
        if (this.email.equals(email)) {
            if (this.senha.equals(senha)) {
                return this;
            }
        }
        return null;
    }

    public Publicacao adicionarPublicacao(String titulo, String conteudo, List<String> tags, Plataforma plataforma) {
        Integer size = (this.getPublicacoes() == null) ? 0 : this.getPublicacoes().size();
        Integer id = this.getId() + size;
        String hash = "hash";

        Publicacao novaPublicacao = new Publicacao(id, titulo, conteudo, tags, hash, this, plataforma);
        this.publicacoes.add(novaPublicacao);
        
        return novaPublicacao;
    }

    public void removerPublicacao(Publicacao publicacao) {
        this.publicacoes.remove(publicacao);
    }

    public List<Publicacao> listarPublicacoes() {
        return publicacoes;
    }

    public Publicacao procurarPublicacao(Integer publicacaoID) {
        Publicacao p = null;
        for (Publicacao publicacao : this.getPublicacoes()) {
            p = publicacao.achouPublicacao(publicacaoID, this);
            if (p != null) {
                break;
            }
        }
        return p;
    }

    @Override
    public String toString() {
        return "  \n" +
               "   userId: " + this.id + "\n" +
               "   nome: " + this.nome + "\n" +
               "   email: " + this.email + "\n" +
               "   senha: " + this.senha;
    }
}
