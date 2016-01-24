package com.smk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("paid_date")
    @Expose
    private String paidDate;
    @SerializedName("received_date")
    @Expose
    private String receivedDate;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("client_id")
    @Expose
    private String clientId;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("vendor")
    @Expose
    private User vendor;
    @SerializedName("client")
    @Expose
    private User client;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The paidDate
     */
    public String getPaidDate() {
        return paidDate;
    }

    /**
     *
     * @param paidDate
     * The paid_date
     */
    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    /**
     *
     * @return
     * The receivedDate
     */
    public String getReceivedDate() {
        return receivedDate;
    }

    /**
     *
     * @param receivedDate
     * The received_date
     */
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     *
     * @return
     * The vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     *
     * @param vendorId
     * The vendor_id
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     *
     * @return
     * The clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     *
     * @param clientId
     * The client_id
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     *
     * @return
     * The amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     *
     * @param amount
     * The amount
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     *
     * @return
     * The status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The vendor
     */
    public User getVendor() {
        return vendor;
    }

    /**
     *
     * @param vendor
     * The vendor
     */
    public void setVendor(User vendor) {
        this.vendor = vendor;
    }

    /**
     *
     * @return
     * The client
     */
    public User getClient() {
        return client;
    }

    /**
     *
     * @param client
     * The client
     */
    public void setClient(User client) {
        this.client = client;
    }

}