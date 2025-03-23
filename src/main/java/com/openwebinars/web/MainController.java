package com.openwebinars.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductoRepository productoRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hola Mundo");
        return "index";
    }
    @GetMapping("/producto/{id}")
    public String employeePathVariable(
            @PathVariable("id") Long id,
            Model model) {
        model.addAttribute("id", id);

        return "producto";
    }

    @GetMapping("/saludo")
    public String ejemploQueryParam(

        @RequestParam(
                name = "nombre",
                required = false,
                defaultValue = "User"
        )String nombre,
        Model model
    ) {
            String msg = "Hola, " + nombre;
            model.addAttribute("menssage", msg);
            return "saludo";
    }

    @GetMapping("/multimap")
    public ResponseEntity<String> ejemploMultimap(
            @RequestParam MultiValueMap<String, String> params
            ){
        return ResponseEntity.ok().body(params.toString());
    }

    @GetMapping("/tips")
    public String tips(Model model) {
        /*Producto producto = Producto.builder()
                .id(7L)
                        .nombre("iphone 16 pro")
                                .precio(1219.24)
                                        .build();

        model.addAttribute("producto", producto);*/
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("fecha", LocalDateTime.of(2025, 1, 1, 10, 15));
        return "tips";
    }
}
