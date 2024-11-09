package daw2a.apicervezas.controllers;

import daw2a.apicervezas.entities.Category;
import daw2a.apicervezas.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Page<Category>> listarCategorias(Pageable pageable) {
        Page<Category> categorias = categoryService.listarCategorias(pageable);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoria(@PathVariable Long id) {
        Category categoria = categoryService.obtenerCategoria(id);
        return ResponseEntity.ok(categoria);
    }
}
