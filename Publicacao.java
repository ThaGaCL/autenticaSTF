import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Publicacao {

    private Integer id;
    private String titulo;
    private String conteudo;
    private String hash;
    private LocalDateTime dataCriacao;
    private Usuario autor;
    private List<String> tags;
    private List<Historico> historicos;
    private Plataforma plataforma;
    private Chave chave;
    private String estado;

    // Construtor padrão
    public Publicacao() {}

    // Construtor com parâmetros
    public Publicacao(Integer id, String titulo, String conteudo, List<String> tags, String hash, Usuario autor, Plataforma plataforma) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setConteudo(conteudo);
        this.setHash(hash);
        this.setAutor(autor);
        this.setPlataforma(plataforma);
        this.setTags(tags);
        this.setDataCriacao(LocalDateTime.now());

        // adicionando histórico de criação da publicacao
        this.setHistoricos(null);
        this.adicionarHistorico(new Historico(this, "adicionada publicacao", autor));
        
        this.setChave(null);
        this.setEstado("sem chave");
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        if (tags == null) {
            this.tags = new ArrayList<>();
        } else {
            this.tags = tags;
        }
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Chave getChave() {
        return this.chave;
    }

    public void setChave(Chave chave) {
        this.chave = chave;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Historico> getHistoricos() {
        return this.historicos;
    }
    
    public void setHistoricos(List<Historico> historicos) {
        if (historicos == null) {
            this.historicos = new ArrayList<>();;
        } else {
            this.historicos = historicos;
        }
    }

    // Métodos
    public void adicionarHistorico(Historico historico) {
        this.historicos.add(historico);
    }

    public void adicionarChave(Integer id) {
        Chave novaChave = new Chave(id, this);
        this.setChave(novaChave);
        this.setEstado("chave gerada");
    }

    @Override
    public String toString() {
        return "Publicacao " + this.getId() + "\n" +
               "  titulo: " + this.getTitulo() + "\n" +
               "  conteudo: " + this.getConteudo() + "\n" +
               "  hash: " + this.getHash() + "\n" +
               "  data: " + this.getDataCriacao() + "\n" +
               "  autor: " + this.getAutor() + "\n" +
               "  tags: " + this.getTags() + "\n" +
               "  estado: " + this.getEstado() + "\n" +
               "  historicos: " + this.getHistoricos();
    }
}
