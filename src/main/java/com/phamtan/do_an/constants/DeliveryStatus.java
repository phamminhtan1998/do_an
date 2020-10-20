package com.phamtan.do_an.constants;

public enum DeliveryStatus {

    BOOKED(1,"Đơn Hàng Đã Đặt",""),
    VERIFIED(2,"Đã Xác Nhận Thông Tin Thanh Toán",""),
    RECEIVED_SHIPPER(3,"Shipper Đã Nhận Hàng",""),
    DELIVERING(4,"Đang Giao",""),
    FINISHED(5,"Hoàn Thành , Đánh Giá ","");


    private int id ;
    private String name ;
    private String image;

    DeliveryStatus(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
