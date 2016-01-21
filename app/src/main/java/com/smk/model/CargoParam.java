package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CargoParam {

    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("qty")
    @Expose
    private Integer qty;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("unite")
    @Expose
    private String unite;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("lenght")
    @Expose
    private Integer lenght;
    @SerializedName("height")
    @Expose
    private Integer height;

    /**
     * @return The itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName The item_name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return The qty
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * @param qty The qty
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * @return The weight
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * @param weight The weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * @return The unite
     */
    public String getUnite() {
        return unite;
    }

    /**
     * @param unite The unite
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * @return The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return The lenght
     */
    public Integer getLenght() {
        return lenght;
    }

    /**
     * @param lenght The lenght
     */
    public void setLenght(Integer lenght) {
        this.lenght = lenght;
    }

    /**
     * @return The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

}
