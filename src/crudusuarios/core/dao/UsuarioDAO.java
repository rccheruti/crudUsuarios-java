package crudusuarios.core.dao;

import crudusuarios.core.entity.Usuario;
import crudusuarios.core.dao.conexao.ConexaoMySQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome, login, senha, email) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = ConexaoMySQL.conectar().prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getEmail());

            statement.execute();

            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {

            }
        }
    }
}
