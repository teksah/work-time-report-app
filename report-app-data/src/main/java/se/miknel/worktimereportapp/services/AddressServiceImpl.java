package se.miknel.worktimereportapp.services;

import org.springframework.stereotype.Service;
import se.miknel.worktimereportapp.model.Address;
import se.miknel.worktimereportapp.repositories.AddressRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Set<Address> findAll() {
        Set<Address> addresses = new HashSet<>();

        addressRepository.findAll().iterator().forEachRemaining(addresses::add);

        return addresses;
    }

    @Override
    public Address findById(Long aLong) {
        return addressRepository.findById(aLong).orElse(null);
    }

    @Override
    public Address save(Address object) {
        return addressRepository.save(object);
    }

    @Override
    public void delete(Address object) {
        addressRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        addressRepository.deleteById(aLong);
    }
}
