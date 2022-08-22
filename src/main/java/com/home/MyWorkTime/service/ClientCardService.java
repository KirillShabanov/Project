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

    @Autowired
    private ClientCardPhoneRepository clientCardPhoneRepository;
    @Autowired
    private ClientCardAddressRepository clientCardAddressRepository;
    @Autowired
    private ClientCardRepository clientCardRepository;

    public List<ClientCardModel> findClientForPhone(Long phoneNum) {
        return clientCardPhoneRepository.findClientForPhone(phoneNum);
    }

    public List<ClientCardModel> findClientForFullName(String fullName) {
        return clientCardAddressRepository.findClientForFullName(fullName);
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
