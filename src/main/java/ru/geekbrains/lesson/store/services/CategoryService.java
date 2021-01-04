package ru.geekbrains.lesson.store.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson.store.entities.Category;
import ru.geekbrains.lesson.store.entities.Product;
import ru.geekbrains.lesson.store.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long category_id){
        return categoryRepository.findById(category_id);
    }

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public void saveOrUpdate(Category category){
        categoryRepository.save(category);
    }
}
