package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.BlogDetailPage;
import com.example.pages.Fintan;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PlaywrightExtension.class)
public class BlogDetailPageTest {
    private final Fintan fintan = Fintan.getInstance();
    // 以下五つのページは固定ページのイメージだが、実際に記事ページになっている
    private static final String INQUIRY_PAGE_ID = "302";
    private static final String WHEN_USING_THIS_SITE_PAGE_ID = "303";
    private static final String ABOUT_TRADEMARK_PAGE_ID = "1622";
    private static final String LICENSE_PAGE_ID = "295";
    private static final String FAQ_PAGE_ID = "299";

    private static final String META_DESCRIPTION = "Fintanは、TISインテックグループが研究開発や、システム開発、新規事業開発のプロジェクトで培ったノウハウを集約したサイトです。";

    @Test
    @DisplayName("記事詳細ページのタイトルが正しい内容であること")
    void checkTitle(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        Map<String, String> idTitleMap = Map.of(
            "501", "VirtualCollaboBase",
            "163", "モバイルアプリケーションの配布",
            "1435", "Springアプリ開発ノウハウ集",
            INQUIRY_PAGE_ID, "お問い合わせ",
            WHEN_USING_THIS_SITE_PAGE_ID, "当サイトのご利用にあたって",
            ABOUT_TRADEMARK_PAGE_ID, "商標について",
            LICENSE_PAGE_ID, "ライセンス",
            FAQ_PAGE_ID, "ＦＡＱ（よくあるご質問）"
        );

        idTitleMap.forEach((id, title) -> blogDetailPage.navigate(id, title));
    }

    @Test
    @DisplayName("metaタグのdescriptionが正しい内容であること")
    void checkMetaDescription(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        Map<String, String> pageIdExcerptMap = Map.of(
            "501", "VR遠隔コラボレーションツールのベースとなるシステム～VirtualCollaboBaseを紹介します。",
            "163", "モバイルアプリケーションのテストにおけるテスト担当者へのアプリ配布方法・手順を、テストのユースケースごとに紹介しています。",
            "1435", "Springを活用してアプリケーションを構築する際に必要となるノウハウを提供します。特に、アプリケーションを開発する際に公式ドキュメントやWeb上から実装方法を見つけることが難しく、躓きやすい点についての情報を中心に提供します。",
            INQUIRY_PAGE_ID, "お問い合わせページです。" + META_DESCRIPTION,
            WHEN_USING_THIS_SITE_PAGE_ID, "当サイトのご利用についてはこちらのページをご覧ください。" + META_DESCRIPTION,
            ABOUT_TRADEMARK_PAGE_ID, "商標についてはこちらのページをご覧ください。" + META_DESCRIPTION,
            LICENSE_PAGE_ID, "ライセンスについてはこちらのページをご覧ください。" + META_DESCRIPTION,
            FAQ_PAGE_ID, "Fintanの利用についてのよくあるご質問をご紹介いたします。" + META_DESCRIPTION
        );

        pageIdExcerptMap.forEach((pageId, excerpt) -> blogDetailPage.checkMetaDescription(pageId, excerpt));
    }

    @Test
    @DisplayName("記事の著者エリア、著者名のdom要素はdivであること")
    void checkAuthorNameDomElement(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        Map<String, String> idAuthorNameMap = Map.of(
            "501", "XRチーム",
            "163", "モバイル開発チーム",
            "1435", "協業開発チーム"
        );

        idAuthorNameMap.forEach((id, name) -> blogDetailPage.checkAuthorNameDomElement(id, name));
    }


    @DisplayName("目次エリア、olタグでかつ各目次のdom要素はliタグであること")
    void checkTableOfContentsDomElement(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        Map<String, Integer> idTableOfContentCountMap = Map.of(
            "501", 3,
            "191", 18
            // 本番環境で記事の目次が更新され、都度修正するのは手間がかかるためコメントアウト
            // "1435", 3
        );

        idTableOfContentCountMap.forEach((id, count) -> blogDetailPage.checkTableOfContentsDomElement(id, count));
    }


