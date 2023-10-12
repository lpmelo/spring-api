package lpmelo.crudspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lpmelo.crudspring.model.Client;
import lpmelo.crudspring.repository.ClientRepository;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getClientById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Boolean clientExist = clientRepository.existsById(id);

        if (clientExist) {
            Optional<Client> client = clientRepository.findById(id);
            response.put("success", true);
            response.put("client", client);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        response.put("success", false);
        response.put("msg", "Client with id: " + id + " not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addClient(@RequestBody Client cliente) {
        Map<String, Object> response = new HashMap<>();
        String clientName = cliente.getName();

        if (clientName != null) {
            Client newClient = clientRepository.save((cliente));
            response.put("success", true);
            response.put("client", newClient);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            response.put("success", false);
            response.put("msg", "Invalid values");
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(response);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Map<String, Object>> updateClient(@PathVariable Long id, @RequestBody Client requestClient) {
        Boolean clientExist = clientRepository.existsById(id);
        Map<String, Object> response = new HashMap<>();

        if (clientExist) {
            Client client = clientRepository.getReferenceById(id);

            client.setCpf(requestClient.getCpf());
            client.setName(requestClient.getName());
            client.setRg(requestClient.getRg());

            clientRepository.save(client);

            response.put("success", true);
            response.put("msg", "Client with id: " + id + " updated");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        response.put("success", false);
        response.put("msg", "Client with id: " + id + " not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Map<String, Object>> removeClient(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Boolean clientExist = clientRepository.existsById(id);

        if (clientExist) {
            clientRepository.deleteById(id);
            response.put("success", true);
            response.put("msg", "Client with id: " + id + " removed");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        response.put("success", false);
        response.put("msg", "Client with id: " + id + " not found");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
