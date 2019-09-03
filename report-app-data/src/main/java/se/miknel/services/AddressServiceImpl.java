package se.miknel.services;

import org.springframework.stereotype.Service;
import se.miknel.exceptions.NotFoundException;
import se.miknel.model.Address;
import se.miknel.repositories.AddressRepository;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long aLong) {
        return addressRepository.findById(aLong).orElseThrow(NotFoundException::new);
    }

    @Override
    public Address save(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        addressRepository.deleteById(aLong);
    }
}
