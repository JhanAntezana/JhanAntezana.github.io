package uni.poo.allgame.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import uni.poo.allgame.dto.JuegoEnCarrito;

@Repository
public class JuegoEnCarritoDao {
    @Autowired
    JdbcTemplate template;
    public void agregarJuego(int id_usuario,int id_juego,int cant_juego){
        String sql = "INSERT INTO juegos_en_carrito values (?,?,?)";
        template.update(sql, id_usuario,id_juego,cant_juego);
    }

    public void quitarJuego (int id_juego){
        String sql = "delete from juegos_en_carrito where id_juego = ?";
        template.update(sql, id_juego);
    }
    public List<JuegoEnCarrito> mostrarCrrito(int id_usuario){
        String sql = "select *from juegos_en_carrito where id_usuario = ?";
        ArrayList<JuegoEnCarrito> juegos = new ArrayList<>();
        List<Map<String,Object>> registros = template.queryForList(sql,id_usuario);
        for (Map<String, Object> map : registros) {
            JuegoEnCarrito juego = new JuegoEnCarrito();
            juego.setId_usuario((Integer) map.get("id_usuario"));
            juego.setId_juego((Integer) map.get("id_juego"));
            juego.setCant_juego((Integer) map.get("cant_juego"));

            juegos.add(juego);
        }
        return juegos;
    }
    
}
