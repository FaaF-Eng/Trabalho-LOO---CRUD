public class Cliente {
    private int id;
    private String nome;
    private String documento;
    private String email;

    public Cliente(String nome, String documento, String email) {
        this.nome = nome;
        this.documento = documento;
        this.email = email;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public String getDocumento() { return documento; }
    public String getEmail() { return email; }
}
