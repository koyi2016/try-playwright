package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.CategoryTopPage;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@ExtendWith(PlaywrightExtension.class)
public class CategoryTopPageTest {

    private static final Map<String, String> categoryPathNameMap = Map.of(
        "technical-research", "先進技術研究",
        "mobile-application", "モバイルアプリケーション開発",
        "web-application", "Webアプリケーション開発"
    );


    @DisplayName("カテゴリトップページのタイトルが正しい内容であること")
    void checkTitle(Page page) {
        CategoryTopPage categoryTopPage = new CategoryTopPage(page);

        categoryPathNameMap.forEach((path, name) -> categoryTopPage.navigate(path, name));
    }


    @DisplayName("metaタグのdescriptionが正しい内容であること")
    void checkMetaDescription(Page page) {
        CategoryTopPage categoryTopPage = new CategoryTopPage(page);

        Map<String, String> categoryPathExcerptMap = Map.of(
            "technical-research", "TIS株式会社　先進技術研究チームが取り組む研究に関する活動・レポートをご紹介します。",
            "mobile-application", "TIS株式会社　テクノロジー＆イノベーション本部・モバイル開発チームがモバイル開発を実践する中で得たノウハウ・TIPS・サンプルとなる情報をご紹介します。",
            "web-application", "長年Webアプリケーション開発のアーキテクト・フルスタックエンジニアとして携わってきたTIS株式会社　テクノロジー＆イノベーション本部　エンジニアチームが、開発プロジェクトの実践を通じて培った開発ノウハウ・実践の中で活用するFW・ガイド・ツールをご紹介します。"
        );

        categoryPathExcerptMap.forEach((path, excerpt) -> categoryTopPage.checkMetaDescription(path, excerpt));
    }


    @DisplayName("h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        CategoryTopPage categoryTopPage = new CategoryTopPage(page);

        categoryPathNameMap.forEach((path, name) -> categoryTopPage.checkH1Tag(path, name));
    }


    @DisplayName("h2タグが正しい内容であること")
    void checkH2Tag(Page page) {
        CategoryTopPage categoryTopPage = new CategoryTopPage(page);

        categoryPathNameMap.forEach((path, name) -> categoryTopPage.checkH2Tag(path, name));
    }


    @DisplayName("テスト環境で（注目記事エリア）記事一覧の各記事著者名のdom要素はdivであること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境の記事が本番に追いついてない為")
    void checkBlogAuthorNameDomElementSummaryBlogListOnTestEnv(Page page) {
        CategoryTopPage categoryTopPage = new CategoryTopPage(page);
        categoryTopPage.navigate("web-application", "Webアプリケーション開発");
        Locator authorNameDivElement = page.locator("li.o-card.o-card--hot .o-card__content > .o-card__user > .info > div");
        // 「.info > div」に著者名のdiv要素以外に、「div.bottom」の要素もあるため、div要素数＝記事数（web-applicationでは3）*２
        // 2022-12-16時点で記事数＝3
        assertThat(authorNameDivElement).hasCount(3*2);
    }


    @DisplayName("本番環境で（注目記事エリア）記事一覧の各記事著者名のdom要素はdivであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事が本番に追いついてない為")
    @Disabled("本番環境で注目記事エリアに記事が増える度に修正必要があり、手間がかかるため")
    void checkBlogAuthorNameDomElementSummaryBlogListOnProductionEnv(Page page) {
        CategoryTopPage categoryTopPage = new CategoryTopPage(page);
        categoryTopPage.navigate("web-application", "Webアプリケーション開発");
        Locator authorNameDivElement = page.locator("li.o-card.o-card--hot .o-card__content > .o-card__user > .info > div");
        // 「.info > div」に著者名のdiv要素以外に、「div.bottom」の要素もあるため、div要素数＝記事数（web-applicationでは7）*２
        // 2022-12-16時点で記事数＝7
        assertThat(authorNameDivElement).hasCount(7*2);
    }
}
