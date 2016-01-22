package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShippingTransaction {

    @SerializedName("shipper_id")
    @Expose
    private Integer shipperId;
    @SerializedName("shipping_information_id")
    @Expose
    private Integer shippingInformationId;
    @SerializedName("cargo_address_id")
    @Expose
    private Integer cargoAddressId;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("total_cost")
    @Expose
    private Integer totalCost;

    /**
     * @return The shipperId
     */
    public Integer getShipperId() {
        return shipperId;
    }

    /**
     * @param shipperId The shipper_id
     */
    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    /**
     * @return The shippingInformationId
     */
    public Integer getShippingInformationId() {
        return shippingInformationId;
    }

    /**
     * @param shippingInformationId The shipping_information_id
     */
    public void setShippingInformationId(Integer shippingInformationId) {
        this.shippingInformationId = shippingInformationId;
    }

    /**
     * @return The cargoAddressId
     */
    public Integer getCargoAddressId() {
        return cargoAddressId;
    }

    /**
     * @param cargoAddressId The cargo_address_id
     */
    public void setCargoAddressId(Integer cargoAddressId) {
        this.cargoAddressId = cargoAddressId;
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

    /**
     * @return The totalCost
     */
    public Integer getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost The total_cost
     */
    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

}