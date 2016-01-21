package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ShippingParam {

    @SerializedName("shipper_id")
    @Expose
    private Integer shipperId;
    @SerializedName("cargo_address")
    @Expose
    private String cargoAddress;
    @SerializedName("cargo_city_id")
    @Expose
    private Integer cargoCityId;
    @SerializedName("cargo_township_id")
    @Expose
    private Integer cargoTownshipId;
    @SerializedName("shipping_name")
    @Expose
    private String shippingName;
    @SerializedName("shipping_email")
    @Expose
    private String shippingEmail;
    @SerializedName("shipping_phone")
    @Expose
    private String shippingPhone;
    @SerializedName("shipping_address")
    @Expose
    private String shippingAddress;
    @SerializedName("shipping_city_id")
    @Expose
    private Integer shippingCityId;
    @SerializedName("shipping_township_id")
    @Expose
    private Integer shippingTownshipId;
    @SerializedName("cargo")
    @Expose
    private List<CargoParam> cargo = new ArrayList<CargoParam>();
    @SerializedName("delivery_company_id")
    @Expose
    private Integer deliveryCompanyId;

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
     * @return The cargoAddress
     */
    public String getCargoAddress() {
        return cargoAddress;
    }

    /**
     * @param cargoAddress The cargo_address
     */
    public void setCargoAddress(String cargoAddress) {
        this.cargoAddress = cargoAddress;
    }

    /**
     * @return The cargoCityId
     */
    public Integer getCargoCityId() {
        return cargoCityId;
    }

    /**
     * @param cargoCityId The cargo_city_id
     */
    public void setCargoCityId(Integer cargoCityId) {
        this.cargoCityId = cargoCityId;
    }

    /**
     * @return The cargoTownshipId
     */
    public Integer getCargoTownshipId() {
        return cargoTownshipId;
    }

    /**
     * @param cargoTownshipId The cargo_township_id
     */
    public void setCargoTownshipId(Integer cargoTownshipId) {
        this.cargoTownshipId = cargoTownshipId;
    }

    /**
     * @return The shippingName
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * @param shippingName The shipping_name
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    /**
     * @return The shippingEmail
     */
    public String getShippingEmail() {
        return shippingEmail;
    }

    /**
     * @param shippingEmail The shipping_email
     */
    public void setShippingEmail(String shippingEmail) {
        this.shippingEmail = shippingEmail;
    }

    /**
     * @return The shippingPhone
     */
    public String getShippingPhone() {
        return shippingPhone;
    }

    /**
     * @param shippingPhone The shipping_phone
     */
    public void setShippingPhone(String shippingPhone) {
        this.shippingPhone = shippingPhone;
    }

    /**
     * @return The shippingAddress
     */
    public String getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @param shippingAddress The shipping_address
     */
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * @return The shippingCityId
     */
    public Integer getShippingCityId() {
        return shippingCityId;
    }

    /**
     * @param shippingCityId The shipping_city_id
     */
    public void setShippingCityId(Integer shippingCityId) {
        this.shippingCityId = shippingCityId;
    }

    /**
     * @return The shippingTownshipId
     */
    public Integer getShippingTownshipId() {
        return shippingTownshipId;
    }

    /**
     * @param shippingTownshipId The shipping_township_id
     */
    public void setShippingTownshipId(Integer shippingTownshipId) {
        this.shippingTownshipId = shippingTownshipId;
    }

    /**
     * @return The cargo
     */
    public List<CargoParam> getCargo() {
        return cargo;
    }

    /**
     * @param cargo The cargo
     */
    public void setCargo(List<CargoParam> cargo) {
        this.cargo = cargo;
    }

    /**
     * @return The deliveryCompanyId
     */
    public Integer getDeliveryCompanyId() {
        return deliveryCompanyId;
    }

    /**
     * @param deliveryCompanyId The delivery_company_id
     */
    public void setDeliveryCompanyId(Integer deliveryCompanyId) {
        this.deliveryCompanyId = deliveryCompanyId;
    }
}
