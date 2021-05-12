package com.example.Something.strategy.behaviorParameterization;

public class SmsCouponTrans implements CouponTrans {

	@Override
	public void trans(Coupon coupon) {
		System.out.println("문자로 쿠폰 발송");
	}
}
