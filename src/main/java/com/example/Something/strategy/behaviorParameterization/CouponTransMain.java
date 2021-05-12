package com.example.Something.strategy.behaviorParameterization;

public class CouponTransMain {

	public static void main(String[] args) {
		Coupon coupon = new Coupon(1, "12AC00");

		Coupon.sendCoupon(coupon, new ChatCouponTrans());
	}
}
