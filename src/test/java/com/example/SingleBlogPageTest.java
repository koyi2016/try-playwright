package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.SingleBlogPage;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(PlaywrightExtension.class)
public class SingleBlogPageTest {
    private static final String META_DESCRIPTION = "Fintanは、TISインテックグループが研究開発や、システム開発、新規事業開発のプロジェクトで培ったノウハウを集約したサイトです。";
    private static final String ABOUT_PAGE_PATH = "about";
    private static final String ABOUT_PAGE_TITLE = "私たちについて";

    private static final String BLOG_CATEGORY_PAGE_PATH = "blog-category";
    private static final String BLOG_CATEGORY_PAGE_TITLE = "記事カテゴリ";

    private static final String FOR_ARCHITECT_PAGE_PATH = "for-architect";
    private static final String FOR_ARCHITECT_PAGE_TITLE = "アーキテクト向けコンテンツ";

    private static final String FOR_FRONTEND_ENGINEER_PAGE_PATH = "for-frontend-engineer";
    private static final String FOR_FRONTEND_ENGINEER_PAGE_TITLE = "フロントエンドエンジニア向けコンテンツ";

    private static final String FOR_BACKEND_ENGINEER_PAGE_PATH = "for-backend-engineer";
    private static final String FOR_BACKEND_ENGINEER_PAGE_TITLE = "バックエンドエンジニア向けコンテンツ";

    private static final String FOR_MOBILE_ENGINEER_PAGE_PATH = "for-mobile-engineer";
    private static final String FOR_MOBILE_ENGINEER_PAGE__TITLE = "モバイルエンジニア向けコンテンツ";

    private static final String FOR_DESIGNER_PAGE_PATH = "for-designer";
    private static final String FOR_DESIGNER_PAGE_TITLE = "デザイナー向けコンテンツ";

    private static final String FOR_NEW_BIZ_STARTER_PAGE_PATH = "for-new-biz-starter";
    private static final String FOR_NEW_BIZ_STARTER_PAGE_TITLE = "新規事業に関わる方向けコンテンツ";

    private static final String NEW_GRAD_PAGE_PATH = "new-grad";
    private static final String NEW_GRAD_PAGE_TITLE = "職場・働き方紹介（学生向け）";

    @Test
    @DisplayName("本番環境固定ページの各ページのタイトルが正しい内容であること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境のアーキテクトページ、バックエンドエンジニアページの記事データがないため")
    void checkTitleProductionEnv(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);

        Map<String, String> blogPathTitleMap = Map.of(
            ABOUT_PAGE_PATH, ABOUT_PAGE_TITLE,
            BLOG_CATEGORY_PAGE_PATH, BLOG_CATEGORY_PAGE_TITLE,
            FOR_ARCHITECT_PAGE_PATH, FOR_ARCHITECT_PAGE_TITLE,
            FOR_FRONTEND_ENGINEER_PAGE_PATH, FOR_FRONTEND_ENGINEER_PAGE_TITLE,
            FOR_BACKEND_ENGINEER_PAGE_PATH, FOR_BACKEND_ENGINEER_PAGE_TITLE,
            FOR_MOBILE_ENGINEER_PAGE_PATH, FOR_MOBILE_ENGINEER_PAGE__TITLE,
            FOR_DESIGNER_PAGE_PATH, FOR_DESIGNER_PAGE_TITLE,
            FOR_NEW_BIZ_STARTER_PAGE_PATH, FOR_NEW_BIZ_STARTER_PAGE_TITLE,
            NEW_GRAD_PAGE_PATH, NEW_GRAD_PAGE_TITLE
        );

