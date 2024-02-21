package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.TopPage;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(PlaywrightExtension.class)
public class TopPageTest {

    private static final String FINTAN_PROD_URL = "https://fintan.jp";
    private static final String META_DESCRIPTION = "Fintanは、TISインテックグループが研究開発や、システム開発、新規事業開発のプロジェクトで培ったノウハウを集約したサイトです。研究成果や、PJ推進のプラクティス、要件定義/設計/プログラミング/テストといった作業のプラクティス、成果物のテンプレート/サンプル、各種開発ツールを提供します。Fintanは、どなたでも無償でご利用いただけます。";
    private static final int LATEST_BLOG_COUNT_TOP_PAGE = 32;

    private static final String[] categoryNamesTestEnv = new String[]{
        "その他", "アジャイル・スクラム", "エンジニア育成・学習",
        "セキュリティ・暗号化", "XR", "ソフトウェアテスティング", "ブロックチェーン",
        "モバイルアプリケーション開発", "環境構築・ログ・CI/ CD", "量子コンピュータ",
        "開発プロセス", "要件定義", "Lerna",
        "Nablarch", "UX/UIデザイン", "Webアプリケーション開発",
        "先進技術研究", "新規事業開発", "活動発信・イベントレポート"
    };

    private static final String[] categoryNamesProductionEnv = new String[]{
        "Webアプリケーション開発", "モバイルアプリケーション開発", "新規事業開発",
        "先進技術研究", "UX/UIデザイン", "XR", "Generative AI（生成系AI）",
        "ブロックチェーン", "Nablarch", "Lerna",
        "量子コンピュータ", "アジャイル・スクラム", "要件定義",
        "開発プロセス", "ソフトウェアテスティング", "環境構築・ログ・CI/ CD",
        "セキュリティ・暗号化", "エンジニア育成・学習", "活動発信・イベントレポート",
        "その他"
    };

