import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Plataforma {
    private List<Usuario> usuarios;
    private List<Publicacao> publicacoes;
    private List<Sessao> sessoes;
    private Integer proximoId;

    // Construtores
    public Plataforma() { 
        this.usuarios = new ArrayList<>();
        this.publicacoes = new ArrayList<>();
        this.sessoes = new ArrayList<>();
        this.proximoId = 1;
    }

    // Getters e Setters
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public List<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }

    public List<Sessao> getSessoes() {
        return this.sessoes;
    }

    // Métodos
    private String gerarToken() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 5);
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
        Usuario user = null;
        for (Usuario usuario : usuarios) {
            user = usuario.procuraUsuario(email, senha);
            if (user != null) {
                break;
            } 
        }

        if (user != null) {
            String token = gerarToken();
            Sessao sessao = new Sessao(user, user.getId(), token);
            this.sessoes.add(sessao);
            System.out.println("Login bem-sucedido para: " + email);
            return true;
        }
        else {
            System.out.println("Falha no login.");
            return false;
        }
    } 

    public void cadastrarPublicacao(Usuario usuario, String titulo, String descricao, List<String> tags, String categoria, String anexo) {
    }

    public void criarChave(int publicacaoID) {
    }

    public void verificarCopia(int publicacaoID) {
    }

    public void notificarCopia(int publicacaoID, int copiaID) {
    }
}