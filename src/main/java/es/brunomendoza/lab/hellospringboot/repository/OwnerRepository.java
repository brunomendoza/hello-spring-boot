package es.brunomendoza.lab.hellospringboot.repository;

import es.brunomendoza.lab.hellospringboot.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
