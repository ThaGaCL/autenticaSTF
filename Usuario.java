import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String estado;
    private List<Publicacao> publicacoes;

    public Usuario(Integer id, String nome, String email, String senha, List<Publicacao> publicacoes) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.publicacoes = new ArrayList<>();
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
    
    // Métodos
    public Usuario procuraUsuario(String email, String senha) {
        if (this.email.equals(email)) {
            if (this.senha.equals(senha)) {
                return this;
            }
        }
        return null;
    }

    public Publicacao adicionarPublicacao(String titulo, String conteudo, List<String> tags, String categoria, Plataforma plataforma) {
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

    @Override
    public String toString() {
        return "  userId: " + this.id + "\n" +
               "  nome: " + this.nome + "\n" +
               "  email: " + this.email + "\n" +
               "  senha: " + this.senha;
    }

}
