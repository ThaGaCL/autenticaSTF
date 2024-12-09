import java.util.List;

public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private List<Publicacao> publicacoes;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String setEmail() {
        return email;
    }

    public void getEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos
    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.add(publicacao);
    }

    public void removerPublicacao(Publicacao publicacao) {
        publicacoes.remove(publicacao);
    }

    public List<Publicacao> listarPublicacoes() {
        return publicacoes;
    }

}
