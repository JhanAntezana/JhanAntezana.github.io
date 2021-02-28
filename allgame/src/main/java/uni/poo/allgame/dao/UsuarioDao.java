package uni.poo.allgame.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import uni.poo.allgame.dto.Usuario;

import java.util.Map;

@Repository
public class UsuarioDao {
    @Autowired
    JdbcTemplate template;
    public void crearUsuario(Usuario usuario){
        String sql = "INSERT into usuarios (nombre,apellido,username,email,password) VALUES (?,?,?,?,?)";
        template.update(sql,usuario.getNombre(),usuario.getApellido(),usuario.getUsername(),usuario.getEmail(),usuario.getPassword());
    }
    
    public boolean existeUsuario(String username, String email){
        try {
            String sql = "select *from usuarios where username = ? or email = ?";
            Map<String,Object> registro = template.queryForMap(sql,username,email);
            String user = (String) registro.get("username");
            return !user.equals(null);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        
    }
    
    public Usuario obtenerUsuario(String emailOrUsername){
        String sql = "select *from usuarios where username = ? or email = ?";
        SqlRowSet rs = template.queryForRowSet(sql, emailOrUsername, emailOrUsername);
        Usuario usuario = null;
        if(rs.next()){
            usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setUsername(rs.getString("username"));
            usuario.setEmail(rs.getString("email"));
            usuario.setPassword(rs.getString("password"));
        }
        return usuario;
    }
    public void eliminarUsuario(String username){
        String sql = " DELETE FROM usuarios WHERE username = ?";
        template.update(sql,username);
    }
    public boolean logInCorrecto(String emailOrUsername, String password){
        try {
            String sql = "SELECT * FROM usuarios WHERE (username = ? OR email = ?) AND password = ?";
            SqlRowSet rs = template.queryForRowSet(sql, emailOrUsername, emailOrUsername, password);
            return rs.next();
           

        } catch (EmptyResultDataAccessException e) {
            return false;
        }
        
    }   
}
