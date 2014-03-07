package jp.yokomark.widget.edittext.validation.internal.matcher;

import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public interface ValidationRuleMatcher {
    public boolean match(CharSequence input, ValidationRule rule);
}
