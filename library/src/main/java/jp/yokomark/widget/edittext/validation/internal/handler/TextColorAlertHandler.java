package jp.yokomark.widget.edittext.validation.internal.handler;

import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.NormalViewResource;

/**
 * @author keishin.yokomaku
 * @since 2014/03/07
 */
public class TextColorAlertHandler implements AlertViewHandler {
    @Override
    public void onError(EditText view, AlertViewResource resource) {
        view.setTextColor(resource.getColor());
    }

    @Override
    public void onValid(EditText view, NormalViewResource resource) {
        view.setTextColor(resource.getColor());
    }
}
