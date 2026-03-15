package projeto.contato;

import java.time.LocalDate;

public class Contato {
    private long id;
    private String nome;
    private String email;
    private String fone;
    private LocalDate dataNascimento;

    public Contato() {
        this.id = 0;
        this.nome = "";
        this.email = "";
        this.fone = "";
        this.dataNascimento = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
