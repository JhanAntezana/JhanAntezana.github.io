package uni.poo.allgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uni.poo.allgame.dto.Usuario;
import uni.poo.allgame.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @PostMapping
    public @ResponseBody String registrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.registrarUsuario(usuario);
    }
    
    @GetMapping
    public @ResponseBody Usuario obtenerUsuario(@RequestParam String username){
        
        return usuarioService.obtenerUsuario(username);
    }
    @DeleteMapping
    public @ResponseBody String eliminarUsuario(@RequestParam String username){
        usuarioService.eliminarUsuario(username);
        return "Usuario eliminado";
    }
    
    @GetMapping("/logIn/{emailOrUsername}/{password}")
    public @ResponseBody Usuario logIn(@PathVariable String emailOrUsername, @PathVariable String password){
        return usuarioService.obtenerUsuario(emailOrUsername);
    }
}
