package com.xmu.address.mapper;

import com.xmu.address.domain.address.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    /**
     * 根据id返回地址对象
     * @param id
     * @return
     */
    Address findAddressById(Integer id);

    /**
     * 新增地址
     * @param address
     * @return
     */
    Integer addAddress(Address address);

    /**
     * 修改地址
     * @param address
     * @return
     */
    Integer updateAddress(Address address);

    /**
     * 删除地址
     * @param id
     * @return
     */
    Integer deleteAddress(Integer id);

    /**
     * 根据用户id获取地址列表
     * @param userId
     * @return
     */
    List<Address> findAllAddress(Integer userId);



}
