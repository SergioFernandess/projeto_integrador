package model;

import utilitario.Utils;
public class ContaCorrente {

    private static int contadorDeConta = 1;

    private int numeroConta;
    private Cliente cliente;
    private  Double saldo = 0.0;

    public ContaCorrente(Cliente cliente) {
        this.numeroConta = contadorDeConta;
        this.cliente = cliente;
        contadorDeConta += 1;
    }
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public String toString(){
        return "Número da conta: " + this.getNumeroConta() +
                " Nome: " + this.cliente.getNome() +
                " CPF: " + this.cliente.getCpf() +
                " Gmail: " + this.cliente.getGmail() +
                " Saldo: " + Utils.doubleToString(this.getSaldo());
    }
    public void depositar( Double valor) {
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso! ");
        }else {
            System.out.println("Não foi possivel realizar o deposito! ");
        }
    }
    public void sacar( Double valor) {

        if (valor > 0 && this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso! ");
        }else {
            System.out.println("Não foi possível realizar saque! ");
        }
    }
    public void transferencia(ContaCorrente contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            //this.saldo = this.getSaldo() - valor;
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }else {
            System.out.println("Não foi possível realizar a tranferência");
        }

    }

}
