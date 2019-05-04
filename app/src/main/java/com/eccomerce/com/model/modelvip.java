package com.eccomerce.com.model;

public class modelvip {
    String id,name,price,priceold,number,shopid,image,image1,image2,image3,skidka,content;

    public modelvip(String id, String name, String price, String priceold, String number, String shopid, String image, String image1,
                    String image2, String image3, String skidka,String content) {
        this.content=content;
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceold = priceold;
        this.number = number;
        this.shopid = shopid;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.skidka = skidka;
    }

    public modelvip() {
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPriceold() {
        return priceold;
    }

    public String getNumber() {
        return number;
    }

    public String getShopid() {
        return shopid;
    }

    public String getImage() {
        return image;
    }

    public String getImage1() {
        return image1;
    }

    public String getImage2() {
        return image2;
    }

    public String getImage3() {
        return image3;
    }

    public String getSkidka() {
        return skidka;
    }
}
