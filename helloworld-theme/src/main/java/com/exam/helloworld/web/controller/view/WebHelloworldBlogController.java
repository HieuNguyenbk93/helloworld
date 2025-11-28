package com.exam.helloworld.web.controller.view;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.view.View;
import org.youngmonkeys.ezyarticle.web.controller.view.BlogController;

import java.util.Collections;

@Controller
public class WebHelloworldBlogController extends BlogController {

    @Override
    protected void decorateBlogView(View.Builder viewBuilder) {
        super.decorateBlogView(viewBuilder);
        viewBuilder.addVariable(
            "readTimeInMinutesByPostId",
            Collections.emptyMap()
        );
        viewBuilder.addVariable(
            "authorAvatarByUuid",
            Collections.emptyMap()
        );
    }
}
