package DAO;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import util.codigo_bancos;
import Conexao.Conexao;

public class codigos_bancosDAO {

    public List<codigo_bancos> listarProdutos() throws Exception {
        ResultSet resultSet = null;
        List<codigo_bancos> listaProdutos = new ArrayList<>();

        try (Connection connection = Conexao.getDatabaseConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from codigo_bancos")) {

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String instituicao = resultSet.getString(2);
                listaProdutos.add(new codigo_bancos(id, instituicao));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar produtos: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return listaProdutos;
    }

    public codigo_bancos buscarPorId(int id) throws Exception {
        codigo_bancos banco = null;
    
        try (Connection connection = Conexao.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM codigo_bancos WHERE id = ?")) {
    
            preparedStatement.setInt(1, id); 
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) { 
                    String instituicao = resultSet.getString("instituicao");
                    banco = new codigo_bancos(id, instituicao);
                } else {
                    throw new Exception("Nenhum registro encontrado com o ID fornecido.");
                }
            }
        }
        return banco;
    } 
}