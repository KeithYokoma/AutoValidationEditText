package jp.yokomark.widget.edittext.validation.internal.handler;

import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public interface ValidationRuleMatcher {
    public boolean match(CharSequence input, ValidationRule rule);
}
