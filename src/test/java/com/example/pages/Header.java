package com.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Header {

    private final Fintan fintan = Fintan.getInstance();

    private final Page page;

    public Header(Page page) {
        this.page = page;
    }

    /**
     * 検索アイコンをクリックする。
     * 検索パネルが表示される。
     */
    public void clickSearchIcon() {
        page.locator(".o-header__search > a").click();
        Locator keywordInput = getKeywordInput();
        assertThat(keywordInput).isVisible();
    }

    public void clickFintanLogo() {
        page.locator(".o-header__logo > a").click();
        assertThat(page).hasURL(fintan.url() + "/");
    }

    /**
     * 検索アイコンをクリックして表示してまたクリックで閉じる。
     * 検索パネルが表示されない。
     */
    public void clickToCloseSearchPanel() {
        Locator searchIcon = page.locator(".o-header__search > a");
        searchIcon.click();
        Locator keywordInput = getKeywordInput();
        assertThat(keywordInput).isVisible();

        searchIcon.click();
        assertThat(keywordInput).not().isVisible();
    }

    /**
     * キーワード検索を行う。
     * 入力したキーワードで検索し、検索画面が表示される。
     * @param keyword 入力するキーワード
     */
    public void searchKeyword(String keyword) {
        clickSearchIcon();

        Locator keywordInput = getKeywordInput();
        keywordInput.fill(keyword);
        keywordInput.click();
        page.locator("text=キーワードで探す 検索 >> button").click();
        assertThat(page).hasURL(fintan.url("/?s=" + keyword));
    }

    /**
     * ヘッダのカテゴリリンクからカテゴリ一覧ページに遷移する。
     */
    public void clickCategoryLink() {
        page.locator("a:has-text(\"Category カテゴリ\")").click();
        assertThat(page).hasURL(fintan.url("/blog-category/"));
    }

    /**
     * ヘッダの「私たちについて」をクリックする。
     */
    public void clickAboutUsLink() {
        page.locator("text=About us 私たちについて").click();
        assertThat(page).hasURL(fintan.url("/about/"));
    }

    /**
     * ヘッダのカテゴリリンクをマウスホバーする。
     */
    public void hoverCategoryLink() {
        Locator categoryLink = page.locator("text=Category カテゴリ");
        Locator categoryMenu = page.locator(".sub-menu.js-menu");
        assertThat(categoryMenu).not().isVisible();

        categoryLink.hover();
        assertThat(categoryMenu).isVisible();
    }

    private Locator getKeywordInput() {
        return page.locator("text=キーワードで探す 検索 >> [placeholder=\"気になるキーワードをいれてください\"]");
    }
}
