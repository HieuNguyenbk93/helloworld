package com.exam.helloworld.web.controller.view;

import com.tvd12.ezyhttp.server.core.annotation.Controller;
import com.tvd12.ezyhttp.server.core.annotation.DoGet;
import com.tvd12.ezyhttp.server.core.annotation.PathVariable;
import com.tvd12.ezyhttp.server.core.annotation.RequestParam;
import com.tvd12.ezyhttp.server.core.view.View;
import org.youngmonkeys.ezyarticle.sdk.entity.TermType;
import org.youngmonkeys.ezyarticle.sdk.model.TermModel;
import org.youngmonkeys.ezyarticle.sdk.pagination.DefaultPostFilter;
import org.youngmonkeys.ezyarticle.web.controller.view.BlogController;
import org.youngmonkeys.ezyarticle.web.response.WebPostContentResponse;
import org.youngmonkeys.ezyplatform.model.PaginationModel;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebHelloworldBlogController extends BlogController {

    @DoGet("/blogs/tags/{slug}")
    public View blogsTagsSlugGet(
        HttpServletRequest request,
        @PathVariable String termSlug,
        @RequestParam("sortOrder") String sortOrder,
        @RequestParam("keyword") String keyword,
        @RequestParam("nextPageToken") String nextPageToken,
        @RequestParam("prevPageToken") String prevPageToken,
        @RequestParam("lastPage") boolean lastPage,
        @RequestParam(value = "limit", defaultValue = "12") int limit
    ) {
        this.commonValidator.validatePageSize(limit);
        this.commonValidator.validateSearchKeyword(keyword);
        TermModel term = this.termValidator.validateSearchTerm(TermType.TAG.toString(), termSlug);
        DefaultPostFilter.Builder filterBuilder = DefaultPostFilter.builder().termSlug(termSlug);
        String languageCode = this.languageControllerService.getLanguageCodeOrDefault(request);
        PaginationModel<WebPostContentResponse> pagination = this.postControllerService
            .getPublishedBlogPagination(
                filterBuilder,
                sortOrder,
                languageCode,
                keyword, nextPageToken, prevPageToken, lastPage, limit);
        View.Builder viewBuilder = View.builder()
            .template("blog/list")
            .addVariable("pagination", pagination)
            .addVariable("pageTitle", term.getName())
            .addVariable(
                "pageFragments",
                this.pageFragmentManager.getPageFragmentMap("blog_list", languageCode))
            .putKeyValueToVariable("additionalValueMap", "ratingItemType", "ezyarticle_terms").putKeyValueToVariable("additionalValueMap", "ratingItemId", term.getId());
        this.decorateBlogView(request, viewBuilder);
        return viewBuilder.build();
    }
}