        blogPathTitleMap.forEach((path, title) -> singleBlogPage.navigate(path, title));
    }


    @DisplayName("テスト環境固定ページの各ページのタイトルが正しい内容であること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境のアーキテクトページ、バックエンドエンジニアページの記事データがないため")
    @Disabled("テスト環境では表示できないページがあるため（ 職場・働き方紹介（学生向け） ）")
    void checkTitleTestEnv(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);

        Map<String, String> blogPathTitleMap = Map.of(
            ABOUT_PAGE_PATH, ABOUT_PAGE_TITLE,
            BLOG_CATEGORY_PAGE_PATH, BLOG_CATEGORY_PAGE_TITLE,
            FOR_FRONTEND_ENGINEER_PAGE_PATH, FOR_FRONTEND_ENGINEER_PAGE_TITLE,
            FOR_MOBILE_ENGINEER_PAGE_PATH, FOR_MOBILE_ENGINEER_PAGE__TITLE,
            FOR_DESIGNER_PAGE_PATH, FOR_DESIGNER_PAGE_TITLE,
            // 記事の変更で新規事業開発ページに記事がなくなったため
            // FOR_NEW_BIZ_STARTER_PAGE_PATH, FOR_NEW_BIZ_STARTER_PAGE_TITLE,
            NEW_GRAD_PAGE_PATH, NEW_GRAD_PAGE_TITLE
        );

        blogPathTitleMap.forEach((path, title) -> singleBlogPage.navigate(path, title));
    }

    @Test
    @DisplayName("私たちについてページ、metaタグのdescriptionが正しい内容であること")
    void aboutPageHasCorrectMetaDescription(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);

        String expectMetaDescription = "Fintanを主催するTIS株式会社 テクノロジー＆イノベーション本部の組織紹介です。";
        singleBlogPage.checkMetaDescription(ABOUT_PAGE_PATH, expectMetaDescription);
    }


    @DisplayName("カテゴリ一覧ページ、metaタグのdescriptionが正しい内容であること")
    void categoryListPageHasCorrectMetaDescription(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);

        String expectMetaDescription = "Fintanに掲載している記事のカテゴリ一覧です。" + META_DESCRIPTION;
        singleBlogPage.checkMetaDescription(BLOG_CATEGORY_PAGE_PATH, expectMetaDescription);
    }


    @DisplayName("各おすすめ記事固定ページ、metaタグのdescriptionが正しい内容であること")
    void recommendPagesHaveCorrectMetaDescription(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);

        Map<String, String> recommendBlogPagePathTitleMap = Map.of(
            FOR_ARCHITECT_PAGE_PATH, FOR_ARCHITECT_PAGE_TITLE,
            FOR_FRONTEND_ENGINEER_PAGE_PATH, FOR_FRONTEND_ENGINEER_PAGE_TITLE,
            FOR_BACKEND_ENGINEER_PAGE_PATH, FOR_BACKEND_ENGINEER_PAGE_TITLE,
            FOR_MOBILE_ENGINEER_PAGE_PATH, FOR_MOBILE_ENGINEER_PAGE__TITLE,
            FOR_DESIGNER_PAGE_PATH, FOR_DESIGNER_PAGE_TITLE,
            FOR_NEW_BIZ_STARTER_PAGE_PATH, FOR_NEW_BIZ_STARTER_PAGE_TITLE
        );
        recommendBlogPagePathTitleMap.forEach((path, title) -> {
            String expectMetaDescription = title + "の記事一覧ページです。" + META_DESCRIPTION;
            singleBlogPage.checkMetaDescription(path, expectMetaDescription);
        });
    }

    @Test
    @DisplayName("新卒向け紹介ページ、metaタグのdescriptionが正しい内容であること")
    void newGradPageHasCorrectMetaDescription(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);

        String expectMetaDescription = "Fintanでは技術情報以外にも、活動発信として職場紹介・働き方紹介記事も公開しています。就職活動中の学生さんに向けて、TISのエンジニア組織の職場・働き方を知っていただけるような記事を厳選しました。";
        singleBlogPage.checkMetaDescription(NEW_GRAD_PAGE_PATH, expectMetaDescription);
    }


    @DisplayName("各おすすめ記事固定ページ、及び新卒向け紹介ページ、h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        SingleBlogPage singleBlogPage = new SingleBlogPage(page);
        Map<String, String> blogPagePathTitleMap = Map.of(
            FOR_ARCHITECT_PAGE_PATH, FOR_ARCHITECT_PAGE_TITLE,
            FOR_FRONTEND_ENGINEER_PAGE_PATH, FOR_FRONTEND_ENGINEER_PAGE_TITLE,
            FOR_BACKEND_ENGINEER_PAGE_PATH, FOR_BACKEND_ENGINEER_PAGE_TITLE,
            FOR_MOBILE_ENGINEER_PAGE_PATH, FOR_MOBILE_ENGINEER_PAGE__TITLE,
            FOR_DESIGNER_PAGE_PATH, FOR_DESIGNER_PAGE_TITLE,
            FOR_NEW_BIZ_STARTER_PAGE_PATH, FOR_NEW_BIZ_STARTER_PAGE_TITLE,
            NEW_GRAD_PAGE_PATH, NEW_GRAD_PAGE_TITLE
        );

        blogPagePathTitleMap.forEach((path, title) -> singleBlogPage.checkH1Tag(path, title));
    }
}
