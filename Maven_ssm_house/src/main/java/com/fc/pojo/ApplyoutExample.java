package com.fc.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApplyoutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplyoutExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAoidIsNull() {
            addCriterion("aoid is null");
            return (Criteria) this;
        }

        public Criteria andAoidIsNotNull() {
            addCriterion("aoid is not null");
            return (Criteria) this;
        }

        public Criteria andAoidEqualTo(Integer value) {
            addCriterion("aoid =", value, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidNotEqualTo(Integer value) {
            addCriterion("aoid <>", value, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidGreaterThan(Integer value) {
            addCriterion("aoid >", value, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aoid >=", value, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidLessThan(Integer value) {
            addCriterion("aoid <", value, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidLessThanOrEqualTo(Integer value) {
            addCriterion("aoid <=", value, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidIn(List<Integer> values) {
            addCriterion("aoid in", values, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidNotIn(List<Integer> values) {
            addCriterion("aoid not in", values, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidBetween(Integer value1, Integer value2) {
            addCriterion("aoid between", value1, value2, "aoid");
            return (Criteria) this;
        }

        public Criteria andAoidNotBetween(Integer value1, Integer value2) {
            addCriterion("aoid not between", value1, value2, "aoid");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("house_id =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("house_id <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("house_id >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_id >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("house_id <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("house_id <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("house_id in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("house_id not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("house_id between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("house_id not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdIsNull() {
            addCriterion("userlist_id is null");
            return (Criteria) this;
        }

        public Criteria andUserlistIdIsNotNull() {
            addCriterion("userlist_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserlistIdEqualTo(Integer value) {
            addCriterion("userlist_id =", value, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdNotEqualTo(Integer value) {
            addCriterion("userlist_id <>", value, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdGreaterThan(Integer value) {
            addCriterion("userlist_id >", value, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("userlist_id >=", value, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdLessThan(Integer value) {
            addCriterion("userlist_id <", value, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdLessThanOrEqualTo(Integer value) {
            addCriterion("userlist_id <=", value, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdIn(List<Integer> values) {
            addCriterion("userlist_id in", values, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdNotIn(List<Integer> values) {
            addCriterion("userlist_id not in", values, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdBetween(Integer value1, Integer value2) {
            addCriterion("userlist_id between", value1, value2, "userlistId");
            return (Criteria) this;
        }

        public Criteria andUserlistIdNotBetween(Integer value1, Integer value2) {
            addCriterion("userlist_id not between", value1, value2, "userlistId");
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