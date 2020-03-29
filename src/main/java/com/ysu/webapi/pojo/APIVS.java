package com.ysu.webapi.pojo;

public class APIVS {
    private APIVersions apiVersions;
    private APISummary apiSummary;

    public APIVersions getApiVersions() {
        return apiVersions;
    }

    public void setApiVersions(APIVersions apiVersions) {
        this.apiVersions = apiVersions;
    }

    public APISummary getApiSummary() {
        return apiSummary;
    }

    public void setApiSummary(APISummary apiSummary) {
        this.apiSummary = apiSummary;
    }
}
