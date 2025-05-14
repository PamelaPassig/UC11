import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){        
        String sql = "INSERT INTO produtos (nome, valor, situacao) VALUES (?, ?, ?)";
        }   
        conn = new conectaDAO().connectDB();
        try{
        prep = conn.prepareStatement(sql);
        prep.setString(1, produto.getNome());
        prep.setInt(2, produto.getValor());
        prep.setString(3, produto.getSituacao());
        prep.execute();
        JOptionPane.showMessageDialog(null,"Produto cadastrado");
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ e.getMessage());
}
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
   
        
}

