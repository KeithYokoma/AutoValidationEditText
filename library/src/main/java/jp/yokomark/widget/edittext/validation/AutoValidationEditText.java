package jp.yokomark.widget.edittext.validation;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertType;
import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.ValidationRule;
import jp.yokomark.widget.edittext.validation.internal.listener.TextInputListener;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public class AutoValidationEditText extends EditText {
    private TextInputListener mListener;

    public static final String TAG = AutoValidationEditText.class.getSimpleName();

    public AutoValidationEditText(Context context) {
        this(context, null);
    }

    public AutoValidationEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AutoValidationEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = null;
        try {
            a = context.obtainStyledAttributes(attrs, R.styleable.AutoValidationEditText, defStyle, 0);
            AlertType type = AlertType.valueOf(a);
            int minLength = a.getInt(R.styleable.AutoValidationEditText_minLengthThreshold, 0);
            int maxLength = a.getInt(R.styleable.AutoValidationEditText_maxLengthThreshold, Integer.MAX_VALUE);
            String message = a.getString(R.styleable.AutoValidationEditText_alertMessage);
            int color = a.getColor(R.styleable.AutoValidationEditText_alertColor, Color.RED);
            ValidationRule rule = new ValidationRule(maxLength, minLength);
            AlertViewResource resource = new AlertViewResource();
            resource.setColor(color);
            resource.setMessage(message);
            mListener = new TextInputListener(this, rule, type, resource);
        } finally {
            if (a != null) {
                a.recycle();;
            }
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        addTextChangedListener(mListener);
    }

    @Override
    protected void onDetachedFromWindow() {
        mListener.destroy();
        removeTextChangedListener(mListener);
        super.onDetachedFromWindow();
    }

    public interface OnValidationFailureListener {
        public void onFailure();
    }
}