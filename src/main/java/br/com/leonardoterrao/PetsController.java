package br.com.leonardoterrao;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardoterrao.entity.Pet;
import br.com.leonardoterrao.repository.PetRepository;

@RestController
@RequestMapping(path = "/pets")
public class PetsController {

    private final PetRepository petRepository;

    public PetsController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @GetMapping
    public List<Pet> pets(@RequestParam("breed") String breed) {
        if (breed != null) {
            return petRepository.findAllByBreedContainingIgnoreCase(breed);
        }
        return petRepository.findAll();
    }

    @PostMapping
    public Pet postPet(Pet pet) {
        return petRepository.save(pet);
    }
    // curl -d '{"name": "Luma", "breed": "Miniature Pinscher"}' -H "Content-Type: application/json" http://localhost:8080/pets
}
