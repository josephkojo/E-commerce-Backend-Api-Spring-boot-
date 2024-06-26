package com.Ecomence.Ecommece.Repository;

import com.Ecomence.Ecommece.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
