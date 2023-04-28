package main;

import model.Cliente;
import model.ContaCorrente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList <ContaCorrente> contaBancaria;

    public static void main(String[] args) {
        contaBancaria = new ArrayList<ContaCorrente>();

        opercoes();
    }

    private static void opercoes() {

        System.out.println("-----------------------------------------");
        System.out.println("--------Bem vindo a nossa Âgencia--------");
        System.out.println("-----------------------------------------");
        System.out.println(" Selecione a operação que deseja realizar");
        System.out.println("-----------------------------------------");
        System.out.println("Opção 1 - Criar conta  | ");
        System.out.println("Opção 2 - Depositar    | ");
        System.out.println("Opção 3 - Sacar        | ");
        System.out.println("Opção 4 - Trasferir    | ");
        System.out.println("Opção 5 - Listar       | ");
        System.out.println("Opção 6 - Sair         | ");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                CriarConta();
                break;
            case 2:
                Depositar();
                break;
            case 3:
                Sacar();
                break;
            case 4:
                Trasferir();
                break;
            case 5:
                Lista();
            case 6:
                System.out.println("Obrigado por usar nossa agencia!");
                System.exit(0);
            default:
                System.out.println("Opção invalida!");
                opercoes();
                break;
        }
    }

    private static void Lista() {
        if(contaBancaria.size() > 0) {
            for(ContaCorrente conta: contaBancaria) {
                System.out.println(conta);
            }
        }else {
            System.out.println("--- Não há contas cadastradas ---");
        }

        opercoes();
    }

    private static void Trasferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = input.nextInt();

        ContaCorrente contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            ContaCorrente contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = input.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);

            }else {
                System.out.println("--- A conta para depósito não foi encontrada ---");
            }

        }else {
            System.out.println("--- Conta para transferência não encontrada ---");
        }
        opercoes();
    }

    private static void Sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        ContaCorrente conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("--- Saque realizado com sucesso! ---");
        }else {
            System.out.println("--- Conta não encontrada! ---");
        }

        opercoes();
    }

    private static void Depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();
        ContaCorrente conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();

            conta.depositar(valorDeposito);
        }else {
            System.out.println("--- Conta não encontrada ---");
        }

        opercoes();
    }

    private static void CriarConta() {
        System.out.println("Nome: ");
        String nome = input.next();

        System.out.println("CPF: ");
        String cpf = input.next();

        System.out.println("Gmail: ");
        String gmail = input.next();

        Cliente pessoa = new Cliente(nome, cpf, gmail);
        ContaCorrente conta = new ContaCorrente (pessoa);
        contaBancaria.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");
        opercoes();

    }

    private static ContaCorrente encontrarConta(int numeroConta) {

        ContaCorrente conta = null;
        if(contaBancaria.size() > 0 ){
            for (ContaCorrente c: contaBancaria) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }
}



