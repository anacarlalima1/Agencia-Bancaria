package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AgenciaBancaria {
	
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	
	public static void operacoes() {
		
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma opera��o ---" +
								"\n|   Op��o 1 - Criar conta" +
								"\n|   Op��o 2 - Depositar" +
								"\n|   Op��o 3 - Sacar" +
								"\n|   Op��o 4 - Transferir" +
								"\n|   Op��o 5 - Listar" +
								"\n|   Op��o 6 - Sair"));
        
        switch(operacao) {
        case 1:
            criarConta();
            break;

        case 2:
            depositar();
            break;

        case 3:
            sacar();
            break;

        case 4:
            transferir();
            break;

        case 5:
            listarContas();
            break;

        case 6:
        	JOptionPane.showMessageDialog(null, "Obrigado por usar a nossa ag�ncia!");
            System.exit(0); 

        default:
        	JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            operacoes();
            break;
        }
	}
	
	public static void criarConta() {
		Cliente cliente = new Cliente();

		cliente.setNome(JOptionPane.showInputDialog("Nome:"));
		
		cliente.setCpf(JOptionPane.showInputDialog("CPF:"));
		
		cliente.setEmail(JOptionPane.showInputDialog("Email:"));

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
    	JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c : contasBancarias) {
                if(c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {

        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta para dep�sito: "));
       
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            Double valorDeposito =
            		Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar: "));
            conta.depositar(valorDeposito);
            JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
        }else {
        	JOptionPane.showMessageDialog(null, "Conta n�o encontrada!");
        }
        operacoes();

    }

    public static void sacar() {
        int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta para saque: "));

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
        	Double valorSaque =
            		Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar: "));
            conta.sacar(valorSaque);
        }else {
        	JOptionPane.showMessageDialog(null, "Conta n�o encontrada!");
        }

        operacoes();

    }

    public static void transferir() {
        int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta do remetente: "));

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            int numeroContaDestinatario = 
            		Integer.parseInt(JOptionPane.showInputDialog("N�mero da conta do destinat�rio: "));

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
            	Double valor =
                		Double.parseDouble(JOptionPane.showInputDialog("Valor da transfer�ncia: "));

                contaRemetente.transferir(contaDestinatario, valor);

            }else {
            	JOptionPane.showMessageDialog(null, "Qual valor deseja depositar: ");            }

        }else {
        	JOptionPane.showMessageDialog(null, "Conta para transfer�ncia n�o encontrada!");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
            	JOptionPane.showMessageDialog(null, conta);
            }
        }else {
        	JOptionPane.showMessageDialog(null, "N�o h� contas cadastradas!");
        }

        operacoes();
}
}