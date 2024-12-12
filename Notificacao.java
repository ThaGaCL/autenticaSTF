public class Notificacao {

    private Publicacao publicacaoOriginal;
    private Publicacao publicacaoCopia;
    private Usuario autor;

    // Construtor padrão
    public Notificacao() {}

    // Construtor com argumentos
    public Notificacao(Publicacao publicacaoOriginal, Publicacao publicacaoCopia, Usuario autor) {
        this.setPublicacaoOriginal(publicacaoOriginal);
        this.setPublicacaoCopia(publicacaoCopia);
        this.setAutor(autor);
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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    // Métodos
    @Override
    public String toString() {
        return 
        "== NOTIFICAÇÃO ====================================\n" +
        " Atenção usuário " + this.getAutor().getNome() + "\n" +
        " Foi encontrada uma cópia da publicação '" + this.getPublicacaoOriginal().getTitulo() + "'\n" +
        "===================================================\n";
    }
}
