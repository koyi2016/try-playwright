package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

/**
 * カテゴリ一覧ページ。
 */
public class CategoryListPage extends PageTemplate {

    public CategoryListPage(Page page) {
        super(page);
    }

    /**
     * カテゴリ一覧に遷移する。
     */
    public void navigate() {
        page.navigate(fintan.url("/blog-category/"));
        Locator title = page.locator("title");
        // AIOSEOのプラグインにより、titleが複数になってしまうことがある
        assertThat(title).hasCount(1);
        assertThat(page).hasTitle("記事カテゴリ | Fintan");
    }

//    public Locator getCategoryNameLinks() {
//        return page.locator("ul.c-blog-category-top-page__list > li > .c-blog-category__block > a:first-child ");
//    }

    public Locator getCategoryNameLinks() {
        return page.locator("main ul.c-blog-category-top-page_list > li > .c-blog-category-contents > .c-blog-category-content");
    }



    public Locator getBlogListLink() {
        return page.locator("ul.c-blog-category__list > li > .c-blog-category__block > a.link").first();
    }
}
