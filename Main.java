public class Main {
    public static void main(String[] args) {
        // Parte 1: Navegador
        Browser navegador = new Browser();
        navegador.navegarPara("google.com");
        navegador.navegarPara("github.com");
        navegador.navegarPara("stackoverflow.com");
        navegador.estadoAtual();
        navegador.voltar();
        navegador.estadoAtual();
        navegador.avancar();
        navegador.estadoAtual();

        System.out.println("\n---\n");

        // Parte 2: Senhas hospitalares
        FilaSenhas hospital = new FilaSenhas();
        hospital.gerarSenha();
        hospital.gerarSenha();
        hospital.gerarSenha();
        hospital.estadoFila();
        hospital.chamarProximo();
        hospital.chamarProximo();
        hospital.estadoFila();
        hospital.mostrarHistorico();
    }
}
