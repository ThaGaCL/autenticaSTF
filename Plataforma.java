import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Plataforma {
    
    private List<Usuario> usuarios;
    private List<Publicacao> publicacoes;
    private Sessao sessao;
    private Integer proximoId;

    // Contrutor padrão
    public Plataforma() { 
        this.setUsuarios(null);
        this.setPublicacoes(null);
        this.setSessao(null);
        this.setProximoId(1);
    }

    // Getters e Setters
    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        if (usuarios == null) {
            this.usuarios = new ArrayList<>();
        } else {
            this.usuarios = usuarios;
        }
    }

    public List<Publicacao> getPublicacoes() {
        return this.publicacoes;
    }

    public void setPublicacoes(List<Publicacao> publicacoes) {
        if (publicacoes == null) {
            this.publicacoes = new ArrayList<>();
        } else {
            this.publicacoes = publicacoes;
        }
    }

    public Sessao getSessao() {
        return this.sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Integer getProximoId() {
        return this.proximoId;
    }

    public void setProximoId(Integer proximoId) {
        this.proximoId = proximoId;
    }

    // Métodos
    private String gerarToken() {
        return UUID.randomUUID()
                   .toString()
                   .replace("-", "")
                   .substring(0, 5);
    }

    private boolean adicionarSessao(Usuario usuario, Integer id, String token) {
        if (this.sessao != null) {
            return false;
        }
        Sessao sessao = new Sessao(usuario, usuario.getId(), token);
        this.setSessao(sessao);
        usuario.setEstado("autenticado");
        return true;
    }

    private void removerSessao(Usuario usuario) {
        this.setSessao(null);
        usuario.setEstado("nao autenticado");
    }

    private Usuario usuarioCorrente() {
        return this.getSessao().getUsuario();
    }

    public boolean registrar(String nome, String email, String senha) {
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            u = usuario.procuraUsuario(email, senha);
            if (u != null) {
                break;
            }
        }

        if (u != null) {
            System.out.println("Falha ao registrar " + nome + ", usuario já existe");
            return false;
        }

        this.usuarios.add(new Usuario(this.proximoId++, nome, email, senha, null));

        System.out.println("Registro bem-sucedido para: " + nome);
        return true;
    }

    public boolean login(String email, String senha) {
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            u = usuario.procuraUsuario(email, senha);
            if (u != null) {
                break;
            } 
        }

        if (u == null) {
            System.out.println("Falha no login: usuario ou senha não encontrado");
            return false;
        }

        String token = gerarToken();
        if (!adicionarSessao(u, u.getId(), token)) {
            System.out.println("Falha no login: já existe uma sessão ativa");
            return false;
        }

        System.out.println("Login bem-sucedido para: " + email);
        return true;
    } 

    public void logout() {
        Usuario u = usuarioCorrente();
        removerSessao(u);
        System.out.println("Logout bem-sucedido para: " + u.getEmail());
    }

    public void cadastrarPublicacao(String titulo, String conteudo, List<String> tags) {
        Usuario u = usuarioCorrente();
        Publicacao novaPublicacao = u.adicionarPublicacao(titulo, conteudo, tags, this);
        this.publicacoes.add(novaPublicacao);
        
        System.out.println("Publicacao adicionada às publicacoes do usuario " + u.getNome());
    }

    public boolean criarChave(int publicacaoID) {
        Publicacao p = null;
        List<Publicacao> publicacoes = usuarioCorrente().getPublicacoes();
        for (Publicacao publicacao : publicacoes) {
            if (publicacao.getId() == publicacaoID) {
                p = publicacao;
            }
        }

        if (p == null) {
            System.out.println("Falha ao criar chave: não foi possivel encontrar publicacao");
            return false;
        }
        
        p.adicionarChave(usuarioCorrente().getId());
        System.out.println("Chave criada com sucesso");
        return true;
    }

    public void verificarCopia(int publicacaoID) {
    }

    public void notificarCopia(int publicacaoID, int copiaID) {
    }
}