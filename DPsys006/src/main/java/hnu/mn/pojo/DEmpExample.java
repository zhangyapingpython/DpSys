package hnu.mn.pojo;

import java.util.ArrayList;
import java.util.List;

public class DEmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DEmpExample() {
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

        public Criteria andEmpidIsNull() {
            addCriterion("empID is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empID is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(Integer value) {
            addCriterion("empID =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(Integer value) {
            addCriterion("empID <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(Integer value) {
            addCriterion("empID >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("empID >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(Integer value) {
            addCriterion("empID <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(Integer value) {
            addCriterion("empID <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<Integer> values) {
            addCriterion("empID in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<Integer> values) {
            addCriterion("empID not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(Integer value1, Integer value2) {
            addCriterion("empID between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(Integer value1, Integer value2) {
            addCriterion("empID not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNull() {
            addCriterion("empName is null");
            return (Criteria) this;
        }

        public Criteria andEmpnameIsNotNull() {
            addCriterion("empName is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnameEqualTo(String value) {
            addCriterion("empName =", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotEqualTo(String value) {
            addCriterion("empName <>", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThan(String value) {
            addCriterion("empName >", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameGreaterThanOrEqualTo(String value) {
            addCriterion("empName >=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThan(String value) {
            addCriterion("empName <", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLessThanOrEqualTo(String value) {
            addCriterion("empName <=", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameLike(String value) {
            addCriterion("empName like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotLike(String value) {
            addCriterion("empName not like", value, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameIn(List<String> values) {
            addCriterion("empName in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotIn(List<String> values) {
            addCriterion("empName not in", values, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameBetween(String value1, String value2) {
            addCriterion("empName between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpnameNotBetween(String value1, String value2) {
            addCriterion("empName not between", value1, value2, "empname");
            return (Criteria) this;
        }

        public Criteria andEmpageIsNull() {
            addCriterion("empAge is null");
            return (Criteria) this;
        }

        public Criteria andEmpageIsNotNull() {
            addCriterion("empAge is not null");
            return (Criteria) this;
        }

        public Criteria andEmpageEqualTo(Integer value) {
            addCriterion("empAge =", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotEqualTo(Integer value) {
            addCriterion("empAge <>", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageGreaterThan(Integer value) {
            addCriterion("empAge >", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageGreaterThanOrEqualTo(Integer value) {
            addCriterion("empAge >=", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageLessThan(Integer value) {
            addCriterion("empAge <", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageLessThanOrEqualTo(Integer value) {
            addCriterion("empAge <=", value, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageIn(List<Integer> values) {
            addCriterion("empAge in", values, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotIn(List<Integer> values) {
            addCriterion("empAge not in", values, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageBetween(Integer value1, Integer value2) {
            addCriterion("empAge between", value1, value2, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpageNotBetween(Integer value1, Integer value2) {
            addCriterion("empAge not between", value1, value2, "empage");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyIsNull() {
            addCriterion("empMoney is null");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyIsNotNull() {
            addCriterion("empMoney is not null");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyEqualTo(Double value) {
            addCriterion("empMoney =", value, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyNotEqualTo(Double value) {
            addCriterion("empMoney <>", value, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyGreaterThan(Double value) {
            addCriterion("empMoney >", value, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("empMoney >=", value, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyLessThan(Double value) {
            addCriterion("empMoney <", value, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyLessThanOrEqualTo(Double value) {
            addCriterion("empMoney <=", value, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyIn(List<Double> values) {
            addCriterion("empMoney in", values, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyNotIn(List<Double> values) {
            addCriterion("empMoney not in", values, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyBetween(Double value1, Double value2) {
            addCriterion("empMoney between", value1, value2, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpmoneyNotBetween(Double value1, Double value2) {
            addCriterion("empMoney not between", value1, value2, "empmoney");
            return (Criteria) this;
        }

        public Criteria andEmpweightIsNull() {
            addCriterion("empWeight is null");
            return (Criteria) this;
        }

        public Criteria andEmpweightIsNotNull() {
            addCriterion("empWeight is not null");
            return (Criteria) this;
        }

        public Criteria andEmpweightEqualTo(Double value) {
            addCriterion("empWeight =", value, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightNotEqualTo(Double value) {
            addCriterion("empWeight <>", value, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightGreaterThan(Double value) {
            addCriterion("empWeight >", value, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightGreaterThanOrEqualTo(Double value) {
            addCriterion("empWeight >=", value, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightLessThan(Double value) {
            addCriterion("empWeight <", value, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightLessThanOrEqualTo(Double value) {
            addCriterion("empWeight <=", value, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightIn(List<Double> values) {
            addCriterion("empWeight in", values, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightNotIn(List<Double> values) {
            addCriterion("empWeight not in", values, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightBetween(Double value1, Double value2) {
            addCriterion("empWeight between", value1, value2, "empweight");
            return (Criteria) this;
        }

        public Criteria andEmpweightNotBetween(Double value1, Double value2) {
            addCriterion("empWeight not between", value1, value2, "empweight");
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