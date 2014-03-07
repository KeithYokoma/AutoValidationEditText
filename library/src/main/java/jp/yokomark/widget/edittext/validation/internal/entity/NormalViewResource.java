package jp.yokomark.widget.edittext.validation.internal.entity;

/**
 * @author keishin.yokomaku
 * @since 2014/03/07
 */
public class NormalViewResource {
    private int mColor;
    private String mMessage;

    public void setColor(int color) {
        mColor = color;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public int getColor() {
        return mColor;
    }

    public String getMessage() {
        return mMessage;
    }
}
