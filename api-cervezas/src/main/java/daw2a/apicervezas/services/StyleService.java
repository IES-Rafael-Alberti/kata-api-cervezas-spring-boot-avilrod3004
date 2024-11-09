package daw2a.apicervezas.services;

import daw2a.apicervezas.entities.Style;
import daw2a.apicervezas.exceptions.RecursoNoEncontradoException;
import daw2a.apicervezas.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StyleService {
    private final StyleRepository styleRepository;

    @Autowired
    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public Page<Style> listarEstilos(Pageable pageable) {
        return styleRepository.findAll(pageable);
    }

    public Style obtenerEstilo(Long id) {
        return styleRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Estilo con el id " + id + " no encontrado"));
    }
}
