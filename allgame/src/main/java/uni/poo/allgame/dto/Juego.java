package uni.poo.allgame.dto;

import lombok.Data;

@Data
public class Juego {
    private int id_juego;
    private String nombre;
    private double precio;
    private String consola;
    private double descuento;
    private String descripcion;
    private String url;
}
