package daw2a.apicervezas.controllers;

import daw2a.apicervezas.entities.Style;
import daw2a.apicervezas.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/styles")
public class StyleController {
    private final StyleService styleService;

    @Autowired
    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping
    public ResponseEntity<Page<Style>> listarEstilos(Pageable pageable) {
        Page<Style> categorias = styleService.listarEstilos(pageable);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Style> obtenerEstilo(@PathVariable Long id) {
        Style estilo = styleService.obtenerEstilo(id);
        return ResponseEntity.ok(estilo);
    }
}
