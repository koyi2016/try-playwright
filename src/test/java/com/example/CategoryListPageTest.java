package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.CategoryListPage;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(PlaywrightExtension.class)
public class CategoryListPageTest {
    private static final String[] categoryNamesTestEnv = new String[]{
        "その他", "アジャイル・スクラム", "エンジニア育成・学習",
        "セキュリティ・暗号化", "XR", "ソフトウェアテスティング", "ブロックチェーン",
        "モバイルアプリケーション開発", "環境構築・ログ・CI/ CD", "量子コンピュータ",
        "開発プロセス", "要件定義", "Lerna",
        "Nablarch", "UX/UIデザイン", "Webアプリケーション開発",
        "先進技術研究", "新規事業開発", "活動発信・イベントレポート"
    };

    private static final String[] categoryNamesProductionEnv = new String[]{
        "アプリケーション開発事例", "モバイルアプリケーション開発", "アジャイル・スクラム",
        "ソフトウェアテスティング","開発プロセス","エンジニア育成・学習",
        "ITアーキテクチャ","Nablarchフレームワーク","Springノウハウ",
        "Extreal XRフレームワーク","Lerna 高可用スタック","先進技術研究",
        "Web3",  "量子コンピュータ", "Generative AI（生成系AI）",
        "新規事業開発","XR", "UI/UXデザイン",
        "活動発信・イベントレポート"
    };


    @DisplayName("カテゴリ一覧に正しい内容のカテゴリ一覧が表示されること（テスト環境）。また各カテゴリ名のdom要素がdivであること")
    @EnabledOnEnvironment(production = false, reason = "テスト環境のカテゴリが本番に追いついてない為")
    void categoryListIsCorrectTestEnv(Page page) {
        CategoryListPage categoryListPage = new CategoryListPage(page);
        categoryListPage.navigate();
        Locator categoryNameLinks = categoryListPage.getCategoryNameLinks();
        assertThat(categoryNameLinks).hasCount(categoryNamesTestEnv.length);
        assertThat(categoryNameLinks).containsText(categoryNamesTestEnv);
    }

    @Test
    @DisplayName("カテゴリ一覧に正しい内容のカテゴリ一覧が表示されること（本番環境）。また各カテゴリ名のdom要素がdivであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境のカテゴリが本番に追いついてない為")
    void categoryListIsCorrectProductionEnv(Page page) {
        CategoryListPage categoryListPage = new CategoryListPage(page);
        categoryListPage.navigate();
        Locator categoryNameLinks = categoryListPage.getCategoryNameLinks();
        List<String> categoryNamesWithNumbers = categoryNameLinks.allTextContents();
        List<String> categoryNamesWithoutNumbers = new ArrayList<>();

        for (String nameWithNumbers : categoryNamesWithNumbers) {
            // 数値とそれに続く括弧を削除します（例: "(48)"を削除）
            String nameWithoutNumbers = nameWithNumbers.replaceAll("\\(\\d+\\)$", "").trim();
            categoryNamesWithoutNumbers.add(nameWithoutNumbers);
        }

        assertThat(categoryNameLinks).hasCount(categoryNamesProductionEnv.length);
        // categoryNamesProductionEnvは期待されるカテゴリ名の配列
        for (String expectedName : categoryNamesProductionEnv) {
            boolean found = categoryNamesWithoutNumbers.contains(expectedName);
            if (!found) {
                throw new AssertionError("Expected name not found: " + expectedName);
            }
        }

    }


    @DisplayName("「記事一覧へ」で該当カテゴリのカテゴリトップに遷移できること")
    void clickAuthorIcon(Page page) {
        CategoryListPage categoryListPage = new CategoryListPage(page);
        categoryListPage.navigate();

        // 「記事一覧へ」リンク
        Locator blogListLink = categoryListPage.getBlogListLink();
        // 遷移先URL
        String destinationUrl = blogListLink.getAttribute("href");

        blogListLink.click();
        assertThat(page).hasURL(destinationUrl);
    }


    @DisplayName("h1タグが正しい内容であること")
    void checkH1Tag(Page page) {
        CategoryListPage categoryListPage = new CategoryListPage(page);
        categoryListPage.navigate();
        Locator h1Tag = page.locator("h1");
        assertThat(h1Tag).hasCount(1);
        assertThat(h1Tag).hasText("Category");
    }
    
    @DisplayName("カテゴリ一覧で表示される件数とカテゴリーページの記事数が一致すること")
    void checkCategoryPostCount(Page page) {
        CategoryListPage categoryListPage = new CategoryListPage(page);
        categoryListPage.navigate();

        Locator categories = categoryListPage.getCategoryNameLinks();
        for (int i = 0; i < categories.count(); i++) {
            Locator category = categories.nth(i);

            // カテゴリの合計記事数を取得する
            String content = category.textContent();
            // ()の中の数字を抽出
            Matcher matcher = Pattern.compile("(?<=\\().*?(?=\\))").matcher(content);
            assertTrue(matcher.find(), "content count not found. [" + content + "]");

            int sumCount = Integer.parseInt(matcher.group(0));

            // カテゴリトップページへ遷移し、表示されている記事の数をカウントする
            category.click();

            Locator postCards = page.locator("ul.o-card-list > li.o-card");
            postCards.first().waitFor();   // count()は0個であることもありえるので最初の要素をwaitする
            int postCount = postCards.count();

            assertEquals(sumCount, postCount, "count must be equal. [" + content + "]");

            // カテゴリ一覧ページへと戻る
            categoryListPage.navigate();
        }
    }
}
