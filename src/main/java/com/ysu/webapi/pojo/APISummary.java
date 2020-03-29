package com.ysu.webapi.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;
public class APISummary {
    //    API详细内容的id
    private int id;
    //    对应的APIId
    private int APIId;
    //    对应的APIVersionsId

    private int APIVersionsId;
    //    API端点 API Endpoint

    private String Endpoint;
    //    API门户/主页 API Portal / Home Page

    private String Portal;
    //    主要类别 Primary Category

    private String PrimaryCategory;
    //    次要类别 Secondary Categories

    private String SecondaryCategories;
    //    API提供商 API Provider

    private String APIProvider;
    //    SSL支持 SSL Support

    private String SSLSupport;
    //    API论坛/留言板 API Forum / Message Boards

    private String APIForum;
    //    Twitter URL Twitter URL

    private String TwitterURL;
    //    支持电子邮件地址 Support Email Address

    private String SupportEmailAddress;
    //    交互式控制台URL Interactive Console URL

    private String InteractiveConsoleURL;
    //    身份验证模型 Authentication Model

    private String AuthenticationModel;
    //    版本状态 Version status

    private String VersionStatus;
    //    API设计/说明是否专有？ Is the API Design/Description Non-Proprietary ?

    private String APIDesign;
    //    范围 Scope

    private String Scope;
    //    设备特定 Device Specific

    private String DeviceSpecific;
    //    文件首页网址 Docs Home Page URL

    private String DocsHomePageURL;
    //    建筑风格 Architectural Style

    private String ArchitecturalStyle;
    //    支持的请求格式 Supported Request Formats

    private String SupportedRequestFormats;
    //    支持的响应格式 Supported Response Formats

    private String SupportedResponseFormats;
    //    这是非官方的API吗？Is This an Unofficial API?

    private String UnofficialAPI;
    //    这是Hypermedia API吗？Is This a Hypermedia API?

    private String HypermediaAPI;
    //    限制访问（需要供应商认证）Restricted Access ( Requires Provider Approval )

    private String RestrictedAccess;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty(value = "APIId")
    public int getAPIId() {
        return APIId;
    }

    public void setAPIId(int APIId) {
        this.APIId = APIId;
    }

    @JsonProperty(value = "Endpoint")
    public String getEndpoint() {
        return Endpoint;
    }

    public void setEndpoint(String endpoint) {
        Endpoint = endpoint;
    }
    @JsonProperty(value = "Portal")
    public String getPortal() {
        return Portal;
    }

    public void setPortal(String portal) {
        Portal = portal;
    }
    @JsonProperty(value = "PrimaryCategory")
    public String getPrimaryCategory() {
        return PrimaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        PrimaryCategory = primaryCategory;
    }
    @JsonProperty(value = "SecondaryCategories")
    public String getSecondaryCategories() {
        return SecondaryCategories;
    }

    public void setSecondaryCategories(String secondaryCategories) {
        SecondaryCategories = secondaryCategories;
    }
    @JsonProperty(value = "APIProvider")
    public String getAPIProvider() {
        return APIProvider;
    }

    public void setAPIProvider(String APIProvider) {
        this.APIProvider = APIProvider;
    }
    @JsonProperty(value = "SSLSupport")
    public String getSSLSupport() {
        return SSLSupport;
    }

    public void setSSLSupport(String SSLSupport) {
        this.SSLSupport = SSLSupport;
    }
    @JsonProperty(value = "APIForum")
    public String getAPIForum() {
        return APIForum;
    }

    public void setAPIForum(String APIForum) {
        this.APIForum = APIForum;
    }
    @JsonProperty(value = "TwitterURL")
    public String getTwitterURL() {
        return TwitterURL;
    }

    public void setTwitterURL(String twitterURL) {
        TwitterURL = twitterURL;
    }
    @JsonProperty(value = "SupportEmailAddress")
    public String getSupportEmailAddress() {
        return SupportEmailAddress;
    }

    public void setSupportEmailAddress(String supportEmailAddress) {
        SupportEmailAddress = supportEmailAddress;
    }
    @JsonProperty(value = "InteractiveConsoleURL")
    public String getInteractiveConsoleURL() {
        return InteractiveConsoleURL;
    }

    public void setInteractiveConsoleURL(String interactiveConsoleURL) {
        InteractiveConsoleURL = interactiveConsoleURL;
    }
    @JsonProperty(value = "AuthenticationModel")
    public String getAuthenticationModel() {
        return AuthenticationModel;
    }

    public void setAuthenticationModel(String authenticationModel) {
        AuthenticationModel = authenticationModel;
    }
    @JsonProperty(value = "VersionStatus")
    public String getVersionStatus() {
        return VersionStatus;
    }

    public void setVersionStatus(String versionStatus) {
        VersionStatus = versionStatus;
    }
    @JsonProperty(value = "APIDesign")
    public String getAPIDesign() {
        return APIDesign;
    }

    public void setAPIDesign(String APIDesign) {
        this.APIDesign = APIDesign;
    }
    @JsonProperty(value = "Scope")
    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }
    @JsonProperty(value = "DeviceSpecific")
    public String getDeviceSpecific() {
        return DeviceSpecific;
    }

    public void setDeviceSpecific(String deviceSpecific) {
        DeviceSpecific = deviceSpecific;
    }
    @JsonProperty(value = "DocsHomePageURL")
    public String getDocsHomePageURL() {
        return DocsHomePageURL;
    }

    public void setDocsHomePageURL(String docsHomePageURL) {
        DocsHomePageURL = docsHomePageURL;
    }
    @JsonProperty(value = "ArchitecturalStyle")
    public String getArchitecturalStyle() {
        return ArchitecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        ArchitecturalStyle = architecturalStyle;
    }
    @JsonProperty(value = "SupportedRequestFormats")
    public String getSupportedRequestFormats() {
        return SupportedRequestFormats;
    }

    public void setSupportedRequestFormats(String supportedRequestFormats) {
        SupportedRequestFormats = supportedRequestFormats;
    }
    @JsonProperty(value = "SupportedResponseFormats")
    public String getSupportedResponseFormats() {
        return SupportedResponseFormats;
    }

    public void setSupportedResponseFormats(String supportedResponseFormats) {
        SupportedResponseFormats = supportedResponseFormats;
    }
    @JsonProperty(value = "UnofficialAPI")
    public String getUnofficialAPI() {
        return UnofficialAPI;
    }

    public void setUnofficialAPI(String unofficialAPI) {
        UnofficialAPI = unofficialAPI;
    }
    @JsonProperty(value = "HypermediaAPI")
    public String getHypermediaAPI() {
        return HypermediaAPI;
    }

    public void setHypermediaAPI(String hypermediaAPI) {
        HypermediaAPI = hypermediaAPI;
    }
    @JsonProperty(value = "RestrictedAccess")
    public String getRestrictedAccess() {
        return RestrictedAccess;
    }

    public void setRestrictedAccess(String restrictedAccess) {
        RestrictedAccess = restrictedAccess;
    }
    @JsonProperty(value = "APIVersionsId")
    public int getAPIVersionsId() {
        return APIVersionsId;
    }

    public void setAPIVersionsId(int APIVersionsId) {
        this.APIVersionsId = APIVersionsId;
    }
}
