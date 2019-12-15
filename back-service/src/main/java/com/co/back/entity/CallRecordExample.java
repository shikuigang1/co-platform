package com.co.back.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CallRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CallRecordExample() {
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

        public Criteria andCall_numberIsNull() {
            addCriterion("call_number is null");
            return (Criteria) this;
        }

        public Criteria andCall_numberIsNotNull() {
            addCriterion("call_number is not null");
            return (Criteria) this;
        }

        public Criteria andCall_numberEqualTo(String value) {
            addCriterion("call_number =", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberNotEqualTo(String value) {
            addCriterion("call_number <>", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberGreaterThan(String value) {
            addCriterion("call_number >", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberGreaterThanOrEqualTo(String value) {
            addCriterion("call_number >=", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberLessThan(String value) {
            addCriterion("call_number <", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberLessThanOrEqualTo(String value) {
            addCriterion("call_number <=", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberLike(String value) {
            addCriterion("call_number like", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberNotLike(String value) {
            addCriterion("call_number not like", value, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberIn(List<String> values) {
            addCriterion("call_number in", values, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberNotIn(List<String> values) {
            addCriterion("call_number not in", values, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberBetween(String value1, String value2) {
            addCriterion("call_number between", value1, value2, "call_number");
            return (Criteria) this;
        }

        public Criteria andCall_numberNotBetween(String value1, String value2) {
            addCriterion("call_number not between", value1, value2, "call_number");
            return (Criteria) this;
        }

        public Criteria andResourceIsNull() {
            addCriterion("resource is null");
            return (Criteria) this;
        }

        public Criteria andResourceIsNotNull() {
            addCriterion("resource is not null");
            return (Criteria) this;
        }

        public Criteria andResourceEqualTo(String value) {
            addCriterion("resource =", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotEqualTo(String value) {
            addCriterion("resource <>", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThan(String value) {
            addCriterion("resource >", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceGreaterThanOrEqualTo(String value) {
            addCriterion("resource >=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThan(String value) {
            addCriterion("resource <", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLessThanOrEqualTo(String value) {
            addCriterion("resource <=", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceLike(String value) {
            addCriterion("resource like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotLike(String value) {
            addCriterion("resource not like", value, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceIn(List<String> values) {
            addCriterion("resource in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotIn(List<String> values) {
            addCriterion("resource not in", values, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceBetween(String value1, String value2) {
            addCriterion("resource between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andResourceNotBetween(String value1, String value2) {
            addCriterion("resource not between", value1, value2, "resource");
            return (Criteria) this;
        }

        public Criteria andCall_batchIsNull() {
            addCriterion("call_batch is null");
            return (Criteria) this;
        }

        public Criteria andCall_batchIsNotNull() {
            addCriterion("call_batch is not null");
            return (Criteria) this;
        }

        public Criteria andCall_batchEqualTo(String value) {
            addCriterion("call_batch =", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchNotEqualTo(String value) {
            addCriterion("call_batch <>", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchGreaterThan(String value) {
            addCriterion("call_batch >", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchGreaterThanOrEqualTo(String value) {
            addCriterion("call_batch >=", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchLessThan(String value) {
            addCriterion("call_batch <", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchLessThanOrEqualTo(String value) {
            addCriterion("call_batch <=", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchLike(String value) {
            addCriterion("call_batch like", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchNotLike(String value) {
            addCriterion("call_batch not like", value, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchIn(List<String> values) {
            addCriterion("call_batch in", values, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchNotIn(List<String> values) {
            addCriterion("call_batch not in", values, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchBetween(String value1, String value2) {
            addCriterion("call_batch between", value1, value2, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_batchNotBetween(String value1, String value2) {
            addCriterion("call_batch not between", value1, value2, "call_batch");
            return (Criteria) this;
        }

        public Criteria andCall_stautsIsNull() {
            addCriterion("call_stauts is null");
            return (Criteria) this;
        }

        public Criteria andCall_stautsIsNotNull() {
            addCriterion("call_stauts is not null");
            return (Criteria) this;
        }

        public Criteria andCall_stautsEqualTo(Integer value) {
            addCriterion("call_stauts =", value, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsNotEqualTo(Integer value) {
            addCriterion("call_stauts <>", value, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsGreaterThan(Integer value) {
            addCriterion("call_stauts >", value, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsGreaterThanOrEqualTo(Integer value) {
            addCriterion("call_stauts >=", value, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsLessThan(Integer value) {
            addCriterion("call_stauts <", value, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsLessThanOrEqualTo(Integer value) {
            addCriterion("call_stauts <=", value, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsIn(List<Integer> values) {
            addCriterion("call_stauts in", values, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsNotIn(List<Integer> values) {
            addCriterion("call_stauts not in", values, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsBetween(Integer value1, Integer value2) {
            addCriterion("call_stauts between", value1, value2, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andCall_stautsNotBetween(Integer value1, Integer value2) {
            addCriterion("call_stauts not between", value1, value2, "call_stauts");
            return (Criteria) this;
        }

        public Criteria andSenceIDIsNull() {
            addCriterion("senceID is null");
            return (Criteria) this;
        }

        public Criteria andSenceIDIsNotNull() {
            addCriterion("senceID is not null");
            return (Criteria) this;
        }

        public Criteria andSenceIDEqualTo(Integer value) {
            addCriterion("senceID =", value, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDNotEqualTo(Integer value) {
            addCriterion("senceID <>", value, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDGreaterThan(Integer value) {
            addCriterion("senceID >", value, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("senceID >=", value, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDLessThan(Integer value) {
            addCriterion("senceID <", value, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDLessThanOrEqualTo(Integer value) {
            addCriterion("senceID <=", value, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDIn(List<Integer> values) {
            addCriterion("senceID in", values, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDNotIn(List<Integer> values) {
            addCriterion("senceID not in", values, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDBetween(Integer value1, Integer value2) {
            addCriterion("senceID between", value1, value2, "senceID");
            return (Criteria) this;
        }

        public Criteria andSenceIDNotBetween(Integer value1, Integer value2) {
            addCriterion("senceID not between", value1, value2, "senceID");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
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