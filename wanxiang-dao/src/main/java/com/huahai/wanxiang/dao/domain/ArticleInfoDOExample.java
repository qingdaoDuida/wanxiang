package com.huahai.wanxiang.dao.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * query for table article_info
 * @author haofuwei
 * @date Wed Jul 06 18:15:58 CST 2022
 */
public class ArticleInfoDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleInfoDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNull() {
            addCriterion("article_name is null");
            return (Criteria) this;
        }

        public Criteria andArticleNameIsNotNull() {
            addCriterion("article_name is not null");
            return (Criteria) this;
        }

        public Criteria andArticleNameEqualTo(String value) {
            addCriterion("article_name =", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotEqualTo(String value) {
            addCriterion("article_name <>", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThan(String value) {
            addCriterion("article_name >", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameGreaterThanOrEqualTo(String value) {
            addCriterion("article_name >=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThan(String value) {
            addCriterion("article_name <", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLessThanOrEqualTo(String value) {
            addCriterion("article_name <=", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameLike(String value) {
            addCriterion("article_name like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotLike(String value) {
            addCriterion("article_name not like", value, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameIn(List<String> values) {
            addCriterion("article_name in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotIn(List<String> values) {
            addCriterion("article_name not in", values, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameBetween(String value1, String value2) {
            addCriterion("article_name between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andArticleNameNotBetween(String value1, String value2) {
            addCriterion("article_name not between", value1, value2, "articleName");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlIsNull() {
            addCriterion("article_source_url is null");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlIsNotNull() {
            addCriterion("article_source_url is not null");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlEqualTo(String value) {
            addCriterion("article_source_url =", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlNotEqualTo(String value) {
            addCriterion("article_source_url <>", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlGreaterThan(String value) {
            addCriterion("article_source_url >", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("article_source_url >=", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlLessThan(String value) {
            addCriterion("article_source_url <", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlLessThanOrEqualTo(String value) {
            addCriterion("article_source_url <=", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlLike(String value) {
            addCriterion("article_source_url like", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlNotLike(String value) {
            addCriterion("article_source_url not like", value, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlIn(List<String> values) {
            addCriterion("article_source_url in", values, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlNotIn(List<String> values) {
            addCriterion("article_source_url not in", values, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlBetween(String value1, String value2) {
            addCriterion("article_source_url between", value1, value2, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andArticleSourceUrlNotBetween(String value1, String value2) {
            addCriterion("article_source_url not between", value1, value2, "articleSourceUrl");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyIsNull() {
            addCriterion("source_company is null");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyIsNotNull() {
            addCriterion("source_company is not null");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyEqualTo(String value) {
            addCriterion("source_company =", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyNotEqualTo(String value) {
            addCriterion("source_company <>", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyGreaterThan(String value) {
            addCriterion("source_company >", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("source_company >=", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyLessThan(String value) {
            addCriterion("source_company <", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyLessThanOrEqualTo(String value) {
            addCriterion("source_company <=", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyLike(String value) {
            addCriterion("source_company like", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyNotLike(String value) {
            addCriterion("source_company not like", value, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyIn(List<String> values) {
            addCriterion("source_company in", values, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyNotIn(List<String> values) {
            addCriterion("source_company not in", values, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyBetween(String value1, String value2) {
            addCriterion("source_company between", value1, value2, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andSourceCompanyNotBetween(String value1, String value2) {
            addCriterion("source_company not between", value1, value2, "sourceCompany");
            return (Criteria) this;
        }

        public Criteria andCoverVideoIsNull() {
            addCriterion("cover_video is null");
            return (Criteria) this;
        }

        public Criteria andCoverVideoIsNotNull() {
            addCriterion("cover_video is not null");
            return (Criteria) this;
        }

        public Criteria andCoverVideoEqualTo(String value) {
            addCriterion("cover_video =", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoNotEqualTo(String value) {
            addCriterion("cover_video <>", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoGreaterThan(String value) {
            addCriterion("cover_video >", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoGreaterThanOrEqualTo(String value) {
            addCriterion("cover_video >=", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoLessThan(String value) {
            addCriterion("cover_video <", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoLessThanOrEqualTo(String value) {
            addCriterion("cover_video <=", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoLike(String value) {
            addCriterion("cover_video like", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoNotLike(String value) {
            addCriterion("cover_video not like", value, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoIn(List<String> values) {
            addCriterion("cover_video in", values, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoNotIn(List<String> values) {
            addCriterion("cover_video not in", values, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoBetween(String value1, String value2) {
            addCriterion("cover_video between", value1, value2, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andCoverVideoNotBetween(String value1, String value2) {
            addCriterion("cover_video not between", value1, value2, "coverVideo");
            return (Criteria) this;
        }

        public Criteria andShopeeIdIsNull() {
            addCriterion("shopee_id is null");
            return (Criteria) this;
        }

        public Criteria andShopeeIdIsNotNull() {
            addCriterion("shopee_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopeeIdEqualTo(String value) {
            addCriterion("shopee_id =", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdNotEqualTo(String value) {
            addCriterion("shopee_id <>", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdGreaterThan(String value) {
            addCriterion("shopee_id >", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("shopee_id >=", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdLessThan(String value) {
            addCriterion("shopee_id <", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdLessThanOrEqualTo(String value) {
            addCriterion("shopee_id <=", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdLike(String value) {
            addCriterion("shopee_id like", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdNotLike(String value) {
            addCriterion("shopee_id not like", value, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdIn(List<String> values) {
            addCriterion("shopee_id in", values, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdNotIn(List<String> values) {
            addCriterion("shopee_id not in", values, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdBetween(String value1, String value2) {
            addCriterion("shopee_id between", value1, value2, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andShopeeIdNotBetween(String value1, String value2) {
            addCriterion("shopee_id not between", value1, value2, "shopeeId");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNull() {
            addCriterion("original_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIsNotNull() {
            addCriterion("original_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceEqualTo(BigDecimal value) {
            addCriterion("original_price =", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotEqualTo(BigDecimal value) {
            addCriterion("original_price <>", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThan(BigDecimal value) {
            addCriterion("original_price >", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price >=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThan(BigDecimal value) {
            addCriterion("original_price <", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("original_price <=", value, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceIn(List<BigDecimal> values) {
            addCriterion("original_price in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotIn(List<BigDecimal> values) {
            addCriterion("original_price not in", values, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andOriginalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("original_price not between", value1, value2, "originalPrice");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNull() {
            addCriterion("article_status is null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIsNotNull() {
            addCriterion("article_status is not null");
            return (Criteria) this;
        }

        public Criteria andArticleStatusEqualTo(String value) {
            addCriterion("article_status =", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotEqualTo(String value) {
            addCriterion("article_status <>", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThan(String value) {
            addCriterion("article_status >", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("article_status >=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThan(String value) {
            addCriterion("article_status <", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLessThanOrEqualTo(String value) {
            addCriterion("article_status <=", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusLike(String value) {
            addCriterion("article_status like", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotLike(String value) {
            addCriterion("article_status not like", value, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusIn(List<String> values) {
            addCriterion("article_status in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotIn(List<String> values) {
            addCriterion("article_status not in", values, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusBetween(String value1, String value2) {
            addCriterion("article_status between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andArticleStatusNotBetween(String value1, String value2) {
            addCriterion("article_status not between", value1, value2, "articleStatus");
            return (Criteria) this;
        }

        public Criteria andNormalStockIsNull() {
            addCriterion("normal_stock is null");
            return (Criteria) this;
        }

        public Criteria andNormalStockIsNotNull() {
            addCriterion("normal_stock is not null");
            return (Criteria) this;
        }

        public Criteria andNormalStockEqualTo(Integer value) {
            addCriterion("normal_stock =", value, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockNotEqualTo(Integer value) {
            addCriterion("normal_stock <>", value, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockGreaterThan(Integer value) {
            addCriterion("normal_stock >", value, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("normal_stock >=", value, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockLessThan(Integer value) {
            addCriterion("normal_stock <", value, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockLessThanOrEqualTo(Integer value) {
            addCriterion("normal_stock <=", value, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockIn(List<Integer> values) {
            addCriterion("normal_stock in", values, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockNotIn(List<Integer> values) {
            addCriterion("normal_stock not in", values, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockBetween(Integer value1, Integer value2) {
            addCriterion("normal_stock between", value1, value2, "normalStock");
            return (Criteria) this;
        }

        public Criteria andNormalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("normal_stock not between", value1, value2, "normalStock");
            return (Criteria) this;
        }

        public Criteria andArticleConditionIsNull() {
            addCriterion("article_condition is null");
            return (Criteria) this;
        }

        public Criteria andArticleConditionIsNotNull() {
            addCriterion("article_condition is not null");
            return (Criteria) this;
        }

        public Criteria andArticleConditionEqualTo(String value) {
            addCriterion("article_condition =", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionNotEqualTo(String value) {
            addCriterion("article_condition <>", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionGreaterThan(String value) {
            addCriterion("article_condition >", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionGreaterThanOrEqualTo(String value) {
            addCriterion("article_condition >=", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionLessThan(String value) {
            addCriterion("article_condition <", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionLessThanOrEqualTo(String value) {
            addCriterion("article_condition <=", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionLike(String value) {
            addCriterion("article_condition like", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionNotLike(String value) {
            addCriterion("article_condition not like", value, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionIn(List<String> values) {
            addCriterion("article_condition in", values, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionNotIn(List<String> values) {
            addCriterion("article_condition not in", values, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionBetween(String value1, String value2) {
            addCriterion("article_condition between", value1, value2, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleConditionNotBetween(String value1, String value2) {
            addCriterion("article_condition not between", value1, value2, "articleCondition");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousIsNull() {
            addCriterion("article_dangerous is null");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousIsNotNull() {
            addCriterion("article_dangerous is not null");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousEqualTo(Integer value) {
            addCriterion("article_dangerous =", value, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousNotEqualTo(Integer value) {
            addCriterion("article_dangerous <>", value, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousGreaterThan(Integer value) {
            addCriterion("article_dangerous >", value, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousGreaterThanOrEqualTo(Integer value) {
            addCriterion("article_dangerous >=", value, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousLessThan(Integer value) {
            addCriterion("article_dangerous <", value, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousLessThanOrEqualTo(Integer value) {
            addCriterion("article_dangerous <=", value, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousIn(List<Integer> values) {
            addCriterion("article_dangerous in", values, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousNotIn(List<Integer> values) {
            addCriterion("article_dangerous not in", values, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousBetween(Integer value1, Integer value2) {
            addCriterion("article_dangerous between", value1, value2, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andArticleDangerousNotBetween(Integer value1, Integer value2) {
            addCriterion("article_dangerous not between", value1, value2, "articleDangerous");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}