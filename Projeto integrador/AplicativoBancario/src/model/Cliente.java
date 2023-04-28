package model;

public class Cliente {
    private static int counter = 1;
    private String nome;
    private String cpf;
    private String gmail;

    //Metodo Construtor
    public Cliente(String nome, String cpf, String gmail) {
        this.nome = nome;
        this.cpf = cpf;
        this.gmail = gmail;
        counter += 1;
    }
    public Cliente() {

    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf = cpf;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String toString() {
        return "/nNome: " + this.getNome() +
                "/nCPF:" + this.getCpf() +
                "/nGmail:" + this.getGmail();
    }
}
