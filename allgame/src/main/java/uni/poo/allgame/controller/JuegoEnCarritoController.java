package uni.poo.allgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uni.poo.allgame.dto.Compra;
import uni.poo.allgame.dto.JuegoSelecionado;
import uni.poo.allgame.service.JuegoEnCarritoService;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class JuegoEnCarritoController {
    @Autowired
    JuegoEnCarritoService juegoEnCarritoService;
    @PostMapping
    public@ResponseBody void agregarJuego(@RequestParam int id_usuario,@RequestParam  int id_juego,@RequestParam  int cant_juego){
        juegoEnCarritoService.agregarJuego(id_usuario,id_juego,cant_juego);
    }
    @DeleteMapping
    public@ResponseBody void quitarJuego(@RequestParam int id_juego){
        juegoEnCarritoService.quitarJuego(id_juego);
    }
    @GetMapping
    public List<JuegoSelecionado> mostrarCarrito(@RequestParam int id_usuario){
        return juegoEnCarritoService.mostrarCrrito(id_usuario);
    }
          
    @GetMapping("/Compcar")
    public String comprarJuegos(List<Compra> compras){
       return juegoEnCarritoService.comprarJuegos(compras);
    }
}
