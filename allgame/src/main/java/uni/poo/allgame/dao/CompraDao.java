package uni.poo.allgame.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uni.poo.allgame.dto.Compra;

@Repository
public class CompraDao {
    @Autowired
    JdbcTemplate template;
  
    public List<Compra> historialCompra (int id_usuario){
        try {
            List<Compra> compras = new ArrayList<>();
            String sql = "select *from compras where id_usuario = ? and estado = 'entregado'";
            List<Map<String,Object>> registros = template.queryForList(sql,id_usuario);
            for (Map<String,Object> map : registros) {
                Compra compra = new Compra();

                compra.setId_usuario((Integer) map.get("id_usuario"));
                compra.setId_juego((Integer) map.get("id_juego"));
                compra.setCant_juego((Integer) map.get("cant_juego"));
                compra.setEstado((String) map.get("estado"));
                compra.setFecha_pedido((java.sql.Date) map.get("fecha_pedido"));
                compra.setFecha_entrega((java.sql.Date) map.get("fecha_entrega"));
                compras.add(compra);
            }
            
            return compras;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        
    }
    public List<Compra> historialPedido (int id_usuario){
        try {
            List<Compra> compras = new ArrayList<>();
            String sql = "select *from compras where id_usuario = ? and estado = 'pedido'";
            List<Map<String,Object>> registros = template.queryForList(sql,id_usuario);
            for (Map<String,Object> map : registros) {
                Compra compra = new Compra();

                compra.setId_usuario((Integer) map.get("id_usuario"));
                compra.setId_juego((Integer) map.get("id_juego"));
                compra.setCant_juego((Integer) map.get("cant_juego"));

                compras.add(compra);
            }
            
            return compras;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        
    }

    public String restarStock(int cant_juego, int id_juego){
        String sql = "UPDATE juegos SET stock = stock - ? WHERE id_juego = ? ";
        template.update(sql, cant_juego,id_juego);
        return "stock actualizado";
    }

    public void agregarCompra(List<Compra> compras){
        for (Compra compra : compras) {
            String sql = "insert into compras values(?,?,?) ";
            template.update(sql,compra.getId_usuario(),compra.getId_juego(),compra.getCant_juego());
        
        }
       
    }
}
