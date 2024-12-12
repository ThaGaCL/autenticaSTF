public class OcorrenciaDeCopia {

    private Publicacao publicacaoOriginal;
    private Publicacao publicacaoCopia;

    // Construtor padrão
    public OcorrenciaDeCopia() {}

    // Construtor com parâmetros
    public OcorrenciaDeCopia(Publicacao publicacaoOriginal, Publicacao publicacaoCopia, String descricao) {
        this.setPublicacaoOriginal(publicacaoOriginal);
        this.setPublicacaoCopia(publicacaoCopia);
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

    // Métodos
}
