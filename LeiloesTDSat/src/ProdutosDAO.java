import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;

    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, situacao) VALUES (?, ?, ?)";

        conn = new conectaDAO().connectDB();

        try {
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getSituacao()); 
            prep.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + e.getMessage());
        }
    }
    public void venderProduto(int idProduto) {
    String sql = "UPDATE produtos SET situacao = 'Vendido' WHERE id = ?";
    conn = new conectaDAO().connectDB();

    try {
        prep = conn.prepareStatement(sql);
        prep.setInt(1, idProduto);
        prep.executeUpdate();
        JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
    }
}
    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        conn = new conectaDAO().connectDB();
        

        try {
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setSituacao(resultset.getString("situacao"));
                listagem.add(produto);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }

        return listagem;
    }
    public ArrayList<ProdutosDTO> listarVendidos() {
   ArrayList<ProdutosDTO> lista = new ArrayList<>();
    String sql = "SELECT * FROM produtos WHERE situacao = 'Vendido'";
    conn = new conectaDAO().connectDB();
    try {
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();
        while (resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor"));
            produto.setSituacao(resultset.getString("situacao"));
            lista.add(produto);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar vendidos: " + e.getMessage());
    }
    return lista;
    }
}