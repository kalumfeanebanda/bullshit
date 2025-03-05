package com.example.sustaintrackcont.repository;

import com.example.sustaintrackcont.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
