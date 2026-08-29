package SistemaDeBanco;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(String nome, String numerodaconta) {
        super(nome, numerodaconta);
    }

    @Override
    public void sacar(double saque, ) {
        if (saque > 0) {
        } else if (saque > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo = saldo - saque;
            System.out.println("Saque realizado com sucesso" + this.saldo);
        }
    }


    private double TaxaDeRendimento = 0.05;

    public int getTaxaDeRendimento() {
        return (int) TaxaDeRendimento;
    }


    public void TaxaDeRendimento() {

        this.saldo *= (1 + TaxaDeRendimento);

        System.out.println("Veja qunato rendeu o seu dinheiro" + this.saldo);
    }
}


