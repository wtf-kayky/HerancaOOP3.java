package SistemaDeBanco;

public abstract class  ContaBancaria {

    protected String nome;
    protected String numerodaconta;
    protected double saldo;


    public ContaBancaria(String nome, String numerodaconta) {
        this.nome = nome;
        this.numerodaconta = numerodaconta;
        this.saldo = 0;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumerodaconta() {
        return numerodaconta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double deposito) {
        if (deposito > 0) {
            this.saldo = saldo + deposito;
            System.out.println("Valor depositado ");
        }
    }

    public abstract void sacar(double saque) throws SaldoInsuficienteException;

    public void informacoes() {
        System.out.println(" Nome do dono da conta " + this.nome + "\n" + "O numero da conta é" + this.numerodaconta + "\n" + "Saldo da conta " + this.saldo);
    }

    protected boolean validarValor(double valor) {
        if (valor > 0) {
            return true;
        } else {
            return false;
        }
    }
}
