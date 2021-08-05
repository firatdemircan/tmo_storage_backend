package com.works.repostories;

import com.works.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepostories extends JpaRepository<Product,Integer> {
}
