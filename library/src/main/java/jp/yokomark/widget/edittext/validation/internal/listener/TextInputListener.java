package jp.yokomark.widget.edittext.validation.internal.listener;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertType;
import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public class TextInputListener implements TextWatcher {
    public static final String TAG = TextInputListener.class.getSimpleName();
    private EditText mTarget;
    private final ValidationRule mRule;
    private final AlertType mType;
    private final AlertViewResource mResource;

    public TextInputListener(EditText target, ValidationRule rule, AlertType type, AlertViewResource resource) {
        mTarget = target;
        mRule = rule;
        mType = type;
        mResource = resource;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        mType.getHandler().handle(mTarget, mResource);
    }

    /**
     * Mark the watching edit text as no longer used.
     */
    public void destroy() {
        mTarget = null;
    }
}
