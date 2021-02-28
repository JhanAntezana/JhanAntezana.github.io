package uni.poo.allgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.poo.allgame.dao.UsuarioDao;
import uni.poo.allgame.dto.Usuario;

@Service
public class UsuarioService {
    @Autowired
    UsuarioDao usuarioDao;
    public String  registrarUsuario(Usuario usuario){
        if (usuarioDao.existeUsuario(usuario.getUsername(),usuario.getEmail())){
            return "Ya existe un usuario con este email o username";
        }else if(emailCorrecto(usuario.getEmail())){
            usuarioDao.crearUsuario(usuario);
            return "Registrado";
        }else{
            return "Email incorrecto";
        }
        
    }
    public boolean emailCorrecto(String email){
        int cont1 = 0;
        char emailArray[] = email.toCharArray();
        for(int i = 0;i<email.length();i++){
            if( emailArray[i] == '@'){
                cont1++;
            }
        }
        if(cont1 == 1)
            return true;
        else 
            return false;
    }
    public Usuario obtenerUsuario(String emailOrUsername){
        return usuarioDao.obtenerUsuario(emailOrUsername);
    }
    public void eliminarUsuario(String username){
        usuarioDao.eliminarUsuario(username);
    }
    public Usuario logInCorrect(String emailOrUsername,String password){
        if(usuarioDao.logInCorrecto(emailOrUsername, password)){
            return usuarioDao.obtenerUsuario(emailOrUsername);
        }else{
            return null;
        }

    }
}
