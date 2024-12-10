public class Chave {
    private Long id;
    private Publicacao publicacao;

    // Construtor padrão
    public Chave() {
    }
    
    // Construtor com argumentos
    public Chave(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    // Outros métodos
    public void criarChave(Publicacao publicacao){
        if (publicacao == null) {
            throw new IllegalArgumentException("A publicação não pode ser nula.");
        }
        
        new Chave(publicacao);
    }
}