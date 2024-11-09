package daw2a.apicervezas.services;

import daw2a.apicervezas.entities.Brewery;
import daw2a.apicervezas.exceptions.RecursoNoEncontradoException;
import daw2a.apicervezas.repositories.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BreweryService {
    private final BreweryRepository breweryRepository;

    @Autowired
    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    public Page<Brewery> listarCervecerias(Pageable pageable) {
        return breweryRepository.findAll(pageable);
    }

    public Brewery buscarCerveceria(Long id) {
        return breweryRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cerveceria con el id " + id + " no encontrada"));
    }

}
