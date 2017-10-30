
package com.oscar.rxjavahelloworld.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("elapsedMS")
    @Expose
    private Integer elapsedMS;
    @SerializedName("warning")
    @Expose
    private Object warning;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getElapsedMS() {
        return elapsedMS;
    }

    public void setElapsedMS(Integer elapsedMS) {
        this.elapsedMS = elapsedMS;
    }

    public Object getWarning() {
        return warning;
    }

    public void setWarning(Object warning) {
        this.warning = warning;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

}
