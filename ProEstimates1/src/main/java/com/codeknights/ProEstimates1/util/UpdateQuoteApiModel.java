package com.codeknights.ProEstimates1.util;

public class UpdateQuoteApiModel {
     Integer quote_price;
     String user_comments;
     String quote_material;

    public Integer getQuote_price() {
        return this.quote_price;
    }

    public void setQuote_price(Integer quote_price) {
        this.quote_price = quote_price;
    }

    public String getUser_comments() {
        return this.user_comments;
    }

    public void setUser_comments(String user_comments) {
        this.user_comments = user_comments;
    }

    public String getQuote_material() {
        return this.quote_material;
    }

    public void setQuote_material(String quote_material) {
        this.quote_material = quote_material;
    }

}
