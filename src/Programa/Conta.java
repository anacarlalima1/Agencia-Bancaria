package Programa;

import javax.swing.JOptionPane;

import utilirarios.Utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Cliente cliente;
	private Double saldo = 0.0;
	
	public Conta(Cliente cliente) {
		super();
		this.numeroConta = contadorDeContas;
		this.cliente = cliente;
		contadorDeContas += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		return "\nN�mero da conta: " + this.getNumeroConta() +
				"\nNome: " + this.cliente.getNome() +
				"\nCPF: " + this.cliente.getCpf() +
				"\nEmail: " + this.cliente.getEmail() +
				"\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
				"\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Dep�sito realizado com sucesso!");  
		}else
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o dep�sito.");
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor ) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque realizado com sucesso!");    
			}else {
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar o saque.");		
				}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
        	JOptionPane.showMessageDialog(null, "Transfer�ncia realizada com sucesso!");            
		}else {
        	JOptionPane.showMessageDialog(null, "N�o foi poss�vel realizar a transfer�ncia.");            
		}
	}

}
