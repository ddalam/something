package com.example.Something.pattern.adapter;

public class AdapterMain {

    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        // Cleaner는 220v인데, connect()는 110v만 가능하기 때문에 11 line에서 에러가 발생한다
        // connect(cleaner);

        // 110v 어댑터에 220v 가전제품을 연결
        Electronic110V cleanerAdapter = new Adapter(cleaner);
        // 어탭터를 통해 Cleaner를 연결
        connect(cleanerAdapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airConditionerAdapter = new Adapter(airConditioner);
        connect(airConditionerAdapter);
    }

    // 110v 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
