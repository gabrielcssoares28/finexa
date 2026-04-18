package conexao;

import dao.UsuarioDAO;

public class TesteConexao {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        dao.cadastrar("Teste", "teste@email.com", "123456", "comum");
    }
}
