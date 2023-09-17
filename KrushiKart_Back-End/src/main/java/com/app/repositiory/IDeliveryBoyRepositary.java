package com.app.repositiory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.*;

@Repository
public interface IDeliveryBoyRepositary extends JpaRepository<DeliveryBoy, Long> {

	Optional<DeliveryBoy> findByEmailAndPassword(String email, String password);

	DeliveryBoy findDeliveryBoyByEmail(String email);

	List<DeliveryBoy> findByUserRole(Role roleDeliveryboy);
}
