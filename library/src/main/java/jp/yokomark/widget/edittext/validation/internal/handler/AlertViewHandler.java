package jp.yokomark.widget.edittext.validation.internal.handler;

import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public interface AlertViewHandler {
    public void handle(EditText view, AlertViewResource resource);
}
