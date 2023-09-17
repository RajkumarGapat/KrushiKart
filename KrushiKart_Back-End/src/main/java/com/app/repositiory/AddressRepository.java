package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
