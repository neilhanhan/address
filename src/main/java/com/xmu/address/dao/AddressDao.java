package com.xmu.address.dao;

import com.github.pagehelper.PageHelper;
import com.xmu.address.domain.address.Address;
import com.xmu.address.domain.address.AddressPo;
import com.xmu.address.mapper.AddressMapper;
import com.xmu.address.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AddressDao {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    @Autowired
    private AddressMapper addressMapper;

    public List<Address> list(Integer userId,Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        List<Address> addressList=addressMapper.list(userId);
        for (Address address:addressList
             ) {
            address.setProvince(addressMapper.findRegionById(address.getProvinceId()));
            address.setCity(addressMapper.findRegionById(address.getCityId()));
            address.setCounty(addressMapper.findRegionById(address.getCountyId()));
        }
        return addressList;
    }
    public Integer deleteAddressById(Integer id){
        AddressPo addressPo=findAddressById(id);
        addressPo.setGmtModified(LocalDateTime.now());
        addressMapper.updateAddress(addressPo);
        return addressMapper.deleteAddressById(id);
    }

    public Address findAddressById(Integer id){
        Address address=addressMapper.findAddressById(id);
        address.setProvince(addressMapper.findRegionById(address.getProvinceId()));
        address.setCity(addressMapper.findRegionById(address.getCityId()));
        address.setCounty(addressMapper.findRegionById(address.getCountyId()));
        return address;
    }
    public AddressPo addAddress(AddressPo addressPo){
        addressPo.setGmtCreate(LocalDateTime.now());
        addressPo.setGmtModified(LocalDateTime.now());
        addressPo.setBeDeleted(false);
        addressMapper.addAddress(addressPo);
        return addressPo;
    }
    public AddressPo updateAddressById(Integer id,AddressPo addressPo) {
        addressPo.setId(id);
        addressPo.setGmtModified(LocalDateTime.now());
        addressMapper.updateAddress(addressPo);
            return findAddressById(id);

    }
    public List<Address> getAddress(Integer userId,Integer page,Integer limit,String consignee){
        PageHelper.startPage(page,limit);
        List<Address> addressList=addressMapper.getAddress(userId,consignee);
        for (Address address:addressList
        ) {
            address.setProvince(addressMapper.findRegionById(address.getProvinceId()));
            address.setCity(addressMapper.findRegionById(address.getCityId()));
            address.setCounty(addressMapper.findRegionById(address.getCountyId()));
        }
        return addressList;
    }
    }

