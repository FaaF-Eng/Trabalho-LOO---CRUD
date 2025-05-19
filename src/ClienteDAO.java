import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO clientes (nome, documento, email) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getDocumento());
            stmt.setString(3, cliente.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> listar() {
        ArrayList<Cliente> lista = new ArrayList<>();
        String sql = "SELECT nome, documento, email FROM clientes";
        try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nome = rs.getString("nome");
                String documento = rs.getString("documento");
                String email = rs.getString("email");
                lista.add(new Cliente(nome, documento, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
