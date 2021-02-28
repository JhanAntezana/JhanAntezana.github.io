package uni.poo.allgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uni.poo.allgame.dto.JuegoInventario;
import uni.poo.allgame.dto.JuegoSelecionado;
import uni.poo.allgame.service.JuegoService;

@RestController
@RequestMapping("/juegos")
public class JuegoController {
    @Autowired
    JuegoService juegoService;

    @PostMapping
    public  String  AgregarJuego(@RequestBody JuegoInventario juego){
        return juegoService.AgregarJuego(juego);
    }

    @GetMapping
    public JuegoSelecionado obtenerJuego_id(@RequestParam int id_juego){
        return juegoService.obtenerJuego_id(id_juego);
    }

    @GetMapping("/{nombre}")
    public List<JuegoInventario> buscarJuego_nombre(@PathVariable String nombre){
        return juegoService.buscarJuego_nombre(nombre);
    }
    @GetMapping("/consola")
    public List<JuegoInventario> obtenerJuego_consola(@RequestParam String consola){
        return juegoService.obtenerJuego_consola(consola);
    }
    @GetMapping("/inventario")
    public List<JuegoInventario> mostrarInventario(){
        return juegoService.mostrarInventario();
    }

    @DeleteMapping
    public String eliminarJuego(@RequestParam String nombre){
        return juegoService. eliminarJuego(nombre); 
    }
}
    
 