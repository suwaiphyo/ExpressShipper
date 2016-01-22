package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shippingdetail {

    @SerializedName("shipping_transaction_id")
    @Expose
    private Integer shippingTransactionId;
    @SerializedName("cargo_id")
    @Expose
    private Integer cargoId;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * @return The shippingTransactionId
     */
    public Integer getShippingTransactionId() {
        return shippingTransactionId;
    }

    /**
     * @param shippingTransactionId The shipping_transaction_id
     */
    public void setShippingTransactionId(Integer shippingTransactionId) {
        this.shippingTransactionId = shippingTransactionId;
    }

    /**
     * @return The cargoId
     */
    public Integer getCargoId() {
        return cargoId;
    }

    /**
     * @param cargoId The cargo_id
     */
    public void setCargoId(Integer cargoId) {
        this.cargoId = cargoId;
    }

    /**
     * @return The cost
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * @param cost The cost
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

}