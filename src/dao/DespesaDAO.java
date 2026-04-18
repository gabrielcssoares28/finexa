package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.Conexao;

public class DespesaDAO {
    public void cadastrar(String descricao, double valor, String data, String forma, int idUsuario, int idCategoria) {
        String sql = "INSERT INTO despesas (descricao, valor, data_pagamento, forma_pagamento, id_usuario, id_categoria) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, descricao);
            stmt.setDouble(2, valor);
            stmt.setString(3, data);
            stmt.setString(4, forma);
            stmt.setInt(5, idUsuario);
            stmt.setInt(6, idCategoria);

            stmt.executeUpdate();

            System.out.println("Despesa cadastrada!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public double totalDespesas(int idUsuario) {
    String sql = "SELECT SUM(valor) as total FROM despesas WHERE id_usuario = ?";

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
 
    
public ResultSet listar(int idUsuario) {
    String sql = "SELECT descricao, valor, data_pagamento FROM despesas WHERE id_usuario = ?";

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);

        return stmt.executeQuery();

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
    

public ResultSet listarTudo(int idUsuario) {
    String sql = 
        "SELECT descricao, valor, data_pagamento AS data, 'Despesa' AS tipo FROM despesas WHERE id_usuario = ? " +
        "UNION ALL " +
        "SELECT descricao, valor, data_recebimento AS data, 'Receita' AS tipo FROM receitas WHERE id_usuario = ? " +
        "ORDER BY data DESC";

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idUsuario);

        return stmt.executeQuery();

    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


}
