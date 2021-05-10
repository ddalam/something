package com.example.Something.synchronization;

public class Point {

	public void consumePoint() {

		long point = MemberPoint.point;

		point -= 1;

		MemberPoint.point = point;

		System.out.println(MemberPoint.point);
	}
}
