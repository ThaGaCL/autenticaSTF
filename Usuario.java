import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private List<Publicacao> publicacoes;

    public Usuario(Integer id, String nome, String email, String senha, List<Publicacao> publicacoes) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setPublicacoes(publicacoes);
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

    public List<Publicacao> getPublicacoes() {
        return publicacoes;
    }
    
    public void setPublicacoes(List<Publicacao> publicacoes) {
        this.publicacoes = publicacoes;
    }

    // Métodos
    public Usuario procuraUsuario(String email, String senha) {
        if (this.email.equals(email)) {
            if (this.senha.equals(senha)) {
                return this;
            }
        }
        return null;
    }

    public void adicionarPublicacao(Publicacao publicacao) {
        publicacoes.add(publicacao);
    }

    public void removerPublicacao(Publicacao publicacao) {
        publicacoes.remove(publicacao);
    }

    public List<Publicacao> listarPublicacoes() {
        return publicacoes;
    }

    @Override
    public String toString() {
        return "  userId: " + this.id + "\n" +
               "  nome: " + this.nome + "\n" +
               "  email: " + this.email + "\n" +
               "  senha: " + this.senha;
    }

}
