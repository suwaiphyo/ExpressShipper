package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CargoParam {

    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("height")
    @Expose
    private Integer height;


    public CargoParam() {
    }

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
        return quantity;
    }

    /**
     * @param qty The qty
     */
    public void setQty(Integer qty) {
        this.quantity = qty;
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
        return unit;
    }

    /**
     * @param unite The unite
     */
    public void setUnite(String unite) {
        this.unit = unite;
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
     * @return The length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * @param length The length
     */
    public void setLength(Integer length) {
        this.length = length;
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

    @Override
    public String toString() {
        return "{" +
                "\"item_name\":\"" + itemName + '\"' +
                ",\"quantity\":" + quantity +
                ",\"weight\":" + weight +
                ",\"unit\":\"" + unit + '\"' +
                ",\"width\":" + width +
                ",\"length\":" + length +
                ",\"height\":" + height +
                "}";
    }
}
