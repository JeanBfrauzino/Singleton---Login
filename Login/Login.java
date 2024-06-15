package Login;

import java.util.Random;

public class Login {
    private static Login instanciaUnica;
    private String nomeUsuario;
    private String senha;
    private boolean isBotVerified;
    private String codigoVerificacaoAtual;

    private Login() {
        // Construtor privado para impedir a instância direta
    }

    public static Login getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Login();
        }
        return instanciaUnica;
    }

    public void setCredenciais(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public boolean verificarLogin(String nomeUsuario, String senha, String botInput) {
        if (this.nomeUsuario.equals(nomeUsuario) && this.senha.equals(senha) && isBotVerified(botInput)) {
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            System.out.println("Login falhou!");
            return false;
        }
    }

    public String gerarCodigoVerificacao() {
        int length = 6;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*";
        Random random = new Random();
        StringBuilder codigo = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        codigoVerificacaoAtual = codigo.toString();
        return codigoVerificacaoAtual;
    }

    private boolean isBotVerified(String botInput) {
        isBotVerified = codigoVerificacaoAtual.equals(botInput);
        return isBotVerified;
    }
}