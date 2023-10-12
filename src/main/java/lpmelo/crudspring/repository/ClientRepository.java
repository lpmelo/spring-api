package lpmelo.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lpmelo.crudspring.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
