package daw2a.apicervezas.controllers;

import daw2a.apicervezas.entities.Brewery;
import daw2a.apicervezas.services.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breweries")
public class BreweryController {
    private final BreweryService breweryService;

    @Autowired
    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping
    public ResponseEntity<Page<Brewery>> listarCervecerias(Pageable pageable) {
        Page<Brewery> cervecerias = breweryService.listarCervecerias(pageable);
        return ResponseEntity.ok(cervecerias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brewery> obtenerCerveceria(@PathVariable Long id) {
        Brewery cerveceria = breweryService.buscarCerveceria(id);
        return ResponseEntity.ok(cerveceria);
    }
}
