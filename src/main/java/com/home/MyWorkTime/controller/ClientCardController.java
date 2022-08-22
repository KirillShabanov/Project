package com.home.MyWorkTime.controller;

import com.home.MyWorkTime.entity.ClientCardModel;
import com.home.MyWorkTime.entity.RegulForTOModel;
import com.home.MyWorkTime.service.ClientCardService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients_card")
@AllArgsConstructor
@Log
@CrossOrigin
public class ClientCardController {

    private final ClientCardService clientCardService;

    @GetMapping(value = "/phone/{phoneNum}")
    public List<ClientCardModel> findClientForPhone(@PathVariable Long phoneNum){
        log.info("Phone find: " + phoneNum);
        return clientCardService.findClientForPhone(phoneNum);
    }

    @GetMapping(value = "/fullName/{fullName}")
    public List<ClientCardModel> findClientForFullName(@PathVariable String fullName){
        log.info("FullName find: " + fullName);
        return clientCardService.findClientForFullName(fullName);
    }

    @GetMapping(value = "/city/{city}")
    public List<ClientCardModel> findClientForCity(@PathVariable String city){
        log.info("FullName find: " + city);
        return clientCardService.findClientForCity(city);
    }

    @PostMapping(value = "/save")
    public ClientCardModel saveClient(@RequestBody ClientCardModel clientCardModel){
        log.info("Handling save client: " + clientCardModel);
        return clientCardService.saveClient(clientCardModel);
    }

    @GetMapping("/findById/{id}")
    public Optional<ClientCardModel> findById(@PathVariable Long id){
        log.info("Handling find by id client request: " + id);
        return clientCardService.findById(id);
    }


    @PutMapping(value = "/{id}")
    Optional<ClientCardModel> updateClient(@RequestBody ClientCardModel newClientCardModel,
                                           @PathVariable Long id){
        return clientCardService.findById(id).map(clientCardModel -> {
            clientCardModel.setClient_full_name(newClientCardModel.getClient_full_name());
            clientCardModel.setCity(newClientCardModel.getCity());
            clientCardModel.setAddress(newClientCardModel.getAddress());
            clientCardModel.setPhone(newClientCardModel.getPhone());
            return clientCardModel;
        });
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        log.info("Handling delete client request: " + id);
        clientCardService.deleteClient(id);
        return clientCardService.deleteClient(id);
    }

    @GetMapping("/findAllClients")
    public List<ClientCardModel> findAllClients(){
        log.info("Handling find all users request");
        return clientCardService.findAll();
    }
}
