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

    @GetMapping
    public ResponseEntity<Page<Beer>> listarCervezas(Pageable pageable) {
        Page<Beer> beers = beerService.listarCervezas(pageable);
        return ResponseEntity.ok(beers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beer> buscarCerveza(@PathVariable Long id) {
        Beer beer = beerService.obtenerCerveza(id);
        return ResponseEntity.ok(beer);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Beer> registrarCerveza(@RequestBody @Valid Beer beer) {
        Beer cervezaNueva = beerService.registrarCerveza(beer);
        return ResponseEntity.status(HttpStatus.CREATED).body(cervezaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beer> actualizarCerveza(@PathVariable Long id, @RequestBody Beer cervezaActualizada) {
        Beer cerveza = beerService.actualizarCerveza(id, cervezaActualizada);
        return ResponseEntity.ok(cerveza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Beer> eliminarCerveza(@PathVariable Long id) {
        beerService.eliminarCerveza(id);
        return ResponseEntity.noContent().build();
    }

}