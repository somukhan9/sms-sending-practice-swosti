
package com.sam;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Sms {

    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("senderid")
    @Expose
    private String senderid;
    @SerializedName("passkey")
    @Expose
    private String passkey;
    @SerializedName("maskingtitle")
    @Expose
    private String maskingtitle;
    @SerializedName("content")
    @Expose
    private Content content;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

    public String getMaskingtitle() {
        return maskingtitle;
    }

    public void setMaskingtitle(String maskingtitle) {
        this.maskingtitle = maskingtitle;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

}
