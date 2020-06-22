package it.dstech.repository;

import org.springframework.data.repository.CrudRepository;
import it.dstech.model.Gioco;

public interface GiocoRepository extends CrudRepository<Gioco, Long> {
}
