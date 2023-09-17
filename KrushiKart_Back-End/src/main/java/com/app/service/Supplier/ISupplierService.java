package com.app.service.Supplier;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.SellerDto;
import com.app.dto.SupplierDto;

public interface ISupplierService {

	SellerDto saveSupplier( SellerDto sellerobj);

	List<SellerDto> getAllSelles();

	SupplierDto getSupplierById(Long supplierId);

}
