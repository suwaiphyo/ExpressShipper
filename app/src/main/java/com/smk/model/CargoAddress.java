package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CargoAddress {

    @SerializedName("shipper_id")
    @Expose
    private Integer shipperId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city_id")
    @Expose
    private String cityId;
    @SerializedName("township_id")
    @Expose
    private String townshipId;
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
     * @return The address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return The cityId
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * @param cityId The city_id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * @return The townshipId
     */
    public String getTownshipId() {
        return townshipId;
    }

    /**
     * @param townshipId The township_id
     */
    public void setTownshipId(String townshipId) {
        this.townshipId = townshipId;
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