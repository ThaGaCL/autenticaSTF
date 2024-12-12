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
        this.setAuthor(autor);
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

    public void setAuthor(Usuario autor) {
        this.autor = autor;
    }

    // Métodos
    public void notificarCopia(Publicacao publicacaoOriginal, Publicacao publicacaoCopia, String descricao, Usuario usuario) {
        if (publicacaoOriginal == null) {
            throw new IllegalArgumentException("A publicação original não pode ser nula.");
        }

        if (publicacaoCopia == null) {
            throw new IllegalArgumentException("A cópia da publicação não pode ser nula.");
        }

        if (usuario == null) {
            throw new IllegalArgumentException("O usuário não pode ser nulo.");
        }

        new Notificacao(publicacaoOriginal, publicacaoCopia, autor);
       
        System.out.println("Notificação enviada: " + descricao);
    }
}
