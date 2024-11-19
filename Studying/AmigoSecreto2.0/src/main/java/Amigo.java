import java.util.Objects;

class Amigo {
    private final String nome;
    private final String email;
    private Amigo amigoSecreto;

    public Amigo(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public Amigo getAmigoSecreto() { return amigoSecreto; }
    public void setAmigoSecreto(Amigo amigoSecreto) { this.amigoSecreto = amigoSecreto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amigo amigo = (Amigo) o;
        return Objects.equals(email, amigo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
