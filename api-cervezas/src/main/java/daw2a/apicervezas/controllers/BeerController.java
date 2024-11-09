package daw2a.apicervezas.controllers;

import daw2a.apicervezas.entities.Beer;
import daw2a.apicervezas.services.BeerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beers")
public class BeerController {
    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    // Listar todas las cervezas
    @GetMapping
    public ResponseEntity<Page<Beer>> listarCervezas(Pageable pageable) {
        Page<Beer> beers = beerService.listarCervezas(pageable);
        return ResponseEntity.ok(beers);
    }

    // Consultar los datos de una cerveza por id
    @GetMapping("/{id}")
    public ResponseEntity<Beer> buscarCerveza(@PathVariable Long id) {
        Beer beer = beerService.obtenerCerveza(id);
        return ResponseEntity.ok(beer);
    }

    // Registrar una cerveza nueva
    @PostMapping
    public ResponseEntity<Beer> registrarCerveza(@RequestBody @Valid Beer beer) {
        Beer cervezaNueva = beerService.registrarCerveza(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(cervezaNueva);
    }

    // Modificar datos de una cerveza por id
    @PutMapping("/{id}")
    public ResponseEntity<Beer> actualizarCerveza(@PathVariable Long id, @RequestBody Beer cervezaActualizada) {
        Beer cerveza = beerService.actualizarCerveza(id, cervezaActualizada);
        return ResponseEntity.ok(cerveza);
    }

    // Eliminar una cerveza por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Beer> eliminarCerveza(@PathVariable Long id) {
        beerService.eliminarCerveza(id);
        return ResponseEntity.noContent().build();
    }

}
