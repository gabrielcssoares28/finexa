package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.Conexao;

public class UsuarioDAO {
    public int login(String email, String senha) {
    String sql = "SELECT id_usuario FROM usuarios WHERE email = ? AND senha = ?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id_usuario");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return -1;
}
    
    public void atualizar(int idUsuario, String nome, String email, String senha, String tipo) {
    String sql = "UPDATE usuarios SET nome=?, email=?, senha=?, tipo_usuario=? WHERE id_usuario=?";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, senha);
        stmt.setString(4, tipo);
        stmt.setInt(5, idUsuario);

        stmt.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    public void cadastrar(String nome, String email, String senha, String tipo) {
    String sql = "INSERT INTO usuarios (nome, email, senha, tipo_usuario) VALUES (?, ?, ?, ?)";

    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, senha);
        stmt.setString(4, tipo);

        stmt.executeUpdate();

        System.out.println("Usuário cadastrado!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
}
