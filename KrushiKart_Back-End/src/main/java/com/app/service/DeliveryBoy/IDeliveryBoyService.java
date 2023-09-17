package com.app.service.DeliveryBoy;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.DeliveryBoyDto;

public interface IDeliveryBoyService {

	List<DeliveryBoyDto> getAllDeliveryBoy();

	DeliveryBoyDto saveDeliveryBoy(@Valid DeliveryBoyDto deliveryBoy);

}
