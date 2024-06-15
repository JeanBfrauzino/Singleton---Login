package Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = Login.getInstance();

        System.out.print("Defina o nome de usuário: ");
        String nomeUsuario = scanner.nextLine();

        System.out.print("Defina a senha: ");
        String senha = scanner.nextLine();

        login.setCredenciais(nomeUsuario, senha);

        System.out.println("**** Sistema de Login ****");

        System.out.print("Nome de usuário: ");
        String inputNomeUsuario = scanner.nextLine();

        System.out.print("Senha: ");
        String inputSenha = scanner.nextLine();

        // Simular verificação de bot
        String codigoVerificacao = login.gerarCodigoVerificacao();
        System.out.println("Digite o seguinte código para verificar que você não é um bot: " + codigoVerificacao);
        System.out.print("Código: ");
        String botInput = scanner.nextLine();

        login.verificarLogin(inputNomeUsuario, inputSenha, botInput);

        scanner.close();
    }
}
