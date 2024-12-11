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

    public Publicacao(Integer id, String titulo, String conteudo, List<String> tags, String hash, Usuario autor, Plataforma plataforma) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setConteudo(conteudo);
        this.setHash(hash);
        this.setAutor(autor);
        this.setPlataforma(plataforma);
        this.setTags(tags);
        this.setDataCriacao(dataCriacao);

        // adicionando histórico de criação da publicacao
        this.historicos = new ArrayList<>();
        Historico historico = new Historico(this, "adicionada publicacao", LocalDateTime.now(), autor);
        this.adicionarHistorico(historico);
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
        }
        else {
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

    // Métodos
    public void adicionarHistorico(Historico historico) {
        this.historicos.add(historico);
    }


}
