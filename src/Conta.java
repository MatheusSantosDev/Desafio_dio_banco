import lombok.Data;

@Data
public abstract class Conta implements InterfaceConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    protected void imprimirInfoConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }


    @Override
    public boolean sacar(double valor) {
        if(valor < 0){
            System.out.println("o valor a ser sacado deve ser maior que zero");
            return false;
        }
        if(valor <= saldo){
            saldo -= valor;
            return true;
        }else{
            System.out.println("Saldo insulficiente");
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0){
            saldo += valor;
        }else{
            System.out.println("o valor a ser depositado deve ser maior que zero");
        }

    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        boolean podeSacar = this.sacar(valor);
        if(podeSacar){
            contaDestino.depositar(valor);
        }
    }
}
