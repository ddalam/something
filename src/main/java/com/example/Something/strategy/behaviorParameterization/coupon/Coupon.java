package com.example.Something.strategy.behaviorParameterization;

public class Coupon {

	private int id;
	private String serialCode;

	public Coupon(int id, String serialCode) {
		this.id = id;
		this.serialCode = serialCode;
	}

	public static void sendCoupon(Coupon coupon, CouponTrans couponTrans) {
		couponTrans.trans(coupon);
	}
}
