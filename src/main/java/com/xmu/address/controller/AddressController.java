package com.xmu.address.controller;/*
package和import根据项目具体实现
 */

import com.xmu.address.domain.address.Address;
import com.xmu.address.domain.address.AddressPo;
import com.xmu.address.service.AddressService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 管理员和用户收货地址服务
 */
@RestController
@RequestMapping("")
@Validated
public class AddressController {
	@Autowired
	private AddressService addressService;

	/**
	 * 用户收货地址列表
	 * @param userId
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/addresses")
	public List<Address> list(@RequestParam Integer userId,@RequestParam Integer page,@RequestParam Integer limit) {
		return addressService.list(userId,page,limit);
	}

	/**
	 * 删除收货地址
	 * @param id
	 * @return
	 */
	@DeleteMapping("/address/{id}")
	//这里用int表示删除操作成功与否
	public int delete(@PathVariable("id") Integer id) {
		return addressService.deleteAddressById(id);
	};
	/**
	 * 收货地址详情
	 *
	 * @param id     收货地址ID
	 * @return 收货地址详情
	 */
	@GetMapping("/addresses/{id}")
	public Address detail(@PathVariable("id") Integer id) {
		return addressService.findAddressById(id);
	}

	/**
	 * 添加收货地址
	 * @param addressPo
	 * @return
	 */
	@PostMapping("/addresses")
	public AddressPo save(@RequestBody AddressPo addressPo){
		return addressService.addAddress(addressPo);
	}


	@PutMapping("/addresses/{id}")
	public AddressPo update(@PathVariable("id") Integer id, @RequestBody AddressPo addressPo){
		return addressService.updateAddressById(id,addressPo);
	}

//	/**
//	 * 管理员获取地址列表
//	 *
//	 * @param id 用户id
//	 * @param name 用户名
//	 * @return 用户的地址列表
//	 */
//
//	@GetMapping("/addresses")
//	public List<Address> addressList(Integer id, String name);
}