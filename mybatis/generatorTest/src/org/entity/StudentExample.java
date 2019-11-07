package org.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andSnoIsNull() {
            addCriterion("SNO is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("SNO is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(Integer value) {
            addCriterion("SNO =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(Integer value) {
            addCriterion("SNO <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(Integer value) {
            addCriterion("SNO >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SNO >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(Integer value) {
            addCriterion("SNO <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(Integer value) {
            addCriterion("SNO <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<Integer> values) {
            addCriterion("SNO in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<Integer> values) {
            addCriterion("SNO not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(Integer value1, Integer value2) {
            addCriterion("SNO between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(Integer value1, Integer value2) {
            addCriterion("SNO not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("AGE is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("AGE is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("AGE =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("AGE <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("AGE >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGE >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("AGE <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("AGE <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("AGE in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("AGE not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("AGE between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("AGE not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Short value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Short value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Short value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Short value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Short value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Short value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Short> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Short> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Short value1, Short value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Short value1, Short value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssIsNull() {
            addCriterion("HOMEADDRSS is null");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssIsNotNull() {
            addCriterion("HOMEADDRSS is not null");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssEqualTo(String value) {
            addCriterion("HOMEADDRSS =", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssNotEqualTo(String value) {
            addCriterion("HOMEADDRSS <>", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssGreaterThan(String value) {
            addCriterion("HOMEADDRSS >", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssGreaterThanOrEqualTo(String value) {
            addCriterion("HOMEADDRSS >=", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssLessThan(String value) {
            addCriterion("HOMEADDRSS <", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssLessThanOrEqualTo(String value) {
            addCriterion("HOMEADDRSS <=", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssLike(String value) {
            addCriterion("HOMEADDRSS like", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssNotLike(String value) {
            addCriterion("HOMEADDRSS not like", value, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssIn(List<String> values) {
            addCriterion("HOMEADDRSS in", values, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssNotIn(List<String> values) {
            addCriterion("HOMEADDRSS not in", values, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssBetween(String value1, String value2) {
            addCriterion("HOMEADDRSS between", value1, value2, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andHomeaddrssNotBetween(String value1, String value2) {
            addCriterion("HOMEADDRSS not between", value1, value2, "homeaddrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssIsNull() {
            addCriterion("SCHOOLADDRSS is null");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssIsNotNull() {
            addCriterion("SCHOOLADDRSS is not null");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssEqualTo(String value) {
            addCriterion("SCHOOLADDRSS =", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssNotEqualTo(String value) {
            addCriterion("SCHOOLADDRSS <>", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssGreaterThan(String value) {
            addCriterion("SCHOOLADDRSS >", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssGreaterThanOrEqualTo(String value) {
            addCriterion("SCHOOLADDRSS >=", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssLessThan(String value) {
            addCriterion("SCHOOLADDRSS <", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssLessThanOrEqualTo(String value) {
            addCriterion("SCHOOLADDRSS <=", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssLike(String value) {
            addCriterion("SCHOOLADDRSS like", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssNotLike(String value) {
            addCriterion("SCHOOLADDRSS not like", value, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssIn(List<String> values) {
            addCriterion("SCHOOLADDRSS in", values, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssNotIn(List<String> values) {
            addCriterion("SCHOOLADDRSS not in", values, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssBetween(String value1, String value2) {
            addCriterion("SCHOOLADDRSS between", value1, value2, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andSchooladdrssNotBetween(String value1, String value2) {
            addCriterion("SCHOOLADDRSS not between", value1, value2, "schooladdrss");
            return (Criteria) this;
        }

        public Criteria andCardidIsNull() {
            addCriterion("CARDID is null");
            return (Criteria) this;
        }

        public Criteria andCardidIsNotNull() {
            addCriterion("CARDID is not null");
            return (Criteria) this;
        }

        public Criteria andCardidEqualTo(Short value) {
            addCriterion("CARDID =", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotEqualTo(Short value) {
            addCriterion("CARDID <>", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThan(Short value) {
            addCriterion("CARDID >", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidGreaterThanOrEqualTo(Short value) {
            addCriterion("CARDID >=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThan(Short value) {
            addCriterion("CARDID <", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidLessThanOrEqualTo(Short value) {
            addCriterion("CARDID <=", value, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidIn(List<Short> values) {
            addCriterion("CARDID in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotIn(List<Short> values) {
            addCriterion("CARDID not in", values, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidBetween(Short value1, Short value2) {
            addCriterion("CARDID between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andCardidNotBetween(Short value1, Short value2) {
            addCriterion("CARDID not between", value1, value2, "cardid");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("CLASSID is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("CLASSID is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Short value) {
            addCriterion("CLASSID =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Short value) {
            addCriterion("CLASSID <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Short value) {
            addCriterion("CLASSID >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Short value) {
            addCriterion("CLASSID >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Short value) {
            addCriterion("CLASSID <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Short value) {
            addCriterion("CLASSID <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Short> values) {
            addCriterion("CLASSID in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Short> values) {
            addCriterion("CLASSID not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Short value1, Short value2) {
            addCriterion("CLASSID between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Short value1, Short value2) {
            addCriterion("CLASSID not between", value1, value2, "classid");
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