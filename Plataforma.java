import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Plataforma {
    private List<Usuario> usuarios;
    private List<Publicacao> publicacoes;
    private Sessao sessao;
    private Integer proximoId;

    // Construtores
    public Plataforma() { 
        this.usuarios = new ArrayList<>();
        this.publicacoes = new ArrayList<>();
        this.sessao = null;
        this.proximoId = 1;
    }

    // Getters e Setters
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public List<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }

    public Sessao getSessao() {
        return this.sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    // Métodos
    private String gerarToken() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 5);
    }

    private void adicionarSessao(Usuario usuario, Integer id, String token) {
        Sessao sessao = new Sessao(usuario, usuario.getId(), token);
        this.setSessao(sessao);
        usuario.setEstado("autenticado");
    }

    private Usuario usuarioCorrente() {
        return this.getSessao().getUsuario();
    }

    public boolean registrar(String nome, String email, String senha) {
        Usuario user = null;
        for (Usuario usuario : usuarios) {
            user = usuario.procuraUsuario(email, senha);
        }

        if (user != null) {
            System.out.println("Falha ao registrar " + nome + ", usuario já existe");
            return false;
        }
        else {
            Usuario u = new Usuario(this.proximoId++, nome, email, senha, null);
            this.usuarios.add(u);

            System.out.println("Registro bem-sucedido para: " + nome);
            return true;
        }
    }

    public boolean login(String email, String senha) {
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            u = usuario.procuraUsuario(email, senha);
            if (u != null) {
                break;
            } 
        }

        if (u != null) {
            String token = gerarToken();
            adicionarSessao(u, u.getId(), token);
            System.out.println("Login bem-sucedido para: " + email);
            return true;
        }
        else {
            System.out.println("Falha no login.");
            return false;
        }
    } 

    public void cadastrarPublicacao(String titulo, String conteudo, List<String> tags, String categoria) {
        Usuario u = usuarioCorrente();
        Publicacao novaPublicacao = u.adicionarPublicacao(titulo, conteudo, tags, categoria, this);
        this.publicacoes.add(novaPublicacao);
        
        System.err.println("Publicacao adicionada às publicacoes do usuario " + u.getNome());
    }

    public void criarChave(int publicacaoID) {
    }

    public void verificarCopia(int publicacaoID) {
    }

    public void notificarCopia(int publicacaoID, int copiaID) {
    }
}