public class Sessao {

    private Usuario usuario;
    private Integer id;
    private String token;

    // Construtor Padrão
    public Sessao() {}
    
    // Construtor com parâmetros
    public Sessao(Usuario usuario, Integer id, String token) {
        this.usuario = usuario;
        this.id = id;
        this.token = token;
    }

    // Getters e Setters
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario usuarioCorrente() {
        return this.getUsuario();
    }

    // Métodos
}
