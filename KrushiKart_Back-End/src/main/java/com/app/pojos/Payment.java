package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity

public class Payment extends BaseEntity {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate paymentDate;

	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@OneToOne
	@JoinColumn(name = "order_id")
	private Orders order;

	@Override
	public String toString() {
		return "Payment [paymentDate=" + paymentDate + ", paymentStatus=" + paymentStatus + ", paymentTyep="
				+ paymentType + "]";
	}

	public Payment(LocalDate paymentDate, PaymentStatus paymentStatus, PaymentType paymentType, Orders order) {
		super();
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.paymentType = paymentType;
		this.order = order;
	}

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	

}
