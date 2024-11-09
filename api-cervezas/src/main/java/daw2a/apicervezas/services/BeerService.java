package daw2a.apicervezas.services;

import daw2a.apicervezas.entities.Beer;
import daw2a.apicervezas.exceptions.RecursoNoEncontradoException;
import daw2a.apicervezas.repositories.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BeerService {
    private final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Page<Beer> listarCervezas(Pageable pageable) {
        return beerRepository.findAll(pageable);
    }

    public Beer obtenerCerveza(Long id) {
        return beerRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Cerveza con id " + id + " no encontrada"));
    }

    public Beer registrarCerveza(Beer beer) {
        return beerRepository.save(beer);
    }

    public Beer actualizarCerveza(Long id, Beer cervezaActualizada) {
        return beerRepository.findById(id)
                .map(cerveza -> {
                    if (cervezaActualizada.getBrewery() != null) {
                        cerveza.setBrewery(cervezaActualizada.getBrewery());
                    }
                    if (cervezaActualizada.getName() != null) {
                        cerveza.setName(cervezaActualizada.getName());
                    }
                    if (cervezaActualizada.getCatId() != null) {
                        cerveza.setCatId(cervezaActualizada.getCatId());
                    }
                    if (cervezaActualizada.getStyleId() != null) {
                        cerveza.setStyleId(cervezaActualizada.getStyleId());
                    }
                    if (cervezaActualizada.getAbv() != null) {
                        cerveza.setAbv(cervezaActualizada.getAbv());
                    }
                    if (cervezaActualizada.getIbu() != null) {
                        cerveza.setIbu(cervezaActualizada.getIbu());
                    }
                    if (cervezaActualizada.getSrm() != null) {
                        cerveza.setSrm(cervezaActualizada.getSrm());
                    }
                    if (cervezaActualizada.getUpc() != null) {
                        cerveza.setUpc(cervezaActualizada.getUpc());
                    }
                    if (cervezaActualizada.getFilepath() != null) {
                        cerveza.setFilepath(cervezaActualizada.getFilepath());
                    }
                    if (cervezaActualizada.getDescript() != null) {
                        cerveza.setDescript(cervezaActualizada.getDescript());
                    }
                    if (cervezaActualizada.getAddUser() != null) {
                        cerveza.setAddUser(cervezaActualizada.getAddUser());
                    }
                    if (cervezaActualizada.getLastMod() != null) {
                        cerveza.setLastMod(cervezaActualizada.getLastMod());
                    }

                    return beerRepository.save(cerveza);
                }).orElseThrow(() -> new RecursoNoEncontradoException("Cerveza con id " + id + " no encontrada"));
    }

    public void eliminarCerveza(Long id) {
        if (!beerRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Cerveza con id " + id + " no encontrada");
        }
        beerRepository.deleteById(id);
    }
}
