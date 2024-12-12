public class Main {
    public static void main(String[] args) {
        Plataforma p = new Plataforma();

        p.registrar("fulano", "fulano@email.com", "senha1");
        p.registrar("beltrano", "beltrano@email.com", "senha2");
        p.registrar("ciclano", "ciclano@email.com", "senha3");
        p.registrar("fulano", "fulano@email.com", "senha1");
        
        p.login("fulano@email.com", "senha1");
        p.cadastrarPublicacao("titulo", "esta é uma publicacao", null);
        p.logout();
        p.login("fulano@email.com", "senha1");
        p.login("fulano@email.com", "senha1");
        
        Publicacao publicacao = p.getSessao().getUsuario().getPublicacoes().get(0);
        
        System.out.println(publicacao);
        p.criarChave(1);
        System.out.println(publicacao);
    }
}
