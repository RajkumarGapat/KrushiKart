package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.*;

@Repository
public interface OTPRepositary extends JpaRepository<OTP, String> {

}
