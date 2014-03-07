package jp.yokomark.widget.edittext.validation.internal.entity;

import android.content.res.TypedArray;

import jp.yokomark.widget.edittext.validation.R;
import jp.yokomark.widget.edittext.validation.internal.handler.AlertViewHandler;
import jp.yokomark.widget.edittext.validation.internal.handler.BackgroundColorAlertHandler;
import jp.yokomark.widget.edittext.validation.internal.handler.ErrorTipAlertHandler;
import jp.yokomark.widget.edittext.validation.internal.handler.TextColorAlertHandler;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public enum AlertType {
    TEXT_COLOR(0, new TextColorAlertHandler()),
    BACKGROUND_COLOR(1, new BackgroundColorAlertHandler()),
    ERROR_TIP(2, new ErrorTipAlertHandler());

    private final int mTypeId;
    private final AlertViewHandler mHandler;

    private AlertType(int typeId, AlertViewHandler handler) {
        mTypeId = typeId;
        mHandler = handler;
    }

    public static AlertType valueOf(TypedArray a) {
        int typeId = a.getInt(R.styleable.AutoValidationEditText_alertType, 0);
        for (AlertType type : values()) {
            if (type.getTypeId() == typeId) {
                return type;
            }
        }
        return TEXT_COLOR;
    }

    public int getTypeId() {
        return mTypeId;
    }

    public AlertViewHandler getHandler() {
        return mHandler;
    }
}
