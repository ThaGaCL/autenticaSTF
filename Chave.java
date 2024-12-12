public class Chave {
    
    private Integer id;
    private Publicacao publicacao;

    // Construtor padrão
    public Chave() {}
    
    // Construtor com argumentos
    public Chave(Integer id, Publicacao publicacao) {
        this.setId(id);
        this.setPublicacao(publicacao);
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    // Métodos
}