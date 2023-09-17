package com.app.service.DeliveryBoy;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dto.DeliveryBoyDto;
import com.app.dto.SellerDto;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.Role;
import com.app.pojos.SellerReg;
import com.app.repositiory.IDeliveryBoyRepositary;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class DeliveryBoyServiceImpl implements IDeliveryBoyService {
	
	@Autowired
	private IDeliveryBoyRepositary deliveryBoyRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<DeliveryBoyDto> getAllDeliveryBoy() {
//		log.info("In DeliveryBoy service implimentation : getAllDeliveryBoy ");
		List<DeliveryBoy> deliveryBoy = deliveryBoyRepo.findByUserRole(Role.ROLE_DELIVERYBOY);
		List<DeliveryBoyDto> listDB = new ArrayList<DeliveryBoyDto>();
		for (DeliveryBoy dboy : deliveryBoy) {
			listDB.add(mapper.map(dboy, DeliveryBoyDto.class));
		}
		return listDB;
	}

	@Override
	public DeliveryBoyDto saveDeliveryBoy(@Valid DeliveryBoyDto deliveryBoy) {
		DeliveryBoy deliveryboy = mapper.map(deliveryBoy, DeliveryBoy.class);
		deliveryboy.setPassword(passwordEncoder.encode(deliveryboy.getPassword()));
		DeliveryBoy persistentObj = deliveryBoyRepo.save(deliveryboy);
		return mapper.map(persistentObj, DeliveryBoyDto.class);
	}

}
