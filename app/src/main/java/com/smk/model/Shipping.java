package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Shipping {

    @SerializedName("cargo_address")
    @Expose
    private CargoAddress cargoAddress;
    @SerializedName("shipping_information")
    @Expose
    private ShippingInformation shippingInformation;
    @SerializedName("cargo")
    @Expose
    private List<Cargo> cargo = new ArrayList<Cargo>();
    @SerializedName("shippingdetail")
    @Expose
    private List<Shippingdetail> shippingdetail = new ArrayList<Shippingdetail>();
    @SerializedName("shipping_transaction")
    @Expose
    private ShippingTransaction shippingTransaction;

    /**
     * @return The cargoAddress
     */
    public CargoAddress getCargoAddress() {
        return cargoAddress;
    }

    /**
     * @param cargoAddress The cargo_address
     */
    public void setCargoAddress(CargoAddress cargoAddress) {
        this.cargoAddress = cargoAddress;
    }

    /**
     * @return The shippingInformation
     */
    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    /**
     * @param shippingInformation The shipping_information
     */
    public void setShippingInformation(ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    /**
     * @return The cargo
     */
    public List<Cargo> getCargo() {
        return cargo;
    }

    /**
     * @param cargo The cargo
     */
    public void setCargo(List<Cargo> cargo) {
        this.cargo = cargo;
    }

    /**
     * @return The shippingdetail
     */
    public List<Shippingdetail> getShippingdetail() {
        return shippingdetail;
    }

    /**
     * @param shippingdetail The shippingdetail
     */
    public void setShippingdetail(List<Shippingdetail> shippingdetail) {
        this.shippingdetail = shippingdetail;
    }

    /**
     * @return The shippingTransaction
     */
    public ShippingTransaction getShippingTransaction() {
        return shippingTransaction;
    }

    /**
     * @param shippingTransaction The shipping_transaction
     */
    public void setShippingTransaction(ShippingTransaction shippingTransaction) {
        this.shippingTransaction = shippingTransaction;
    }

}