package com.xmu.address.controller;
import com.xmu.address.domain.address.Address;
import com.xmu.address.domain.address.AddressPo;
import com.xmu.address.service.AddressService;
import com.xmu.address.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
	 * @param httpServletRequest
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/addresses")
	public Object list(HttpServletRequest httpServletRequest, @RequestParam Integer page, @RequestParam Integer limit) {
		Integer userId=Integer.parseInt(httpServletRequest.getHeader("userId"));
		if(userId==null){
			return ResponseUtil.unlogin();
		}
		List<Address> addressList=addressService.list(userId,page,limit);
		if(addressList.size()<page*limit){
			return ResponseUtil.badArgumentValue();
		}
		return ResponseUtil.ok(addressList);

	}

	/**
	 * 删除收货地址
	 * @param id
	 * @return
	 */
	@DeleteMapping("/address/{id}")
	//这里用int表示删除操作成功与否
	public Object delete(@PathVariable("id") Integer id) {

		Integer isDeleted=addressService.deleteAddressById(id);
		if(isDeleted==0){
			return ResponseUtil.badArgumentValue();
		}
		return ResponseUtil.ok();
	}
	/**
	 * 收货地址详情
	 *
	 * @param id     收货地址ID
	 * @return 收货地址详情
	 */
	@GetMapping("/addresses/{id}")
	public Object detail(@PathVariable("id") Integer id) {
		Address address=addressService.findAddressById(id);
		if(address==null){
			return ResponseUtil.badArgumentValue();
		}
		return ResponseUtil.ok(address);
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

	/**
	 * 更新收货地址
	 * @param id
	 * @param addressPo
	 * @return
	 */
	@PutMapping("/addresses/{id}")
	public Object update(@PathVariable("id") Integer id, @RequestBody AddressPo addressPo){
			addressPo=addressService.updateAddressById(id, addressPo);
			if(addressPo==null){
				return ResponseUtil.updatedDataFailed();
			}
			return ResponseUtil.ok(addressPo);
	}

	/**
	 * 管理员获取用户收货地址
	 * @param httpServletRequest
	 * @param page
	 * @param limit
	 * @param consignee
	 * @return
	 */
	@GetMapping("/admin/addresses")
	public Object getAddress(HttpServletRequest httpServletRequest,@RequestParam Integer page,@RequestParam Integer limit,@RequestParam String consignee){
		Integer userId=Integer.parseInt(httpServletRequest.getHeader("userId"));
		if(userId==null){
			return ResponseUtil.unlogin();
		}
		List<Address> addressList=addressService.getAddress(userId,page,limit,consignee);
		if(addressList.size()<page*limit){
			return ResponseUtil.badArgumentValue();
		}
		return ResponseUtil.ok(addressList);
	}
}