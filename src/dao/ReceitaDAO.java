package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReceitaDAO {
     public void cadastrar(String descricao, double valor, String data, int idUsuario, int idFonte, int idCategoria) {

        String sql = "INSERT INTO receitas (descricao, valor, data_recebimento, id_usuario, id_fonte_renda, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, descricao);
            stmt.setDouble(2, valor);
            stmt.setString(3, data);
            stmt.setInt(4, idUsuario);
            stmt.setInt(5, idFonte);
            stmt.setInt(6, idCategoria);

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

public double totalReceitas(int idUsuario) {
    String sql = "SELECT SUM(valor) as total FROM receitas WHERE id_usuario = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idUsuario);
        var rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getDouble("total");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}



}
