package com.exam.helloworld.web.view;

import com.tvd12.ezyfox.bean.annotation.EzySingleton;
import com.tvd12.ezyhttp.server.core.view.View;
import lombok.AllArgsConstructor;
import org.youngmonkeys.ezyplatform.web.view.WebViewDecorator;

import javax.servlet.http.HttpServletRequest;

@EzySingleton
@AllArgsConstructor
public class WebHelloworldViewDecorator extends WebViewDecorator {

    @Override
    public void decorate(HttpServletRequest request, View view) {
        super.decorate(request, view);
        view.setVariable(
            "requestURI",
            request.getRequestURI()
        );
    }

    @Override
    protected boolean includeWebLanguages() {
        return true;
    }
}
