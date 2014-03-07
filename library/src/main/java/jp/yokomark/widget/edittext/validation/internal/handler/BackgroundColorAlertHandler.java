package jp.yokomark.widget.edittext.validation.internal.handler;

import android.widget.EditText;

import jp.yokomark.widget.edittext.validation.internal.entity.AlertViewResource;
import jp.yokomark.widget.edittext.validation.internal.entity.NormalViewResource;

/**
 * @author keishin.yokomaku
 * @since 2014/03/07
 */
public class BackgroundColorAlertHandler implements AlertViewHandler {
    @Override
    public void onError(EditText view, AlertViewResource resource) {
        view.setBackgroundColor(resource.getColor());
    }

    @Override
    public void onValid(EditText view, NormalViewResource resource) {
        view.setBackgroundColor(resource.getColor());
    }
}
