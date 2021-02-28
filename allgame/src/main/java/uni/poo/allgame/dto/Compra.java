package uni.poo.allgame.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Compra {
    private int id_usuario;
    private int id_juego;
    private int cant_juego;
    private String estado;
    private Date fecha_pedido;
    private Date fecha_entrega;
}
