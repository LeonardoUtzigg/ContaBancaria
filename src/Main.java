//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ContaBancaria P1 = new ContaBancaria();
        P1.abrirConta("CP");
        P1.setDono("Mateus");
        P1.setNumConta(1);
        P1.pagarMensal();
        P1.sacar(130);
        P1.fecharConta();
        P1.abrirConta("CC");
        P1.sacar(50);
        P1.depositar(40);
        P1.criarPoup();
        P1.avancarData(31);
        P1.taxaDeJuro();
        P1.estadoAtual();

    }
}
