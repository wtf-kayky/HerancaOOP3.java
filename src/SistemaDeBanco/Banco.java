package SistemaDeBanco;

public class Banco {
}
package SistemaDeBanco;
import java.util.ArrayList;

public class Banco {


    private ArrayList<ContaBancaria> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void adcionarConta(ContaBancaria novaconta) {
        String novoNumero = novaconta.getNumerodaconta();
        for (int i = 0; i < contas.size(); i++) {
            if (novaconta.getNumerodaconta().equals(contas.get(i).getNumerodaconta())) {
                System.out.println("Conta ja existente");
                return;
            }
        }
        contas.add(novaconta);
        System.out.println(" Conta adcionada com sucesso ");
    }


    public ContaBancaria buscarConta(String numeroProcurado) {

        for (int i = 0; i < contas.size(); i++) {
            ContaBancaria contaAtual = contas.get(i);

            if (numeroProcurado.equals(contaAtual.getNumerodaconta())) {
                return contaAtual;
            }
        }
        return null;
    }

    public void ListadeContas() {

        if (contas.size() == 0) {
            System.out.println(" Nenhuma conta cadastrada ");
            return;
        }
        System.out.println(" === LISTA DE CONTAS ===");
        for (int i = 0; i < contas.size(); i++) {
            ContaBancaria contaAtual = contas.get(i);
            contaAtual.informacoes();
            System.out.println(" ----------------------- ");
        }
    }


    public void transferir(String numOrigem, String numDestino, double valor) {

        if (valor <= 0) {
            System.out.println(" Valor inválido ");
            return;
        } else {

            ContaBancaria Origem = buscarConta(numOrigem);
            ContaBancaria Destino = buscarConta(numDestino);
            if (Origem == null) {
                System.out.println(" Conta de origem não existente ");
                return;
            } else if (Destino == null) {
                System.out.println(" Conta de destino não existente ");
                return;

            } else {
                try {
                    Origem.sacar(valor);
                    Destino.depositar(valor);
                    System.out.println(" transferencia bem sucedida");
                    return;
                } catch (SaldoInsuficienteException e ) {
                    System.out.println(" Saldo insuficiente ");
                }
            }
        }
    }
}
