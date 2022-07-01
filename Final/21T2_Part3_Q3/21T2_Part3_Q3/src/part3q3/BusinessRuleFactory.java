package part3q3;

public class BusinessRuleFactory {
    public static BusinessRule CreateGroupOperator(BusinessRule ruleA, BusinessRuleGroupTypes operator, BusinessRule ruleB) {
        return null;
    }

    public static BusinessRule CreateComparisonOperator(BusinessRuleValue target, BusinessRuleOperators operator, BusinessRuleValue argument) {
        return null;
    }

    public static BusinessRule CreateComparisonOperator(BusinessRuleValue target, BusinessRuleOperators operator) {
        return null;
    }

    public static BusinessRuleValue CreateTransformationOperator(BusinessRuleValue target, BusinessRuleTransformations transform, BusinessRuleValue argument) {
        return null;
    }

    public static BusinessRuleValue LookupVariable(String value) {
        return null;
    }

    public static BusinessRuleValue CreateConstant(Object value) {
        return null;
    }
}
