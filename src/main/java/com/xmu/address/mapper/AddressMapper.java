package com.xmu.address.mapper;

import com.xmu.address.domain.address.Address;
import com.xmu.address.domain.address.AddressPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.net.Inet4Address;
import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    /**
     * 根据用户id获取地址列表
     * @param userId
     * @return
     */
    List<Address> list(Integer userId);

    /**
     * 根据省市县id查询省市县
     * @param id
     * @return
     */
    String findRegionById(Integer id);

    /**
     * 根据id删除常用地址
     * @param id
     * @return
     */
    Integer deleteAddressById(Integer id);

    /**
     * 根据id查看收获地址详情
     * @param id
     * @return
     */
    Address findAddressById(Integer id);

    /**
     * 用户新增用户地址
     * @param addressPo
     * @return
     */
    Integer addAddress(AddressPo addressPo);

    /**
     * 用户更新收货地址
     * @param addressPo
     * @return
     */
    Integer updateAddress(AddressPo addressPo);




}
