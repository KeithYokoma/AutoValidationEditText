package jp.yokomark.widget.edittext.validation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertType;
import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.NormalViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;
import jp.yokomark.widget.edittext.validation.internal.matcher.ValidationRuleCollection;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
@SuppressWarnings("unused") // public APIs
public class AutoValidationEditText extends EditText {
    private boolean mIsInitialized = false;
    private ValidationRuleCollection mRuleMatcher;
    private ValidationRule mRule;
    private AlertType mType;
    private AlertViewResource mAlertResource;
    private NormalViewResource mNormalResource;
    private OnValidationListener mListener;

    public static final String TAG = AutoValidationEditText.class.getSimpleName();

    public AutoValidationEditText(Context context) {
        super(context);
        mRuleMatcher = new ValidationRuleCollection();
        init(context, null, 0);
    }

    public AutoValidationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRuleMatcher = new ValidationRuleCollection();
        init(context, attrs, 0);
    }

    public AutoValidationEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mRuleMatcher = new ValidationRuleCollection();
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = null;
        try {
            a = context.obtainStyledAttributes(attrs, R.styleable.AutoValidationEditText, defStyle, 0);
            mType = AlertType.valueOf(a);
            int minLength = a.getInt(R.styleable.AutoValidationEditText_minLengthThreshold, 0);
            int maxLength = a.getInt(R.styleable.AutoValidationEditText_maxLengthThreshold, Integer.MAX_VALUE);
            mRule = new ValidationRule(maxLength, minLength);
            mAlertResource = new AlertViewResource();
            mAlertResource.setColor(a.getColor(R.styleable.AutoValidationEditText_alertColor, Color.RED));
            mAlertResource.setMessage(a.getString(R.styleable.AutoValidationEditText_alertMessage));
            mNormalResource = new NormalViewResource();
            mNormalResource.setColor(a.getColor(R.styleable.AutoValidationEditText_normalColor, Color.WHITE));
            mIsInitialized = true;
            validate();
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        validate();
    }

    public void setOnValidationListener(OnValidationListener listener) {
        mListener = listener;
    }

    private void validate() {
        if (!mIsInitialized) {
            return;
        }
        if (mRuleMatcher.match(getText(), mRule)) {
            mType.getHandler().onError(this, mAlertResource);
            callOnError();
        } else {
            mType.getHandler().onValid(this, mNormalResource);
            callOnValid();
        }
    }

    private void callOnValid() {
        if (mListener != null) {
            mListener.onValid();
        }
    }

    private void callOnError() {
        if (mListener != null) {
            mListener.onError();
        }
    }

    public interface OnValidationListener {
        public void onError();
        public void onValid();
    }
}