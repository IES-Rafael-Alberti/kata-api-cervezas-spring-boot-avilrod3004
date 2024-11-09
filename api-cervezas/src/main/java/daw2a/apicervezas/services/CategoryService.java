package daw2a.apicervezas.services;

import daw2a.apicervezas.entities.Category;
import daw2a.apicervezas.exceptions.RecursoNoEncontradoException;
import daw2a.apicervezas.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> listarCategorias(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category obtenerCategoria(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Categoria con el id " + id + "no encontrada"));
    }
}
