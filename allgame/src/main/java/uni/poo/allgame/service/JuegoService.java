package uni.poo.allgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uni.poo.allgame.dao.JuegoDao;
import uni.poo.allgame.dto.JuegoInventario;
import uni.poo.allgame.dto.JuegoSelecionado;

@Service
public class JuegoService {
    
    @Autowired
    JuegoDao juegoDao;
    public String AgregarJuego(JuegoInventario juego){
        return juegoDao.AgregarJuego(juego);
    }

    public List<JuegoInventario> buscarJuego_nombre(String nombre){
        return juegoDao.BuscarJuego_nombre(nombre);
    }
    public JuegoSelecionado obtenerJuego_id(int id_juego){
        return juegoDao.obtenerJuego_id(id_juego);
    }
    public List<JuegoInventario> obtenerJuego_consola(String consola){
        return juegoDao.obtenerJuego_consola(consola);
    }
    public List<JuegoInventario> mostrarInventario(){
        return juegoDao.mostrarInventario();
    }

    public String eliminarJuego(String nombre){
        return juegoDao. eliminarJuego(nombre);
    }
}
