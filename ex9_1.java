import java.util.Scanner;

public class IdadeSimples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataNascimento;
        String dataHoje;
        int idade;

        // Entrada de dados
        System.out.print("Digite a data de nascimento (DD/MM/AAAA): ");
        dataNascimento = scanner.nextLine();

        System.out.print("Digite a data de hoje (DD/MM/AAAA): ");
        dataHoje = scanner.nextLine();

        // Cálculo da idade
        idade = calcularIdade(dataNascimento, dataHoje);

        // Saída
        System.out.println("A idade da pessoa é: " + idade + " anos");

        scanner.close();
    }

    public static int calcularIdade(String nascimento, String hoje) {
        // Declarar variáveis
        int diaNasc, mesNasc, anoNasc;
        int diaHoje, mesHoje, anoHoje;
        int idade;

        // Pegar partes da data de nascimento
        diaNasc = Integer.parseInt(nascimento.substring(0, 2));
        mesNasc = Integer.parseInt(nascimento.substring(3, 5));
        anoNasc = Integer.parseInt(nascimento.substring(6, 10));

        // Pegar partes da data de hoje
        diaHoje = Integer.parseInt(hoje.substring(0, 2));
        mesHoje = Integer.parseInt(hoje.substring(3, 5));
        anoHoje = Integer.parseInt(hoje.substring(6, 10));

        // Cálculo simples da idade
        idade = anoHoje - anoNasc;

        // Verifica se ainda não fez aniversário no ano atual
        if (mesHoje < mesNasc || (mesHoje == mesNasc && diaHoje < diaNasc)) {
            idade = idade - 1;
        }

        return idade;
    }
}