    @DisplayName("見出しのID属性に一意な名前がついていること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境と本番環境で異なる記事の確認の為")
    void checkHeadingUniqueIdTestEnv(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        String pageId = "9060";

        // 本来であればサイドメニューの見出しをクリックした際に、適切な箇所へ遷移することの確認をしたいが
        // アサーションが難しいため、ID属性が一意になっていることをテストすることで確認している
        blogDetailPage.checkHeadingUniqueId(pageId);
    }


    @DisplayName("見出しのID属性に一意な名前がついていること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境と本番環境で異なる記事の確認の為")
    void checkHeadingUniqueIdProductionEnv(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        String pageId = "175";

        // 本来であればサイドメニューの見出しをクリックした際に、適切な箇所へ遷移することの確認をしたいが
        // アサーションが難しいため、ID属性が一意になっていることをテストすることで確認している
        blogDetailPage.checkHeadingUniqueId(pageId);
    }


    @DisplayName("「/page/3527/」の記事内の動画サイズが固定ではなくレスポンシブ的な設定になっていること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事が本番環境に追いついていないため")
    void checkVideoSize(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        blogDetailPage.navigate("3527");
        Locator video = page.locator("video").first();
        String actualVideoWidth = video.getAttribute("width");
        String actualVideoHeight = video.getAttribute("height");
        assertEquals("100%", actualVideoWidth);
        assertEquals("100%", actualVideoHeight);
    }


    @DisplayName("更新日のない記事のtimeタグに投稿日がdatetimeであること")
    void checkTimeTagWhenNoUpdatedDate(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        Map<String, String> idPostedDateMap = Map.of(
            "501", "2020-09-16",
            "163", "2021-04-28"
            // 更新日がなかったが本番環境の記事が更新されて更新日がある。
            // 都度修正するのは手間がかかるためコメントアウト
            // "1435", "2018-10-01"
        );
        idPostedDateMap.forEach((id, expectedDatetime) -> blogDetailPage.checkTimeTagDatetime(id, expectedDatetime));
    }


    @DisplayName("テスト環境で更新日のある記事のtimeタグに更新日がdatetimeであること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境の記事が本番環境に追いついていないため")
    void checkTimeTagWhenNoUpdateDateOnTestEnv(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        Map<String, String> idUpdatedDateMap = Map.of(
            "8962", "2022-12-09",
            "8947", "2022-11-02",
            "8931", "2022-09-06"
        );

        idUpdatedDateMap.forEach((id, expectedDatetime) -> blogDetailPage.checkTimeTagDatetime(id, expectedDatetime));
    }

    @DisplayName("本番環境で更新日のある記事のtimeタグに投稿日がdatetimeであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事が本番環境に追いついていないため")
    @Disabled("本番環境で記事が更新される度に修正に手間がかかるため")
    void checkTimeTagWhenUpdateDateOnProductionEnv(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        Map<String, String> idUpdatedDateMap = Map.of(
            "1868", "2022-11-02",
            "1872", "2022-12-15",
            "177", "2022-10-28"
        );

        idUpdatedDateMap.forEach((id, expectedDatetime) -> blogDetailPage.checkTimeTagDatetime(id, expectedDatetime));
    }


    @DisplayName("記事にパンくずリストがあり、内容が正しいであることをチェックする")
    void checkBreadcrumbs(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        blogDetailPage.navigate("191");

        Locator top = page.locator(".post-breadcrumbs .top a");
        String actualTopText = top.textContent();
        String actualTopUrl = top.getAttribute("href");
        assertEquals("Top", actualTopText);
        assertEquals(fintan.url("/"), actualTopUrl);

        Locator category = page.locator(".post-breadcrumbs .category a");
        String actualCategoryName = category.textContent();
        String actualCategoryUrl = category.getAttribute("href");
        assertEquals("Lerna", actualCategoryName);
        assertEquals(fintan.url("/blog-category/lerna/"), actualCategoryUrl);

        Locator title = page.locator(".post-breadcrumbs .title");
        String actualTitle = title.textContent();
        assertEquals("AWS Fargateを使ったAmazon ECSでAkka Clusterを安定稼働させる ─方式編─", actualTitle);
    }
}
