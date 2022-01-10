public class Main {

    public static void main(String[] args) {
        Cliente matheus = new Cliente();
        matheus.setNome("matheus");

        Conta cc = new ContaCorrente(matheus);
        Conta polpanca = new ContaPolpanca(matheus);

        cc.depositar(100);
        polpanca.depositar(150);
        cc.transferir(polpanca,20);

        cc.imprimirExtrato();
        polpanca.imprimirExtrato();
    }
}
