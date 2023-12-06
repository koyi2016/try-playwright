package com.example;

import com.example.pages.AuthorBlogListPage;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PlaywrightExtension.class)
public class AuthorBlogListPageTest {
    private static final String META_DESCRIPTION = "Fintanは、TISインテックグループが研究開発や、システム開発、新規事業開発のプロジェクトで培ったノウハウを集約したサイトです。";
    private final List<String> authorNames = List.of("XRチーム", "協業開発チーム", "新規事業開発チーム");
    @Test
    @DisplayName("著者の記事一覧ページのタイトルが正しい内容であること")
    void checkTitle(Page page) {
        AuthorBlogListPage authorBlogListPage = new AuthorBlogListPage(page);
        authorNames.forEach(authorName -> authorBlogListPage.navigate(authorName));
    }


    @DisplayName("metaタグのdescriptionが正しい内容であること")
    void checkMetaDescription(Page page) {
        AuthorBlogListPage authorBlogListPage = new AuthorBlogListPage(page);

        authorNames.forEach(authorName -> {
            authorBlogListPage.navigate(authorName);
            String expectMetaDescription = "著者：" + authorName + "の記事一覧ページです。" + META_DESCRIPTION;
            Locator metaDescription = authorBlogListPage.getMetaDescription();
            // AIOSEOのプラグインにより、descriptionが複数になってしまうことがある
            assertThat(metaDescription).hasCount(1);
            String actualMetaDescription = metaDescription.first().getAttribute("content");
            assertEquals(expectMetaDescription, actualMetaDescription);
        });
    }


    @DisplayName("h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        AuthorBlogListPage authorBlogListPage = new AuthorBlogListPage(page);
        authorNames.forEach(authorName -> authorBlogListPage.checkH1Tag(authorName));
    }
}
