package com.home.MyWorkTime.service;

import com.home.MyWorkTime.entity.ClientCardModel;
import com.home.MyWorkTime.repository.ClientCardAddressRepository;
import com.home.MyWorkTime.repository.ClientCardPhoneRepository;
import com.home.MyWorkTime.repository.ClientCardRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class ClientCardService {

    private ClientCardPhoneRepository clientCardPhoneRepository;
    private ClientCardAddressRepository clientCardAddressRepository;
    private ClientCardRepository clientCardRepository;

    @Autowired
    public ClientCardService(ClientCardPhoneRepository clientCardPhoneRepository, ClientCardAddressRepository clientCardAddressRepository, ClientCardRepository clientCardRepository) {
        this.clientCardPhoneRepository = clientCardPhoneRepository;
        this.clientCardAddressRepository = clientCardAddressRepository;
        this.clientCardRepository = clientCardRepository;
    }

    public List<ClientCardModel> findClientForPhone(Long phoneNum) {
        return clientCardPhoneRepository.findClientForPhone(phoneNum);
    }

    public List<ClientCardModel> findClientForFullName(String searchFullName) {
        return clientCardAddressRepository.findClientForFullName(searchFullName);
    }

    public List<ClientCardModel> findClientForCity(String city) {
        return clientCardAddressRepository.findClientForCity(city);
    }

    public ClientCardModel saveClient(ClientCardModel clientCardModel) {
        ClientCardModel savedClient = clientCardRepository.save(clientCardModel);
        return ClientCardRepository.saveClient(savedClient);
    }

    public Optional<ClientCardModel> findById(Long id) {
        return clientCardRepository.findById(id);
    }

    public ResponseEntity<Void> deleteClient(Long id) {
        clientCardRepository.deleteById(id);
        return null;
    }

    public List<ClientCardModel> findAll() {
        return clientCardRepository.findAll();
    }
}
