package com.xmu.address.service;

import com.xmu.address.dao.AddressDao;
import com.xmu.address.domain.address.Address;
import com.xmu.address.domain.address.AddressPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.type.IntersectionType;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    public List<Address> list(Integer userId, Integer page, Integer limit){return addressDao.list(userId,page,limit);}

    public  Integer deleteAddressById(Integer id){return addressDao.deleteAddressById(id);}

    public Address findAddressById(Integer id){return addressDao.findAddressById(id);}

    public AddressPo addAddress(AddressPo addressPo){return addressDao.addAddress(addressPo);}

    public AddressPo updateAddressById(Integer id,AddressPo addressPo){return addressDao.updateAddressById(id,addressPo);}

}
