package uni.poo.allgame.dto;

import lombok.Data;

@Data
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String username;
    private String email;
    private String password;
}
