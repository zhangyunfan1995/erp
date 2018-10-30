package com.yuf.erp.domain;

public class Category {
    private int categoryNo;
    private String category;

    public Category() {
    }

    public Category(int categoryNo, String category) {
        this.categoryNo = categoryNo;
        this.category = category;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryNo=" + categoryNo +
                ", category='" + category + '\'' +
                '}';
    }
}
