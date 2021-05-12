package com.example.Something.strategy.behaviorParameterization;

public class ChatCouponTrans implements CouponTrans {

	@Override
	public void trans(Coupon coupon) {
		System.out.println("채팅으로 쿠폰 전송");
	}
}
