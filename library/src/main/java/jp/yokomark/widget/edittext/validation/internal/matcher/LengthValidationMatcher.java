package jp.yokomark.widget.edittext.validation.internal.matcher;

import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public class LengthValidationMatcher implements ValidationRuleMatcher {
    @Override
    public boolean match(CharSequence input, ValidationRule rule) {
        int length = input.length();
        return length < rule.getMinLengthThreshold() || length > rule.getMaxLengthThreshold();
    }
}
