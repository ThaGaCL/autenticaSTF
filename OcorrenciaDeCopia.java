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
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Métodos
    // Registrar uma cópia
    public void registrarCopia(Publicacao publicacaoOriginal, Publicacao publicacaoCopia, String descricao, Usuario usuario) {
        if (publicacaoOriginal == null) {
            throw new IllegalArgumentException("A publicação original não pode ser nula.");
        }

        if (publicacaoCopia == null) {
            throw new IllegalArgumentException("A cópia da publicação não pode ser nula.");
        }

        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser nula ou vazia.");
        }

        // Definindo os atributos da classe
        this.publicacaoOriginal = publicacaoOriginal;
        this.publicacaoCopia = publicacaoCopia;
        this.descricao = descricao;

        // Aqui você pode adicionar qualquer lógica adicional, como salvar em um banco de dados ou registrar em uma lista
        System.out.println("Cópia registrada: " + descricao);
    }

    // Verificar se existe uma cópia de uma publicação
    public Boolean existeCopia(Publicacao publicacaoOriginal) {
        if (publicacaoOriginal == null) {
            throw new IllegalArgumentException("A publicação original não pode ser nula.");
        }

        // Lógica para verificar se existe uma cópia da publicação
        return this.publicacaoOriginal.equals(publicacaoOriginal) && this.publicacaoCopia != null;
    }

    // Obter a cópia de uma publicação
    public Publicacao getCopia(Publicacao publicacaoOriginal) {
        if (publicacaoOriginal == null) {
            throw new IllegalArgumentException("A publicação original não pode ser nula.");
        }

        if (this.publicacaoOriginal.equals(publicacaoOriginal)) {
            return this.publicacaoCopia;
        }
        return null;
    }
}
