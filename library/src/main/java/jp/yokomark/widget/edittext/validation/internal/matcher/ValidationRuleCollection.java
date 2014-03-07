package jp.yokomark.widget.edittext.validation.internal.matcher;

import java.util.LinkedHashSet;
import java.util.Set;

import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;

/**
 * @author keishin.yokomaku
 * @since 2014/03/07
 */
public class ValidationRuleCollection {
    private final Set<ValidationRuleMatcher> mMatchers;

    public ValidationRuleCollection() {
        mMatchers = new LinkedHashSet<ValidationRuleMatcher>();
        mMatchers.add(new LengthValidationMatcher());
    }

    /**
     * Compare the input with the validation rule
     * @param input
     * @param rule
     * @return
     */
    public boolean match(CharSequence input, ValidationRule rule) {
        for (ValidationRuleMatcher matcher : mMatchers) {
            if (matcher.match(input, rule)) {
                return true;
            }
        }
        return false;
    }
}
