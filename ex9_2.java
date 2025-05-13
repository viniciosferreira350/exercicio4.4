import java.util.Scanner;

public class ValidadorCodigo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o código com 11 dígitos: ");
        String codigo = scanner.nextLine();

        // Verifica se o código tem 11 dígitos e todos são números
        if (codigo.length() != 11 || !codigo.matches("\\d{11}")) {
            System.out.println("Código inválido! Deve conter exatamente 11 dígitos numéricos.");
            return;
        }

        // Extrai os 9 primeiros dígitos e os 2 verificadores digitados
        String codigoBase = codigo.substring(0, 9);
        int verificador1Digitado = Character.getNumericValue(codigo.charAt(9));
        int verificador2Digitado = Character.getNumericValue(codigo.charAt(10));

        // Calcula os dígitos verificadores
        int verificador1Calculado = calcularSoma(codigoBase) / 10;
        int verificador2Calculado = calcularProdutoUltimoDigito(codigoBase);

        // Compara e imprime o resultado
        if (verificador1Calculado == verificador1Digitado && verificador2Calculado == verificador2Digitado) {
            System.out.println("Dígito Correto");
        } else {
            System.out.println("Dígito Inválido");
        }
    }

    public static int calcularSoma(String codigo) {
        int soma = 0;
        for (int i = 0; i < codigo.length(); i++) {
            soma += Character.getNumericValue(codigo.charAt(i));
        }
        return soma;
    }

    public static int calcularProdutoUltimoDigito(String codigo) {
        int produto = 1;
        for (int i = 0; i < codigo.length(); i++) {
            produto *= Character.getNumericValue(codigo.charAt(i));
        }
        // Retorna o último dígito do número (módulo 10)
        return produto % 10;
    }
}