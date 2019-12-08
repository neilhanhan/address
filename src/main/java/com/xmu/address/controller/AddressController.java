package com.xmu.address.controller;

import com.xmu.address.domain.address.Address;
import com.xmu.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address findAddressById(@PathVariable("id") Integer id){
        return addressService.findAddressById(id);
    }

    @PostMapping("")
    public Integer addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("/{id}")
    public Integer updateAddress(@PathVariable("id") Integer id,@RequestBody Address address){
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public Integer deleteAddress(@PathVariable("id") Integer id){
        return addressService.deleteAddress(id);
    }

    @GetMapping("")
        public List<Address> findAllAddress(Integer userId) {
        return addressService.findAllAddress(userId);
    }
}
