package com.xmu.address.service;

import com.xmu.address.dao.AddressDao;
import com.xmu.address.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    public Address findAddressById(Integer id){
        return addressDao.findAddressById(id);
    }

    public Integer addAddress(Address address){
        return addressDao.addAddress(address);
    }

    public Integer updateAddress(Integer id,Address address){return addressDao.updateAddress(id,address);}

    public Integer deleteAddress(Integer id){return addressDao.deleteAddress(id);}

    public List<Address> findAllAddress(Integer userId){return addressDao.findAllAddress(userId);}

}
