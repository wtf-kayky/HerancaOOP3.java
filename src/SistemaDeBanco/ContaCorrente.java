package SistemaDeBanco;

public class ContaPoupança extends ContaBancaria {

    @Override
    public void sacar(double saque) {

        if (saque > 0) {
        } else if (saque > saldo + limiteDeChequeEspecial) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldo = saldo - saque;
            System.out.println("Saque realizado com sucesso" + this.saldo);
        }
    }


    private double limiteDeChequeEspecial = 500;


    public double getLimiteDeChequeEspecial() {
        return limiteDeChequeEspecial;
    }

    public ContaPoupança(String nome, String numerodaconta) {
        super(nome, numerodaconta);
        this.limiteDeChequeEspecial = 500;
    }

}

