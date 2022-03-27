package es.brunomendoza.lab.hellospringboot.controller;

import es.brunomendoza.lab.hellospringboot.entity.Owner;
import es.brunomendoza.lab.hellospringboot.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("/owner/{id}")
    public Owner getOwnerById(@PathVariable Long id) throws ResponseStatusException {
        Optional<Owner> optional =  ownerRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User: %d not found", id));
    }
}
