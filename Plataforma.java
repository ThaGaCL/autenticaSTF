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
    private Publicacao procurarCopia(Publicacao p, Usuario u) {
        Publicacao copia = null;
        for (Publicacao publicacao : this.getPublicacoes()) {
            copia = publicacao.achouCopia(publicacao, u);
            if (copia != null) {
                break;
            }
        }
        return copia;
    }

    private Usuario procuraUsuario(String email, String senha) {
        Usuario u = null;
        for (Usuario usuario : usuarios) {
            u = usuario.achouUsuario(email, senha);
            if (u != null) {
                break;
            }
        }
        return u;
    }

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
        return this.getSessao().usuarioCorrente();
    }

    public boolean registrar(String nome, String email, String senha) {
        Usuario u = procuraUsuario(email, senha);

        if (u != null) {
            exibeNaTela("Falha ao registrar " + nome + ", usuario já existe");
            return false;
        }

        this.usuarios.add(new Usuario(this.proximoId++, nome, email, senha, null));

        exibeNaTela("Registro bem-sucedido para: " + nome);
        return true;
    }

    public boolean login(String email, String senha) {
        Usuario u = procuraUsuario(email, senha);

        if (u == null) {
            exibeNaTela("Falha no login: usuario ou senha não encontrado");
            return false;
        }

        String token = gerarToken();
        if (!adicionarSessao(u, u.getId(), token)) {
            exibeNaTela("Falha no login: já existe uma sessão ativa");
            return false;
        }

        exibeNaTela("Login bem-sucedido para: " + email);
        return true;
    } 

    public void logout() {
        Usuario usuarioCorrente = usuarioCorrente();
        removerSessao(usuarioCorrente);

        exibeNaTela("Logout bem-sucedido para: " + usuarioCorrente.getEmail());
    }

    public void cadastrarPublicacao(String titulo, String conteudo, List<String> tags) {
        Usuario u = usuarioCorrente();
        Publicacao novaPublicacao = u.adicionarPublicacao(titulo, conteudo, tags, this);
        this.publicacoes.add(novaPublicacao);
        
        exibeNaTela("Publicacao adicionada às publicacoes do usuario " + u.getNome());
    }

    public boolean criarChave(int publicacaoID) {
        Usuario usuarioCorrente = usuarioCorrente();
        Publicacao p = usuarioCorrente.procurarPublicacao(publicacaoID);

        if (p == null) {
            exibeNaTela("Falha ao criar chave: não foi possivel encontrar publicacao");
            return false;
        }

        if (p.getChave() != null) {
            exibeNaTela("A publicacao já tem uma chave");
        }
        
        p.adicionarChave(usuarioCorrente.getId());

        exibeNaTela("Chave criada com sucesso");
        return true;
    }

    public boolean verificarCopia(int publicacaoID) {
        Usuario usuarioCorrente = usuarioCorrente();
        Publicacao p = usuarioCorrente.procurarPublicacao(publicacaoID);

        if (p == null) {
            exibeNaTela("Falha ao verificar cópia: não foi possivel encontrar publicacao");
            return false;
        }

        if (p.getChave() == null) {
            exibeNaTela("Falha ao verificar cópia: publicacao não tem uma chave registrada");
            return false;
        }
        
        Publicacao copia = procurarCopia(p, usuarioCorrente);
        
        if (copia == null) {
            exibeNaTela("Nenhuma cópia encontrada");
            return false;
        }
        
        p.registrarOcorrenciaCopia(copia);
        
        exibeNaTela("Uma cópia foi encontrada e registrada");
        return true;
    }

    public void notificar(Publicacao publicacaoOriginal, Publicacao publicacaoCopia) {
        Notificacao notificacao = new Notificacao(publicacaoOriginal, publicacaoCopia, publicacaoOriginal.getAutor());
        exibeNaTela(notificacao);
    }

    public void exibeNaTela(Object info) {
        System.out.println(info);
    }
}