public class Main {
    public static void main(String[] args) {
        Plataforma p = new Plataforma();

        p.registrar("fulano", "fulano@email.com", "senha1");
        p.registrar("beltrano", "beltrano@email.com", "senha2");
        p.registrar("ciclano", "ciclano@email.com", "senha3");

        p.login("fulano@email.com", "senha1");
    }
}
