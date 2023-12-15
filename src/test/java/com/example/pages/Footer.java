package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Footer {

    private final Fintan fintan = Fintan.getInstance();

    private final Page page;

    public Footer(Page page) {
        this.page = page;
    }

    /**
     * 記事の総一覧リストのリンクをクリックする。
     * /page/に遷移する。
     */
    public void clickAllPostListLink() {
        page.locator("text=記事の総一覧リスト").click();
        assertThat(page).hasURL(fintan.pageUrl());
    }

    /**
     * 当サイトのご利用にあたってをクリックする。
     */
    public void clickTermsOfUseForThisSite() {
        page.locator("footer >> text=当サイトのご利用にあたって").click();
        // ページのURLが期待通りであることを確認
        String expectedUrl = "https://fintan.jp/page/303/"; // 期待されるURLを直接指定
        String actualUrl = page.url();
        assertEquals(expectedUrl, actualUrl);
    }

    /**
     * 商標についてのリンクをクリックする。
     */
    public void clickAboutTrademarksLink() {
        page.locator("footer >> text=商標について").click();
        // ページのURLが期待通りであることを確認
        String expectedUrl = "https://fintan.jp/page/1622/"; // 期待されるURLを直接指定
        String actualUrl = page.url();
        assertEquals(expectedUrl, actualUrl);
    }

    /**
     * ライセンスのリンクをクリックする。
     */
    public void clickLicenseLink() {
        page.locator("footer a[href='https://fintan.jp/page/295/']").click();
        // ページのURLが期待通りであることを確認
        String expectedUrl = "https://fintan.jp/page/295/"; // 期待されるURLを直接指定
        String actualUrl = page.url();
        assertEquals(expectedUrl, actualUrl);
    }

    /**
     * 個人情報保護方針のリンクをクリックする。
     */
    public void clickPrivacyPolicyLink() {
        // 新しいタブを検知するためのリスナーを設定
        List<Page> newPages = new ArrayList<>();
        page.context().onPage(page -> newPages.add(page));

        // footer内の「個人情報保護方針」テキストを持つリンクをクリック
        page.locator("footer >> text=個人情報保護方針").click();

        // 新しいタブが開くのを待つ
        page.waitForTimeout(5000); // 必要に応じてタイムアウトを調整

        // 新しいタブが開かれたか確認
        if (newPages.isEmpty()) {
            throw new IllegalStateException("No new page was opened");
        }

        // 新しいタブの参照を取得
        Page newTab = newPages.get(0);

        // 新しいタブのページURLを取得
        String actualUrl = newTab.url();

        // ページのURLが期待通りであることを確認
        String expectedUrl = "https://www.tis.co.jp/privacypolicy/";
        assertEquals(expectedUrl, actualUrl);
    }

    /**
     * 情報セキュリティ方針のリンクをクリックする。
     */
    public void clickInformationSecurityPolicyLink() {
        // 新しいタブを検知するためのリスナーを設定
        List<Page> newPages = new ArrayList<>();
        page.context().onPage(page -> newPages.add(page));

        page.locator("footer >> text=情報セキュリティ方針").click();

        // 新しいタブが開くのを待つ
        page.waitForTimeout(5000); // 必要に応じてタイムアウトを調整

        // 新しいタブが開かれたか確認
        if (newPages.isEmpty()) {
            throw new IllegalStateException("No new page was opened");
        }

        // 新しいタブの参照を取得
        Page newTab = newPages.get(0);

        // 新しいタブのページURLを取得
        String actualUrl = newTab.url();

        // ページのURLが期待通りであることを確認
        String expectedUrl = "https://www.tis.co.jp/tis_securitypolicy/";
        assertEquals(expectedUrl, actualUrl);
    }

    /**
     * 個人情報の取り扱いについてのリンクをクリックする。
     */
    public void clickHandlingOfPersonalInformationLink() {
        // 新しいタブを検知するためのリスナーを設定
        List<Page> newPages = new ArrayList<>();
        page.context().onPage(page -> newPages.add(page));

        page.locator("footer >> text=個人情報の取り扱いについて").click();

        // 新しいタブが開くのを待つ
        page.waitForTimeout(5000); // 必要に応じてタイムアウトを調整

        // 新しいタブが開かれたか確認
        if (newPages.isEmpty()) {
            throw new IllegalStateException("No new page was opened");
        }

        // 新しいタブの参照を取得
        Page newTab = newPages.get(0);

        // 新しいタブのページURLを取得
        String actualUrl = newTab.url();

        // ページのURLが期待通りであることを確認
        String expectedUrl = "https://www.tis.co.jp/privacy/";
        assertEquals(expectedUrl, actualUrl);
    }

    public void checkOrganizationIntroductionTitleDomElement() {
        Locator titleDivElement = page.locator(".o-footer__intro .left div").first();
        assertThat(titleDivElement).hasClass("o-title o-title--white");
    }
}
