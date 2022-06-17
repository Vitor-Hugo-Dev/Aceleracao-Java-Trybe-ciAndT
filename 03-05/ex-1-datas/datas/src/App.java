import java.time.Clock;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {
        // fuso horário de UTC
        Clock relogio = Clock.systemDefaultZone();
        System.out.println(relogio);
        System.out.println(relogio.instant());

        // fuso horário local da maquina que esta executando o programa
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // .parse(string) converte uma string para um objeto LocalDateTime
        LocalDateTime diaSofrimento = LocalDateTime.parse("2014-07-08T17:00:00");
        System.out.println(diaSofrimento);
        System.out.println("Hello, World!");
    }
}
