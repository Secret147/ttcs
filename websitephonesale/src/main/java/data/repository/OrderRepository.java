package data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import data.entity.CartEntity;
import data.entity.OderEntity;

public interface OrderRepository extends JpaRepository<OderEntity, Long> {
	List<OderEntity> findByUseridOrderByIdDesc(Long userid);


}
