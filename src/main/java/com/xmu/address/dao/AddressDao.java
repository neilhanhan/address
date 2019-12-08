package com.xmu.address.dao;

import com.xmu.address.domain.address.Address;
import com.xmu.address.mapper.AddressMapper;
import com.xmu.address.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDao {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    @Autowired
    private AddressMapper addressMapper;

    public Address findAddressById(Integer id){
    Address address=addressMapper.findAddressById(id);


    return address;
    }

    public Integer addAddress(Address address){
        return addressMapper.addAddress(address);
    }

    public Integer updateAddress(Integer id,Address address){
        address.setId(id);
        return addressMapper.updateAddress(address);
    }

    public Integer deleteAddress(Integer id){
        return addressMapper.deleteAddress(id);
    }

    public List<Address> findAllAddress(Integer userId){
        return addressMapper.findAllAddress(userId);
    }
}
