package SistemaDeBanco;

public class mainbanco {
    public static void main (String[] args){


            Banco banco = new Banco();


            ContaCorrente contaJoao = new ContaCorrente("João Silva", "1001");
            ContaCorrente contaMaria = new ContaCorrente("Maria Oliveira", "1002");
            ContaPoupanca contaCarlos = new ContaPoupanca("Carlos Souza", "2001");


            contaJoao.depositar(1000);
            contaMaria.depositar(500);
            contaCarlos.depositar(2000);


            banco.adcionarConta(contaJoao);
            banco.adcionarConta(contaMaria);
            banco.adcionarConta(contaCarlos);


            ContaCorrente contaDuplicada = new ContaCorrente("Duplicado", "1001");
            banco.adcionarConta(contaDuplicada);

            System.out.println("\n=== LISTA INICIAL ===");
            banco.ListadeContas();


            System.out.println("\n=== TESTE DE SAQUES ===");
            try {
                contaJoao.sacar(300);
                contaMaria.sacar(600);
                contaCarlos.sacar(2500);
            } catch (SaldoInsuficienteException e) {
                System.out.println("ERRO no saque: " + e.getMessage());
            }

            System.out.println("\n=== APÓS SAQUES ===");
            banco.ListadeContas();


            System.out.println("\n=== TESTE DE TRANSFERÊNCIAS ===");
            banco.transferir("1001", "2001", 200);
            banco.transferir("1002", "2001", 300);
            banco.transferir("2001", "1001", 3000);
            System.out.println("\n=== LISTA FINAL ===");
            banco.ListadeContas();


            System.out.println("\n=== RENDIMENTO DA POUPANÇA ===");
            contaCarlos.TaxaDeRendimento();

            System.out.println("\n=== APÓS RENDIMENTO ===");
            banco.ListadeContas();
        }
    }

