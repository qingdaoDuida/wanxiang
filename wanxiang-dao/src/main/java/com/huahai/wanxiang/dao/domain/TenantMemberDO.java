package com.huahai.wanxiang.dao.domain;

/**
 * query for table tenant_member
 * @author haofuwei
 * @date Wed Jul 06 18:15:00 CST 2022
 */
public class TenantMemberDO {
    private Long id;

    private Long tenantId;

    private Long userId;

    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", userId=").append(userId);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }
}