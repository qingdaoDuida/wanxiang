package com.huahai.wanxiang.dao.domain;

import java.math.BigDecimal;

/**
 * query for table article_info
 * @author haofuwei
 * @date Wed Jul 06 18:15:58 CST 2022
 */
public class ArticleInfoDO {
    private Long id;

    private String articleName;

    private String category;

    private String articleSourceUrl;

    private String sourceCompany;

    private String coverVideo;

    private String shopeeId;

    private BigDecimal weight;

    private BigDecimal originalPrice;

    private String articleStatus;

    private Integer normalStock;

    private String articleCondition;

    private Integer articleDangerous;

    private Long tenantId;

    private String articleDesc;

    private String articlePhoto;

    private String dimension;

    private String logisticInfo;

    private String preOrder;

    private String wholesale;

    private String taxInfo;

    private String complaintPolicy;

    private String attributeList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getArticleSourceUrl() {
        return articleSourceUrl;
    }

    public void setArticleSourceUrl(String articleSourceUrl) {
        this.articleSourceUrl = articleSourceUrl == null ? null : articleSourceUrl.trim();
    }

    public String getSourceCompany() {
        return sourceCompany;
    }

    public void setSourceCompany(String sourceCompany) {
        this.sourceCompany = sourceCompany == null ? null : sourceCompany.trim();
    }

    public String getCoverVideo() {
        return coverVideo;
    }

    public void setCoverVideo(String coverVideo) {
        this.coverVideo = coverVideo == null ? null : coverVideo.trim();
    }

    public String getShopeeId() {
        return shopeeId;
    }

    public void setShopeeId(String shopeeId) {
        this.shopeeId = shopeeId == null ? null : shopeeId.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus == null ? null : articleStatus.trim();
    }

    public Integer getNormalStock() {
        return normalStock;
    }

    public void setNormalStock(Integer normalStock) {
        this.normalStock = normalStock;
    }

    public String getArticleCondition() {
        return articleCondition;
    }

    public void setArticleCondition(String articleCondition) {
        this.articleCondition = articleCondition == null ? null : articleCondition.trim();
    }

    public Integer getArticleDangerous() {
        return articleDangerous;
    }

    public void setArticleDangerous(Integer articleDangerous) {
        this.articleDangerous = articleDangerous;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc == null ? null : articleDesc.trim();
    }

    public String getArticlePhoto() {
        return articlePhoto;
    }

    public void setArticlePhoto(String articlePhoto) {
        this.articlePhoto = articlePhoto == null ? null : articlePhoto.trim();
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension == null ? null : dimension.trim();
    }

    public String getLogisticInfo() {
        return logisticInfo;
    }

    public void setLogisticInfo(String logisticInfo) {
        this.logisticInfo = logisticInfo == null ? null : logisticInfo.trim();
    }

    public String getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(String preOrder) {
        this.preOrder = preOrder == null ? null : preOrder.trim();
    }

    public String getWholesale() {
        return wholesale;
    }

    public void setWholesale(String wholesale) {
        this.wholesale = wholesale == null ? null : wholesale.trim();
    }

    public String getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(String taxInfo) {
        this.taxInfo = taxInfo == null ? null : taxInfo.trim();
    }

    public String getComplaintPolicy() {
        return complaintPolicy;
    }

    public void setComplaintPolicy(String complaintPolicy) {
        this.complaintPolicy = complaintPolicy == null ? null : complaintPolicy.trim();
    }

    public String getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList == null ? null : attributeList.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleName=").append(articleName);
        sb.append(", category=").append(category);
        sb.append(", articleSourceUrl=").append(articleSourceUrl);
        sb.append(", sourceCompany=").append(sourceCompany);
        sb.append(", coverVideo=").append(coverVideo);
        sb.append(", shopeeId=").append(shopeeId);
        sb.append(", weight=").append(weight);
        sb.append(", originalPrice=").append(originalPrice);
        sb.append(", articleStatus=").append(articleStatus);
        sb.append(", normalStock=").append(normalStock);
        sb.append(", articleCondition=").append(articleCondition);
        sb.append(", articleDangerous=").append(articleDangerous);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", articleDesc=").append(articleDesc);
        sb.append(", articlePhoto=").append(articlePhoto);
        sb.append(", dimension=").append(dimension);
        sb.append(", logisticInfo=").append(logisticInfo);
        sb.append(", preOrder=").append(preOrder);
        sb.append(", wholesale=").append(wholesale);
        sb.append(", taxInfo=").append(taxInfo);
        sb.append(", complaintPolicy=").append(complaintPolicy);
        sb.append(", attributeList=").append(attributeList);
        sb.append("]");
        return sb.toString();
    }
}