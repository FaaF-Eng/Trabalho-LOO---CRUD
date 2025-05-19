import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaCadastro extends JFrame {

    private JTextField campoNome, campoDocumento, campoEmail;
    private JButton btnCadastrar, btnListar;
    private JTextArea areaExibicao;

    public TelaCadastro() {
        setTitle("Cadastro de Clientes");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 10, 100, 20);
        add(lblNome);

        campoNome = new JTextField();
        campoNome.setBounds(120, 10, 200, 20);
        add(campoNome);

        JLabel lblDocumento = new JLabel("Documento:");
        lblDocumento.setBounds(10, 40, 100, 20);
        add(lblDocumento);

        campoDocumento = new JTextField();
        campoDocumento.setBounds(120, 40, 200, 20);
        add(campoDocumento);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 70, 100, 20);
        add(lblEmail);

        campoEmail = new JTextField();
        campoEmail.setBounds(120, 70, 200, 20);
        add(campoEmail);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(10, 100, 150, 25);
        add(btnCadastrar);

        btnListar = new JButton("Listar Clientes");
        btnListar.setBounds(180, 100, 150, 25);
        add(btnListar);

        areaExibicao = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaExibicao);
        scroll.setBounds(10, 140, 360, 200);
        add(scroll);

        ClienteDAO dao = new ClienteDAO();

        btnCadastrar.addActionListener(e -> {
            String nome = campoNome.getText();
            String documento = campoDocumento.getText();
            String email = campoEmail.getText();
            Cliente cliente = new Cliente(nome, documento, email);
            dao.inserir(cliente);
            JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
        });

        btnListar.addActionListener(e -> {
            areaExibicao.setText("");
            ArrayList<Cliente> lista = dao.listar();
            for (Cliente c : lista) {
                areaExibicao.append("Nome: " + c.getNome() + ", Documento: " + c.getDocumento() + ", Email: " + c.getEmail() + "\n");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaCadastro();
    }
}
