package br.com.leonardoterrao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leonardoterrao.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByBreedContainingIgnoreCase(String breed);

}