package cn.huas.xueshe.bean;


public class Goods {

    private long goodsId;
    private String goodsTitle;
    private String goodsOriginal;
    private String goodsPrice;
    private String goodsDetail;
    private long goodsAccount;
    private java.sql.Timestamp goodsDate;
    private long userId;
    private String goodSale;
    private String goodsQq;
    private String goodTel;


    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }


    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }


    public String getGoodsOriginal() {
        return goodsOriginal;
    }

    public void setGoodsOriginal(String goodsOriginal) {
        this.goodsOriginal = goodsOriginal;
    }


    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }


    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }


    public long getGoodsAccount() {
        return goodsAccount;
    }

    public void setGoodsAccount(long goodsAccount) {
        this.goodsAccount = goodsAccount;
    }


    public java.sql.Timestamp getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(java.sql.Timestamp goodsDate) {
        this.goodsDate = goodsDate;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public String getGoodSale() {
        return goodSale;
    }

    public void setGoodSale(String goodSale) {
        this.goodSale = goodSale;
    }


    public String getGoodsQq() {
        return goodsQq;
    }

    public void setGoodsQq(String goodsQq) {
        this.goodsQq = goodsQq;
    }


    public String getGoodTel() {
        return goodTel;
    }

    public void setGoodTel(String goodTel) {
        this.goodTel = goodTel;
    }

}