    @Test
    @DisplayName("トップページからカテゴリ一覧ページに遷移できること")
    void clickCategoryLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.clickCategoryLink();
    }

    @Test
    @DisplayName("ヘッダから「私たちについて」をクリックしに画面遷移できること")
    void clickAboutUsLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.clickAboutUsLink();
    }

    @Test
    @DisplayName("トップページから記事一覧に遷移できること")
    void clickAllPostListLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickAllPostListLink();
    }

    @Test
    @DisplayName("当サイトのご利用にあたってに遷移できること")
    void clickTermsOfUseForThisSite (Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickTermsOfUseForThisSite();
    }

    @Test
    @DisplayName("商標についてに遷移できること")
    void clickAboutTrademarksLink  (Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickAboutTrademarksLink();
    }

    @Test
    @DisplayName("ライセンスに遷移できること")
    void clickLicenseLink (Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickLicenseLink();
    }

    @Test
    @DisplayName("個人情報保護方針に遷移できること")
    void clickPrivacyPolicyLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickPrivacyPolicyLink();
    }

    @Test
    @DisplayName("情報セキュリティ方針に遷移できること")
    void clickInformationSecurityPolicyLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickInformationSecurityPolicyLink();
    }

    @Test
    @DisplayName("個人情報の取り扱いについてに遷移できること")
    void clickHandlingOfPersonalInformation(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.clickHandlingOfPersonalInformationLink();
    }

    @Test
    @DisplayName("虫眼鏡から検索ウィンドウを開けること")
    void searchPanelOpen(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.clickSearchIcon();
    }

    @Test
    @DisplayName("c")
    void searchPanelClose(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.clickToCloseSearchPanel();
    }


    @DisplayName("横幅<=500px未満でハンバーガーメニューが出ること")
    void displayHamburgerMenu(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator hamburgerMenu = page.locator(".o-hamburger.js-hamburger");
        // デフォルトサイズが1280*720でハンバーガーメニューが出ない
        assertThat(hamburgerMenu).not().isVisible();

        topPage.setViewportSize(500, 1280);
        assertThat(hamburgerMenu).isVisible();

        // 横幅>500pxでハンバーガーメニューが出ない
        topPage.setViewportSize(501, 1280);
        assertThat(hamburgerMenu).not().isVisible();
    }


    @DisplayName("検索窓を表示した状態でハンバーガーメニューの表示と非表示を切り替えられること")
    void displayHamburgerMenuWithOpeningSearchPanel(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.clickSearchIcon();
        Locator hamburgerMenu = page.locator(".o-hamburger.js-hamburger");
        // デフォルトサイズが1280*720でハンバーガーメニューが出ない
        assertThat(hamburgerMenu).not().isVisible();

        topPage.setViewportSize(500, 1280);
        assertThat(hamburgerMenu).isVisible();
    }


    @DisplayName("下にスクロールした時ヘッダが上部に出ない。上にスクロールした時ヘッダが上部に出ること")
    void notDisplayHeaderWhenScrollDown(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator header = page.locator("header");
        assertThat(header).hasClass("o-header");
        // ページを下方向に200ピクセルをスクロールする
        page.mouse().wheel(0, 200);

        assertThat(header).hasClass("o-header fix-over");
        // ページを上方向に100ピクセルをスクロールする
        page.mouse().wheel(0, -100);
        assertThat(header).hasClass("o-header");

        page.mouse().wheel(0, -100);
        assertThat(header).hasClass("o-header state-top");
    }


    @DisplayName("記事リストの表示型が「タイル型とリスト型の間」に切り替えられること")
    void changeBetweenTileAndListDisplay(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        // 初期表示時、リスト型表示
        Locator listButton = page.locator(".o-card-switch__button.o-card-switch__button--list").first();
        assertThat(listButton).hasClass("o-card-switch__button o-card-switch__button--list js-view-switch_list is_active");

        Locator tileButton = page.locator(".o-card-switch__button.o-card-switch__button--icon").first();
        assertThat(tileButton).hasClass("o-card-switch__button o-card-switch__button--icon js-view-switch_icon");

        Locator blogList = page.locator("section.c-top__latest.js-limit-latest > .o-inner > .o-card-list");
        assertThat(blogList).hasClass("o-card-list o-card-list--list-view");

        // タイル表示ボタン押下後、タイル型表示となる
        tileButton.click();
        assertThat(listButton).hasClass("o-card-switch__button o-card-switch__button--list js-view-switch_list");
        assertThat(tileButton).hasClass("o-card-switch__button o-card-switch__button--icon js-view-switch_icon is_active");
        assertThat(blogList).hasClass("o-card-list");

        // リスト表示ボタン押下後、リスト表示に戻る
        listButton.click();
        assertThat(listButton).hasClass("o-card-switch__button o-card-switch__button--list js-view-switch_list is_active");
        assertThat(tileButton).hasClass("o-card-switch__button o-card-switch__button--icon js-view-switch_icon");
        assertThat(blogList).hasClass("o-card-list o-card-list--list-view");
    }

    @Test
    @DisplayName("最新記事の「もっと見る」をクリックすると記事が追加で表示されること")
    void readMore(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();

        Locator cards = topPage.getLatestArticleCards();
        assertThat(cards).hasCount(8);

        topPage.getLatestArticleReadMore().click();
        assertThat(cards).hasCount(8);
    }


    @DisplayName("最新記事の「短く表示する」をクリックすると記事が追加で表示されること")
    void displayBlogsShortly(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator readMoreButton = topPage.getLatestArticleReadMore();
        Locator cards = topPage.getLatestArticleCards();
        assertThat(cards).hasCount(8);

        // 毎回Clickで記事が8個増える
        readMoreButton.click();
        assertThat(cards).hasCount(16);

        readMoreButton.click();
        assertThat(cards).hasCount(24);

        // 記事が最大32個までに増える
        readMoreButton.click();
        assertThat(cards).hasCount(32);

        Locator displayShortlyButton = topPage.getLatestArticlesShortly();
        // 32個まで増えたら「短く表示する」ボタンが出てくる
        assertThat(displayShortlyButton).isVisible();
        displayShortlyButton.click();
        assertThat(cards).hasCount(8);
    }

    @Test
    @DisplayName("最新記事リストの記事にメインカテゴリ、タイトル、抜粋内容、タグ、著者アイコン、著者名、日付、いいね数が表示されていること")
    void blogDetailsArelVisible(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        // メインカテゴリ
        assertThat(page.locator("li.o-card > .o-card__content > a >.o-card__head > .o-card__category").first()).isVisible();
        // タイトル
        assertThat(page.locator("li.o-card > .o-card__content > a >.o-card__title").first()).isVisible();
        // 抜粋内容
        assertThat(page.locator("li.o-card > .o-card__content > a >.o-card__text").first()).isVisible();
        // タグ
        assertThat(page.locator("li.o-card > .o-card__content > .o-card__tag").first()).isVisible();
        // 著者アイコン
        assertThat(page.locator("li.o-card > .o-card__content > .o-card__user > .image").first()).isVisible();
        // 著者名
        assertThat(page.locator("li.o-card > .o-card__content > .o-card__user > .info > div").first()).isVisible();
        // 日付
        assertThat(page.locator("li.o-card > .o-card__content > .o-card__user > .info > .bottom > time").first()).isVisible();
        // いいね数
        assertThat(page.locator("li.o-card > .o-card__content > .o-card__user > .info > .bottom > .like").first()).isVisible();
    }

    @Test
    @DisplayName("最新記事リストの記事から一つの著者アイコンを押下し著者ページに遷移できること")
    void clickAuthorIcon(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();

        // 著者アイコン
        Locator authorIcon = page.locator("li.o-card > .o-card__content > .o-card__user > .image").first();
        authorIcon.click();
        // 遷移先URL
        String destinationUrl = page.locator("li.o-card > .o-card__content > .o-card__user > .image > a").first().getAttribute("href");
        assertThat(page).hasURL(destinationUrl);
    }

    @Test
    @DisplayName("リンク押下で該当記事に遷移できること")
    void clickBlogLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator blogLink = page.locator("li.o-card > .o-card__content > a").first();
        String destinationUrl = blogLink.getAttribute("href");
        blogLink.click();
        assertThat(page).hasURL(destinationUrl);
    }

    @Test
    @DisplayName("Fintanロゴを押下しトップページに遷移できること")
    void clickFintanLogo(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.clickFintanLogo();
    }


    @DisplayName("カテゴリリンクをホバーしてカテゴリ一覧が表示されること")
    void hoverCategoryLink(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.header.hoverCategoryLink();
    }


    @DisplayName("カテゴリリンクをホバーして正しい内容のカテゴリ一覧が表示されること")
    void categoryListIsCorrect(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator categoryMenuLinks = page.locator(".sub-menu.js-menu > ul > li > a");

        String[] expectedCategoryNames = categoryNamesTestEnv;
        if (topPage.fintan.url().equals(FINTAN_PROD_URL)) {
            expectedCategoryNames = categoryNamesProductionEnv;
        }
        assertThat(categoryMenuLinks).hasCount(expectedCategoryNames.length);
        assertThat(categoryMenuLinks).hasText(expectedCategoryNames);
    }


    @DisplayName("metaタグのdescriptionが正しい内容であること")
    void checkMetaDescription(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator metaDescription = topPage.getMetaDescription();
        // AIOSEOのプラグインにより、descriptionが複数になってしまうことがある
        assertThat(metaDescription).hasCount(1);
        String actualMetaDescription = metaDescription.first().getAttribute("content");
        assertEquals(META_DESCRIPTION, actualMetaDescription);
    }


    @DisplayName("h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator h2Tags = page.locator("h1");
        assertThat(h2Tags).containsText("FintanではTISインテックグループの技術ノウハウを公開しています。");
    }


    @DisplayName("h2タグが正しい内容であること")
    void checkH2Tag(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator h2Tags = page.locator("h2");
        String[] h2TagTexts = {"おすすめ記事", "カテゴリー", "最新記事", "人気記事", "お知らせ"};
        assertThat(h2Tags).hasCount(h2TagTexts.length);
        assertThat(h2Tags).containsText(h2TagTexts);
    }


    @DisplayName("（最新記事エリア）記事一覧の各記事タイトルのdom要素はdivであること")
    void checkBlogTileDomElement(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator titleDivElement = page.locator(".c-top__latest .o-card-list div.o-card__title");
        assertThat(titleDivElement).hasCount(LATEST_BLOG_COUNT_TOP_PAGE);
    }


    @DisplayName("鯖の魚の画像がwebpフォーマットの画像であること")
    void checkFishImageFormat(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator webpImageElement = page.locator(".c-top__main-fish img").first();
        String actualImageFilePath = webpImageElement.getAttribute("src");
        assertEquals(topPage.fintan.url() + "/wp-content/themes/fintan/img/top/main-fish.webp", actualImageFilePath);
    }


    @DisplayName("テスト環境で（最新記事エリア）記事一覧の各記事著者名のdom要素はdivであること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境の記事が本番に追いついてない為")
    @Disabled("テスト環境で著者のない（テスト用）新規記事が出る頻度が高く、都度修正するのが手間がかかるため")
    void checkBlogAuthorNameDomElementOnTestEnv(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator authorNameDivElement = page.locator(".c-top__latest li.o-card > .o-card__content > .o-card__user > .info > div");
        // 「.info > div」に著者名のdiv要素以外に、「div.bottom」の要素もあるため、div要素数＝記事数（LATEST_BLOG_COUNT_TOP_PAGEの32）*２
        //　ただ、テスト環境では著者のない記事が存在するため、実際にLATEST_BLOG_COUNT_TOP_PAGEの32になっていない
        // 2022-12-16時点で記事数＝29
        assertThat(authorNameDivElement).hasCount(58);
    }


    @DisplayName("本番環境で（最新記事エリア）記事一覧の各記事著者名のdom要素はdivであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事が本番に追いついてない為")
    void checkBlogAuthorNameDomElementOnProductionEnv(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        Locator authorNameDivElement = page.locator(".c-top__latest li.o-card > .o-card__content > .o-card__user > .info > div");
        // 「.info > div」に著者名のdiv要素以外に、「div.bottom」の要素もあるため、div要素数＝記事数（LATEST_BLOG_COUNT_TOP_PAGEの32）*２
        assertThat(authorNameDivElement).hasCount(LATEST_BLOG_COUNT_TOP_PAGE * 2);
    }


    @DisplayName("footerの組織紹介のタイトルはdom要素がdivであること")
    void checkOrganizationIntroductionDomElement(Page page) {
        TopPage topPage = new TopPage(page);
        topPage.navigate();
        topPage.footer.checkOrganizationIntroductionTitleDomElement();
    }
}
