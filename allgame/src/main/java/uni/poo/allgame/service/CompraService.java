package uni.poo.allgame.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.poo.allgame.dao.CompraDao;
import uni.poo.allgame.dao.JuegoDao;
import uni.poo.allgame.dto.Compra;
import uni.poo.allgame.dto.JuegoSelecionado;

@Service
public class CompraService {
    @Autowired
    CompraDao compraDao;
    @Autowired
    JuegoDao juegoDao;

    public List<JuegoSelecionado> historialCompra (int id_usuario){
        List<Compra> compras = compraDao.historialCompra(id_usuario);
        List<JuegoSelecionado> juegos = new ArrayList<>();
        for (Compra compra : compras) {
            JuegoSelecionado juego = juegoDao.obtenerJuego_id(compra.getId_juego());
            juego.setCantidad(compra.getCant_juego());
            
            juegos.add(juego);
        }
        
        return juegos;
    }
    public List<JuegoSelecionado> historialPedido (int id_usuario){
        List<Compra> compras = compraDao.historialPedido(id_usuario);
        List<JuegoSelecionado> juegos = new ArrayList<>();
        for (Compra compra : compras) {
            JuegoSelecionado juego = juegoDao.obtenerJuego_id(compra.getId_juego());
            juego.setCantidad(compra.getCant_juego());
            
            juegos.add(juego);
        }
        
        return juegos;
    }

    public String restarStock(int cant_juego, int id_juego){
        return compraDao.restarStock(cant_juego, id_juego);
    }
    public void agregarCompra(List<Compra> compras){
        compraDao.agregarCompra(compras);
    }


}