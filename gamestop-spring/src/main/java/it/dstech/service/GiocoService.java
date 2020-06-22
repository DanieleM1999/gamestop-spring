package it.dstech.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.model.Gioco;
import it.dstech.repository.GiocoRepository;

@Service
@Transactional
public class GiocoService {
	@Autowired GiocoRepository repo;
	
	public void save(Gioco gioco) {
		repo.save(gioco);
	}
	
	public List<Gioco> listAll() {
		return (List<Gioco>) repo.findAll();
	}
	
	public Gioco get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
