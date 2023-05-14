package data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
