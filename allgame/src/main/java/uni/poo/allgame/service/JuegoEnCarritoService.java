package uni.poo.allgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.poo.allgame.dao.CompraDao;
import uni.poo.allgame.dao.JuegoDao;
import uni.poo.allgame.dao.JuegoEnCarritoDao;
import uni.poo.allgame.dto.Compra;
import uni.poo.allgame.dto.JuegoEnCarrito;
import uni.poo.allgame.dto.JuegoSelecionado;

import java.util.ArrayList;
import java.util.List;

@Service
public class JuegoEnCarritoService {
    @Autowired
    JuegoEnCarritoDao juegoEnCarritoDao;
    @Autowired
    JuegoDao juegoDao;
    @Autowired
    CompraDao compraDao;

    public  void agregarJuego(int id_usuario,int id_juego,int cant_juego){
        juegoEnCarritoDao.agregarJuego(id_usuario,id_juego,cant_juego);
    }
    public  void quitarJuego(int id_juego){
        juegoEnCarritoDao.quitarJuego(id_juego);
    }
    public List<JuegoSelecionado> mostrarCrrito(int id_usuario){
        List<JuegoEnCarrito> juegosCarrito = juegoEnCarritoDao.mostrarCrrito(id_usuario);
        List<JuegoSelecionado> juegos = new ArrayList<>();
        for (JuegoEnCarrito juegoEnCarrito : juegosCarrito) {
            JuegoSelecionado juego = juegoDao.obtenerJuego_id(juegoEnCarrito.getId_juego());
            juego.setCantidad(juegoEnCarrito.getCant_juego());
            juegos.add(juego);
        }
        return juegos;
    }
    public String comprarJuegos(List<Compra> compras){

        compraDao.agregarCompra(compras);
        for (Compra compra : compras) {
            compraDao.restarStock(compra.getCant_juego(), compra.getId_juego());
        } 
      return " Compra Exitosa" ;  //controles y service faltan
    } 
    

}
