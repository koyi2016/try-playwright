package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.AllBlogListPage;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PlaywrightExtension.class)
public class AllBlogListPageTest {
    private static final String META_DESCRIPTION = "Fintanは、TISインテックグループが研究開発や、システム開発、新規事業開発のプロジェクトで培ったノウハウを集約したサイトです。";

    @DisplayName("記事の総一覧リストページのタイトルが正しい内容であること")
    void checkTitle(Page page) {
        AllBlogListPage allBlogListPage = new AllBlogListPage(page);
        allBlogListPage.navigate();
    }


    @DisplayName("metaタグのdescriptionが正しい内容であること")
    void checkMetaDescription(Page page) {
        AllBlogListPage allBlogListPage = new AllBlogListPage(page);

        allBlogListPage.navigate();
        String expectMetaDescription = "記事の総一覧リストページです。" + META_DESCRIPTION;
        Locator metaDescription = allBlogListPage.getMetaDescription();
        // AIOSEOのプラグインにより、descriptionが複数になってしまうことがある
        assertThat(metaDescription).hasCount(1);
        String actualMetaDescription = metaDescription.first().getAttribute("content");
        assertEquals(expectMetaDescription, actualMetaDescription);
    }


    @DisplayName("h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        AllBlogListPage allBlogListPage = new AllBlogListPage(page);

        allBlogListPage.navigate();
        Locator h1Tag = page.locator("h1");
        assertThat(h1Tag).hasCount(1);
        assertThat(h1Tag).hasText("記事の総一覧リスト");
    }


    @DisplayName("テスト環境h2タグが正しい内容であること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境のカテゴリが本番に追いついてない為")
    void checkH2tagTestEnv(Page page) {
        AllBlogListPage allBlogListPage = new AllBlogListPage(page);
        String[] expectedH2TagTexts = new String[] {
            "その他", "アジャイル・スクラム", "エンジニア育成・学習",
            "セキュリティ・暗号化", "XR", "ソフトウェアテスティング", "ブロックチェーン",
            "モバイルアプリケーション開発", "環境構築・ログ・CI/ CD", "量子コンピュータ",
            "開発プロセス", "要件定義", "Lerna",
            "Nablarch", "UX/UIデザイン", "Webアプリケーション開発",
            "先進技術研究", "新規事業開発", "活動発信・イベントレポート"
        };
        allBlogListPage.navigate();
        Locator h2Tag = page.locator("h2");
        assertThat(h2Tag).hasCount(expectedH2TagTexts.length);
        assertThat(h2Tag).containsText(expectedH2TagTexts);
    }


    @DisplayName("本番環境h2タグが正しい内容であること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境のカテゴリが本番に追いついてない為")
    void checkH2tagProductionEnv(Page page) {
        AllBlogListPage allBlogListPage = new AllBlogListPage(page);
        String[]  expectedH2TagTexts = new String[] {
            "Webアプリケーション開発", "モバイルアプリケーション開発", "新規事業開発",
            "先進技術研究", "UX/UIデザイン", "XR",
            "ブロックチェーン", "Nablarch", "Lerna",
            "量子コンピュータ", "アジャイル・スクラム", "要件定義",
            "開発プロセス", "ソフトウェアテスティング", "環境構築・ログ・CI/ CD",
            "セキュリティ・暗号化", "エンジニア育成・学習", "活動発信・イベントレポート",
            "その他"
        };
        allBlogListPage.navigate();
        Locator h2Tag = page.locator("h2");
        assertThat(h2Tag).hasCount(expectedH2TagTexts.length);
        assertThat(h2Tag).containsText(expectedH2TagTexts);
    }
}
