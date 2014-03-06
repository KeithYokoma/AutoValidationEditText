package jp.yokomark.widget.edittext.validation.internal.entity;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public class ValidationRule {
    private final int mMaxLengthThreshold;
    private final int mMinLengthThreshold;

    public ValidationRule(int maxLengthThreshold, int minLengthThreshold) {
        mMaxLengthThreshold = maxLengthThreshold;
        mMinLengthThreshold = minLengthThreshold;
    }

    public int getMaxLengthThreshold() {
        return mMaxLengthThreshold;
    }

    public int getMinLengthThreshold() {
        return mMinLengthThreshold;
    }
}
