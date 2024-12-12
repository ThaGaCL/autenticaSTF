public class OcorrenciaDeCopia {

    private Publicacao publicacaoOriginal;
    private Publicacao publicacaoCopia;
    private String descricao;

    // Construtor padrão
    public OcorrenciaDeCopia() {}

    // Construtor com parâmetros
    public OcorrenciaDeCopia(Publicacao publicacaoOriginal, Publicacao publicacaoCopia, String descricao) {
        this.setPublicacaoOriginal(publicacaoOriginal);
        this.setPublicacaoCopia(publicacaoCopia);
        this.setDescricao(descricao);
    }

    // Getters e Setters
    public Publicacao getPublicacaoOriginal() {
        return publicacaoOriginal;
    }

    public void setPublicacaoOriginal(Publicacao publicacaoOriginal) {
        this.publicacaoOriginal = publicacaoOriginal;
    }

    public Publicacao getPublicacaoCopia() {
        return publicacaoCopia;
    }

    public void setPublicacaoCopia(Publicacao publicacaoCopia) {
        this.publicacaoCopia = publicacaoCopia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Métodos
}
