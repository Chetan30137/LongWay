package com.example.item_cart;

public class Product {
    private String iname,idescreption,inumber,iweight,iquantity,icost;

    public Product(String iname, String idescreption, String inumb, String iweight, String iquantity, String icost) {
        this.iname = iname;
        this.idescreption = idescreption;
        this.inumber = inumb;
        this.iweight = iweight;
        this.iquantity = iquantity;
        this.icost = icost;
    }

    public Product(String iname, String iquantity, String icost) {
        this.iname = iname;
        this.iquantity = iquantity;
        this.icost = icost;
    }

    public Product(){

    }
    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public String getIdescreption() {
        return idescreption;
    }

    public void setIdescreption(String idescreption) {
        this.idescreption = idescreption;
    }

    public String getInumber() {
        return inumber;
    }

    public void setInumber(String inumb) {
        this.inumber = inumb;
    }

    public String getIweight() {
        return iweight;
    }

    public void setIweight(String iweight) {
        this.iweight = iweight;
    }

    public String getIquantity() {
        return iquantity;
    }

    public void setIquantity(String iquantity) {
        this.iquantity = iquantity;
    }

    public String getIcost() {
        return icost;
    }

    public void setIcost(String icost) {
        this.icost = icost;
    }
}
