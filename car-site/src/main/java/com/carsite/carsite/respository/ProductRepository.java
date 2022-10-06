package com.carsite.carsite.respository;

import com.carsite.carsite.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, String> {



}
