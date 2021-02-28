package uni.poo.allgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uni.poo.allgame.dto.Compra;
import uni.poo.allgame.dto.JuegoSelecionado;
import uni.poo.allgame.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraService compraService;
    
    @GetMapping
    public String restarStock(int cant_juego, int id_juego){
        return compraService.restarStock(cant_juego, id_juego);
    }

    @GetMapping("/compra")
    public List<JuegoSelecionado> historialCompra (int id_usuario){
        return compraService.historialCompra(id_usuario);
    }
    @PostMapping
    public void agregarCompra(List<Compra> compras){
        compraService.agregarCompra(compras);
    }

}
