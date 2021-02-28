package uni.poo.allgame.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uni.poo.allgame.dto.JuegoInventario;
import uni.poo.allgame.dto.JuegoSelecionado;

@Repository
public class JuegoDao {
    @Autowired
    JdbcTemplate template;
    public String AgregarJuego(JuegoInventario juego){
        String sql = "INSERT INTO JUEGOS(nombre,precio,consola,stock,descuento,descripcion) VALUES (?,?,?,?,?,?,?)";
        template.update(sql,juego.getNombre(),juego.getPrecio(),juego.getConsola(),juego.getStock(),juego.getDescuento(),juego.getDescripcion(),juego.getUrl());
        return "juego registrado";
    }
    public List<JuegoInventario> BuscarJuego_nombre(String nombre){
        try {
            List<JuegoInventario> juegos = new ArrayList<>();
            String sql = "select *from juegos where nombre like '%"+nombre+"%'";
            List<Map<String,Object>> registros = template.queryForList(sql);
            for (Map<String,Object> mapajuego : registros) {
                JuegoInventario juego = new JuegoInventario();
                juego.setId_juego((Integer)mapajuego.get("id_juego"));
                juego.setNombre((String) mapajuego.get("nombre"));
                juego.setPrecio((Double) mapajuego.get("precio"));
                juego.setConsola((String) mapajuego.get("consola"));
                juego.setStock((Integer) mapajuego.get("stock"));
                juego.setDescuento((Double) mapajuego.get("descuento"));
                juego.setDescripcion((String) mapajuego.get("descripcion"));
                juego.setUrl((String) mapajuego.get("url"));
                
                juegos.add(juego);
            }
            return juegos;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public JuegoSelecionado obtenerJuego_id(int id_juego){
        try {
            String sql = "select *from juegos where id_juego = ?";
            Map<String,Object> registro = template.queryForMap(sql,id_juego);
            JuegoSelecionado juego = new JuegoSelecionado();
            juego.setId_juego(id_juego);
            juego.setNombre((String) registro.get("nombre"));
            juego.setPrecio((Double) registro.get("precio"));
            juego.setConsola((String) registro.get("consola"));
            juego.setDescuento((Double)registro.get("descuento"));
            juego.setDescripcion((String) registro.get("descripcion"));
            juego.setUrl((String) registro.get("url"));
            return juego;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        
    }
    public List<JuegoInventario> obtenerJuego_consola(String consola){
        try {
            List<JuegoInventario> juegos = new ArrayList<>();
            String sql = "select *from juegos where consola = ?";
            List<Map<String,Object>> registros = template.queryForList(sql,consola);
            for (Map<String,Object> map : registros) {
                JuegoInventario juego = new JuegoInventario();
                juego.setId_juego((Integer)map.get("id_juego"));
                juego.setNombre((String) map.get("nombre"));
                juego.setPrecio((Double) map.get("precio"));
                juego.setConsola((String) map.get("consola"));
                juego.setStock((Integer) map.get("stock"));
                juego.setDescuento((Double) map.get("descuento"));
                juego.setDescripcion((String) map.get("descripcion"));
                juego.setUrl((String) map.get("url"));

                juegos.add(juego);
            }
            return juegos;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    public List<JuegoInventario> mostrarInventario(){
        try {
            List<JuegoInventario> juegos = new ArrayList<>();
            String sql = "SELECT * FROM juegos";
            List<Map<String,Object>> registros = template.queryForList(sql);
            for (Map<String,Object> mapajuego : registros) {
                JuegoInventario juego = new JuegoInventario();
                juego.setId_juego((Integer) mapajuego.get("id_juego"));
                juego.setNombre((String) mapajuego.get("nombre"));
                juego.setPrecio((Double) mapajuego.get("precio"));
                juego.setConsola((String) mapajuego.get("consola"));
                juego.setStock((Integer) mapajuego.get("stock"));
                juego.setDescuento((Double) mapajuego.get("descuento"));
                juego.setDescripcion((String) mapajuego.get("descripcion"));
                juego.setUrl((String) mapajuego.get("url"));

                juegos.add(juego);
            }

            return juegos;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        
    }
    public String eliminarJuego(String name){
        String sql = " DELETE FROM juegos WHERE nombre = ?";
        template.update(sql,name);
        return "el juego fue eliminado";
    }
}

