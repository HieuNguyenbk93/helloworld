package com.exam.helloworld.web.service;


import com.tvd12.ezyhttp.server.core.annotation.Service;
import org.youngmonkeys.ezyplatform.model.MediaNameModel;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Service
public class WebPersonalAdminAvatarService {

    public Map<String, MediaNameModel> getAvatarMapByUuids(
        Set<String> authorUuids
    ) {
        return Collections.emptyMap();
    }
}
