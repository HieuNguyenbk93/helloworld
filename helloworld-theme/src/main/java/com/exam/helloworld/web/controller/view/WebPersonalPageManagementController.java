package com.exam.helloworld.web.controller.view;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import org.youngmonkeys.ezyarticle.web.controller.view.PageManagementController;

@Controller
public class WebPersonalPageManagementController
    extends PageManagementController {

    @Override
    protected String getPreviewTemplate() {
        return "pages/details";
    }
}
