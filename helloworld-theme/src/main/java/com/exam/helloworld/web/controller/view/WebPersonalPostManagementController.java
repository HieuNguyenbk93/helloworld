package com.exam.helloworld.web.controller.view;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import org.youngmonkeys.ezyarticle.web.controller.view.PostManagementController;

@Controller
public class WebPersonalPostManagementController
    extends PostManagementController {

    @Override
    protected String getPreviewTemplate() {
        return "posts/details";
    }
}
