package jp.yokomark.widget.edittext.validation.internal.handler;

import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.NormalViewResource;

/**
 * @author keishin.yokomaku
 * @since 2014/03/06
 */
public interface AlertViewHandler {
    public void onError(EditText view, AlertViewResource resource);
    public void onValid(EditText view, NormalViewResource resource);
}
