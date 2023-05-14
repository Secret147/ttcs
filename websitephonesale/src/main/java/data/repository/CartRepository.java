package data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import data.entity.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

	List<CartEntity> findByUseridOrderByIdDesc (Long userid);

}
