package com.example.Something.strategy.behaviorParameterization;

public class CouponTransMain {

	public static void main(String[] args) {
		Coupon coupon = new Coupon(1, "12AC00");

		// 인터페이스를 사용해 동적 파라미터화 코드 전달하기
		Coupon.sendCoupon(coupon, new ChatCouponTrans());

		// 익명 클래스를 사용해 동적 파라미터화 코드 전달하기
		Coupon.sendCoupon(coupon, new CouponTrans() {
			@Override
			public void trans(Coupon coupon) {
				System.out.println("알림톡으로 쿠폰 발송");
			}
		});
	}
}
