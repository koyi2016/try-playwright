package com.example;

import com.example.pages.TagTopPage;
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
public class TagTopPageTest {
    private static final String META_DESCRIPTION = "Fintanは、TISインテックグループが研究開発や、システム開発、新規事業開発のプロジェクトで培ったノウハウを集約したサイトです。";
    private final List<String> tagNames = List.of("XR", "スクラム開発", "イベント");

    private static final int MAX_BLOG_COUNT_PER_PAGE_TAG_TOP_PAGE = 16;
    @Test
    @DisplayName("タグトップページのタイトルが正しい内容であること")
    void checkTitle(Page page) {
        TagTopPage tagTopPage = new TagTopPage(page);

        tagNames.forEach(tagName -> tagTopPage.navigate(tagName));
    }

    @Test
    @DisplayName("metaタグのdescriptionが正しい内容であること")
    void checkMetaDescription(Page page) {
        TagTopPage tagTopPage = new TagTopPage(page);

        tagNames.forEach(tagName -> {
            tagTopPage.navigate(tagName);
            Locator metaDescription = tagTopPage.getMetaDescription();
            // AIOSEOのプラグインにより、descriptionが複数になってしまうことがある
            assertThat(metaDescription).hasCount(1);
            String expectMetaDescription = "#" + tagName + "の記事一覧ページです。" + META_DESCRIPTION;
            String actualMetaDescription = metaDescription.first().getAttribute("content");
            assertEquals(expectMetaDescription, actualMetaDescription);
        });
    }


    @DisplayName("h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        TagTopPage tagTopPage = new TagTopPage(page);

        tagNames.forEach(tagName -> tagTopPage.checkH1Tag(tagName));
    }


    @DisplayName("記事一覧の各記事タイトルのdom要素はdivであること")
    void checkBlogTileDomElement(Page page) {
        TagTopPage tagTopPage = new TagTopPage(page);
        tagTopPage.navigate("React");
        Locator titleDivElements = tagTopPage.getContentTitles();
        assertThat(titleDivElements).hasCount(MAX_BLOG_COUNT_PER_PAGE_TAG_TOP_PAGE);
    }
}
