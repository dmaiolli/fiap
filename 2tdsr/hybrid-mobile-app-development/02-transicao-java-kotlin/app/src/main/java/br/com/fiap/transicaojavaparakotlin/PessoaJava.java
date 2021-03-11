package br.com.fiap.transicaojavaparakotlin;

public class PessoaJava {

    private String nome;
    private String email;

    public PessoaJava(String nome, String email) {
        this.nome = nome;
        this.email = email;

        // classe vindo do Kotlin (MainActivity.kt)
        PessoaEmail pessoa = new PessoaEmail("Denys", "denys@maiolli");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
