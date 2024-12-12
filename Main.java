import java.util.List;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        plataforma.registrar("fulano", "fulano@email.com", "senha1");
        plataforma.registrar("beltrano", "beltrano@email.com", "senha2");
        plataforma.registrar("ciclano", "ciclano@email.com", "senha3");
        plataforma.registrar("fulano", "fulano@email.com", "senha1");
        
        plataforma.login("fulano@email.com", "senha1");
        plataforma.cadastrarPublicacao("titulo", "esta é uma publicacao", null);
        plataforma.logout();
        plataforma.login("fulano@email.com", "senha1");
        plataforma.login("fulano@email.com", "senha1");
        
        Publicacao publicacao = plataforma.getSessao().getUsuario().getPublicacoes().get(0);
        
        System.out.println(publicacao);
        plataforma.criarChave(1);
        System.out.println(publicacao);

        plataforma.logout();
        plataforma.login("beltrano@email.com", "senha2");
        plataforma.cadastrarPublicacao("cópia teste", "esta é uma publicacao", null);
        plataforma.criarChave(2);
        plataforma.verificarCopia(plataforma.getSessao().getUsuario().getPublicacoes().get(0).getId());

        List<Publicacao> publicacoes = plataforma.getSessao().getUsuario().getPublicacoes();

        System.out.println("publicacoesss");
        for (Publicacao pu : publicacoes) {
            System.out.println(pu);
        }
        
    }
}
