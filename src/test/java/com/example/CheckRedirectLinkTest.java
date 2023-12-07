package com.example;

import com.example.config.EnabledOnEnvironment;
import com.example.pages.BlogDetailPage;
import com.example.pages.Fintan;
import com.example.playwright.PlaywrightExtension;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@ExtendWith(PlaywrightExtension.class)
@Disabled("リンク修正作業の結果確認が終了したので")
public class CheckRedirectLinkTest {
    private Fintan fintan = Fintan.getInstance();

    // checkInternalLink系のテストは記事内の内部リンクが修正されてから正しい遷移先URLであるかどうかをチェックするため
    // 例：「/?p=6634」は旧サイトURL、実際に「/page/233/」にリダイレクトしているため、「/page/233/に修正する

    // １記事の１URLを１テストにしている
    // 例：checkInternalLinkForPage1599()は「/page/1599/」の記事内の1つ目の対象URLに対するテスト
    // 例：checkInternalLinkForPage1599_1()は「/page/1599/」の記事内の2つ目の対象URLに対するテスト
    // 例：checkInternalLinkForPage1599_2()は「/page/1599/」の記事内の3つ目の対象URLに対するテスト

    @DisplayName("「/page/1599/」の記事の内部リンクが「/?p=6634」ではなく「/page/233/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1599(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1599");
        page.locator("text=本記事では NablarchアプリをAzureで動かした事例の紹介 で構築する一部の手順をTerraformで自動化しています。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/233/"));

        blogDetailPage.navigate("1599");
        page.locator("text=NablarchアプリをAzureで動かした事例の紹介").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Container Registryにレジストリを作成").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#upload-docker-image-to-azure-container-registry"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Blob Storage").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-blob-storage"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Database for PostgreSQL").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-database-for-postgresql"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Cache for Redis").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-cache-for-redis"));

        blogDetailPage.navigate("1599");
        page.locator("text=アプリケーションのDockerイメージを作成する").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-a-docker-image-of-the-application"));

        blogDetailPage.navigate("1599");
        page.locator("text=DockerイメージをAzure Container Registryにアップロードする").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#upload-docker-image-to-azure-container-registry"));

        blogDetailPage.navigate("1599");
        page.locator("text=App Serviceでコンテナーインスタンスを作成する").first().click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-a-container-instance-with-app-service"));

        blogDetailPage.navigate("1599");
        page.locator("a:has-text(\"動作確認\")").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#cperation-check"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Container Registryにレジストリを作成").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#upload-docker-image-to-azure-container-registry"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Blob Storage").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-blob-storage"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Database for PostgreSQL").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-database-for-postgresql"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Cache for Redis").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-cache-for-redis"));

        blogDetailPage.navigate("1599");
        page.locator("text=Azure Database for PostgreSQL").nth(2).click();
        assertThat(page).hasURL(fintan.url("/page/233/#azure-database-for-postgresql"));

        blogDetailPage.navigate("1599");
        page.locator("text=アプリケーションのDockerイメージを作成する 「DockerイメージをAzure Container Registryにアップロードする」までの手順を手動で >> a").click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-a-docker-image-of-the-application"));

        blogDetailPage.navigate("1599");
        page.locator("text=backendのURLを設定する").click();
        assertThat(page).hasURL(fintan.url("/page/233/#set-the-backend-url"));

        blogDetailPage.navigate("1599");
        page.locator("text=DockerイメージをAzure Container Registryにアップロードする 「App Serviceでコンテナーインスタンスを作成する」までの手順 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/233/#upload-docker-image-to-azure-container-registry"));

        blogDetailPage.navigate("1599");
        page.locator("text=App Serviceでコンテナーインスタンスを作成する").nth(2).click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-a-container-instance-with-app-service"));

        blogDetailPage.navigate("1599");
        page.locator("text=「各Webアプリを作成する 」 までの手順を手動で行います。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-each-web-app"));

        blogDetailPage.navigate("1599");
        page.locator("text=「環境変数を設定する 」 の手順は、ターミナルからAzure CLIで一括登録できるようにしました。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/233/#set-environment-variables"));

        blogDetailPage.navigate("1599");
        page.locator("text=環境変数を設定する").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#set-environment-variables"));

        blogDetailPage.navigate("1599");
        page.locator("text=各Webアプリを作成する").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-each-web-app"));

        blogDetailPage.navigate("1599");
        page.locator("text=環境変数を設定する").nth(2).click();
        assertThat(page).hasURL(fintan.url("/page/233/#set-environment-variables"));

        blogDetailPage.navigate("1599");
        page.locator("text=各Webアプリを作成する").nth(2).click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-each-web-app"));

        blogDetailPage.navigate("1599");
        page.locator("text=環境変数を設定する").nth(3).click();
        assertThat(page).hasURL(fintan.url("/page/233/#set-environment-variables"));

        blogDetailPage.navigate("1599");
        page.locator("text=各Webアプリを作成する").nth(3).click();
        assertThat(page).hasURL(fintan.url("/page/233/#create-each-web-app"));

        blogDetailPage.navigate("1599");
        page.locator("text=動作確認 の手順を行います。 このようにAzureでもTerraformでウェブアプリケーション開発に必要な環境構築の一部の作業を省力化することが出来ます。 執 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/233/#cperation-check"));

    } 


    @DisplayName("「/page/1599/」の記事の内部リンクが「/?p=6330」ではなく「/page/1543/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1599_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        blogDetailPage.navigate("1599");
        page.locator("text=DevOps環境構築キット（Epona）").first().click();
        assertThat(page).hasURL(fintan.url("/page/1543/"));

        blogDetailPage.navigate("1599");
        page.locator("text=DevOps環境構築キット（Epona） の特長 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1543/"));

        blogDetailPage.navigate("1599");
        page.locator("text=本格的なDevOps環境の構築をご検討の際には、 DevOps環境構築キット（Epona） も選択肢に加えてみてください。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1543/"));

    }


    @DisplayName("「/page/424/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage424(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("424");
        page.locator("text=私の所属する西日本テクノロジー＆イノベーション室では、2020年9月末に「SPA + REST API構成のサービス開発リファレンス（以下サービス開発リファレン >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));

        blogDetailPage.navigate("424");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    } 


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=7525」ではなく「/page/248/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda JMeterの使い方").click();
        assertThat(page).hasURL(fintan.url("/page/248/"));

        blogDetailPage.navigate("255");
        page.locator("text=前回").click();
        assertThat(page).hasURL(fintan.url("/page/248/"));
    } 


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=7605」ではなく「/page/255/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda Enterprise Performance検証 ノードスペックを変化することによる性能変化").click();
        assertThat(page).hasURL(fintan.url("/page/255/"));
    } 


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=7525」ではなく「/page/248/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda JMeterの使い方").click();
        assertThat(page).hasURL(fintan.url("/page/248/"));
    }


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=7963」ではなく「/page/246/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda Enterprise Collaborative Recovery").click();
        assertThat(page).hasURL(fintan.url("/page/246/"));
    }


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=8009」ではなく「/page/231/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda Enterprise Archive Service").click();
        assertThat(page).hasURL(fintan.url("/page/231/"));
    }


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=8136」ではなく「/page/253/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda Firewallの設定方法").first().click();
        assertThat(page).hasURL(fintan.url("/page/253/"));
    }


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=8252」ではなく「/page/1874/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda re-issuance Tokens SDK and Accountsを利用した一括「re-issuance」").click();
        assertThat(page).hasURL(fintan.url("/page/1874/"));
    }


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=8359」ではなく「/page/1861/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda Time-windows").first().click();
        assertThat(page).hasURL(fintan.url("/page/1861/"));
    }


    @DisplayName("「/page/250/」の記事の内部リンクが「/?p=8440」ではなく「/page/1864/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage250_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("250");
        page.locator("text=Corda Oracle").click();
        assertThat(page).hasURL(fintan.url("/page/1864/"));
    }


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=7963」ではなく「/page/246/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda Enterprise Collaborative Recovery").click();
        assertThat(page).hasURL(fintan.url("/page/246/"));
    }


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=8252」ではなく「/page/1874/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda re-issuance Tokens SDK and Accountsを利用した一括「re-issuance」").click();
        assertThat(page).hasURL(fintan.url("/page/1874/"));
    }


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=8009」ではなく「/page/231/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda Enterprise Archive Service").click();
        assertThat(page).hasURL(fintan.url("/page/231/"));
    }


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=8359」ではなく「/page/1861/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda Time-windows").first().click();
        assertThat(page).hasURL(fintan.url("/page/1861/"));
    }


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=8440」ではなく「/page/1864/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda Oracle").click();
        assertThat(page).hasURL(fintan.url("/page/1864/"));
    }


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=8136」ではなく「/page/253/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda Firewallの設定方法").first().click();
        assertThat(page).hasURL(fintan.url("/page/253/"));
    }


    @DisplayName("「/page/259/」の記事の内部リンクが「/?p=304」ではなく「/page/314/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage259(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("259");
        page.locator("a:has-text(\"Nablarchアプリケーションフレームワーク\")").click();
        assertThat(page).hasURL(fintan.url("/page/314/"));
    } 


    @DisplayName("「/page/255/」の記事の内部リンクが「/?p=7695」ではなく「/page/250/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage255_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("255");
        page.locator("text=Corda Tokens SDK and Accounts").click();
        assertThat(page).hasURL(fintan.url("/page/250/"));
    }


    @DisplayName("「/page/299/」の記事の内部リンクが「/?page_id=201」ではなく「/page/295/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage299(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("299");
        page.locator("text=ライセンスページ").click();
        assertThat(page).hasURL(fintan.url("/page/295/"));
    } 


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=6078」ではなく「/page/424/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=サービス開発リファレンスを使ってWebアプリケーションを作成してみよう＜導入編＞").first().click();
        assertThat(page).hasURL(fintan.url("/page/424/"));
    } 


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=6161」ではなく「/page/426/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=サービス開発リファレンスを使ってREST APIを1つ作成してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/426/"));
    }


    @DisplayName("「/page/424/」の記事の内部リンクが「/?p=6122」ではなく「/page/430/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage424_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("424");
        page.locator("text=次回").click();
        assertThat(page).hasURL(fintan.url("/page/430/"));
    }


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=6333」ではなく「/page/421/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=サービス開発リファレンスを使ってバリデーションしてみよう").click();
        assertThat(page).hasURL(fintan.url("/page/421/"));
    }


    @DisplayName("「/page/189/」の記事の内部リンクが「/?p=4865」ではなく「/page/175/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage189(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("189");
        page.locator("text=ステージ・ゲートプロセスに基づく新規事業開発").click();
        assertThat(page).hasURL(fintan.url("/page/175/"));
    } 


    @DisplayName("「/page/189/」の記事の内部リンクが「/?p=141」ではなく「/page/257/」のようなものであること")
    void checkInternalLinkForPage189_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("189");
        page.locator("text=1 2 3 4 >> a").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/189/2/"));
        page.locator("text=^1").click();
        assertThat(page).hasURL(fintan.url("/page/257/"));
    }


    @DisplayName("「/page/373/」の記事の内部リンクが「/?p=1256」ではなく「/page/374/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage373(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("373");
        page.locator("text=このドキュメントは、SPA＋REST APIのシステム構成例（AWS）のアプリケーションの認証部分にフォーカスして記載したものです。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/374/"));

        blogDetailPage.navigate("373");
        page.locator("text=SPA＋REST APIのシステム構成例（AWS） – 背景").click();
        assertThat(page).hasURL(fintan.url("/page/374/#user-content-%E8%83%8C%E6%99%AF"));
    } 


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=6353」ではなく「/page/418/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=サービス開発リファレンスを使ってファイルダウンロードを実装してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/418/"));
    }


    @DisplayName("「/page/1631/」の記事の内部リンクが「/?p=7300」ではなく「/page/1629/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1631(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1631");
        page.locator("text=＜ エンジニアに「効く」デザイントレーニングについてはこちらから").click();
        assertThat(page).hasURL(fintan.url("/page/1629/"));
    } 


    @DisplayName("「/page/1614/」の記事の内部リンクが「/?p=1377」ではなく「/page/538/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1614(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1614");
        page.locator("text=我々が実践した内容は、 『複数ロケーションに跨るチームでのリモート開発実践ガイド』 にまとめています。こちらも併せてご参照頂けますと幸いです。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/538/"));

        blogDetailPage.navigate("1614");
        page.locator("text=前述の『複数ロケーションに跨るチームでのリモート開発実践ガイド』にも記載していますが、 リモート開発に必要とされるマインドセットがあると考えており、それを日々実 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/538/"));
    } 


    @DisplayName("「/page/1614/」の記事の内部リンクが「/?p=4551」ではなく「/page/379/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1614_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);
        blogDetailPage.navigate("1614");
        page.locator("text=『新人目線で語る職場の雰囲気レポートIN大阪』").click();
        assertThat(page).hasURL(fintan.url("/page/379/"));
    }


    @DisplayName("「/page/387/」の記事の内部リンクが「/?p=6330」ではなく「/page/1543/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage387(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("387");
        page.locator("text=DevOps環境構築キットEpona").click();
        assertThat(page).hasURL(fintan.url("/page/1543/"));
    } 


    @DisplayName("「/page/506/」の記事の内部リンクが「/?p=7039」ではなく「/page/518/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage506(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("506");
        page.locator("text=まとめると、Active Learingはアノテーションの負担を軽減するため、モデルの精度を保ちながら、データ量を削減する技術です。Active Learnin >> a").click();
        assertThat(page).hasURL(fintan.url("/page/518/"));

        blogDetailPage.navigate("506");
        page.locator("text=系列ラベリングにおけるActive Learningでも挙げたように、自然言語処理用のActive Learningツールはいくつか存在します。しかし、そのほと >> a").click();
        assertThat(page).hasURL(fintan.url("/page/518/"));

        blogDetailPage.navigate("506");
        page.locator("text=コードとActive Learningのサイクルを照らし合わせると、わかりやすくなります。ここはActive Learningのサイクルを簡単に紹介します。詳し >> a").click();
        assertThat(page).hasURL(fintan.url("/page/518/"));

        blogDetailPage.navigate("506");
        page.locator("text=系列ラベリングにおけるActive Learning").nth(3).click();
        assertThat(page).hasURL(fintan.url("/page/518/"));
    } 


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6414」ではなく「/page/428/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスを使ってCSRF対策をしてみよう").first().click();
        assertThat(page).hasURL(fintan.url("/page/428/"));
    } 


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6078」ではなく「/page/424/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスを使ってWebアプリケーションを作成してみよう＜導入編＞").click();
        assertThat(page).hasURL(fintan.url("/page/424/"));
    }


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6122」ではなく「/page/430/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスを使って1画面作成してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/430/"));
    }


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6161」ではなく「/page/426/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスを使ってREST APIを1つ作成してみよう").first().click();
        assertThat(page).hasURL(fintan.url("/page/426/"));
    }


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6333」ではなく「/page/421/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスを使ってバリデーションしてみよう").click();
        assertThat(page).hasURL(fintan.url("/page/421/"));
    }


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6353」ではなく「/page/418/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスを使ってファイルダウンロードを実装してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/418/"));
    }

    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6433」ではなく「/page/432/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=サービス開発リファレンスの方式設計ガイドを使ってみよう").click();
        assertThat(page).hasURL(fintan.url("/page/432/"));
    }


    @DisplayName("「/page/446/」の記事の内部リンクが「/?p=6161」ではなく「/page/426/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage446_8(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("446");
        page.locator("text=「サービス開発リファレンスを使ってREST APIを1つ作成してみよう」").click();
        assertThat(page).hasURL(fintan.url("/page/426/#frontend"));
    }



    @DisplayName("「/page/214/」の記事の内部リンクが「/?p=5946」ではなく「/page/503/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage214(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("214");
        page.locator("text=Lerna は高い可用性とスループットが求められるシステムを、クラウドを始めとするオープンな環境で構築するためのソフトウェアスタックです。そのコンテンツの1つと >> a").first().click();
        assertThat(page).hasURL(fintan.url("/page/503/"));
    } 


    @DisplayName("「/page/467/」の記事の内部リンクが「/?p=4053」ではなく「/page/1639/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage467(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("467");
        page.locator("text=サービス開発を進めていた西日本テクノロジー＆イノベーション室の浦上によるセッションです。 本セッションでは開発体制や進め方などをお話しました。 技術スタックにつ >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1639/"));
    } 


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=6433」ではなく「/page/432/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=次回").click();
        assertThat(page).hasURL(fintan.url("/page/432/"));
    }


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/428/」の記事の内部リンクが「/?p=6122」ではなく「/page/430/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage428_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("428");
        page.locator("text=サービス開発リファレンスを使って1画面作成してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/430/"));
    }


    @DisplayName("「/page/503/」の記事の内部リンクが「/?p=7061」ではなく「/page/214/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage503(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("503");
        page.locator("text=バッチ並列化ベンチマークレポート").click();
        assertThat(page).hasURL(fintan.url("/page/214/"));

        blogDetailPage.navigate("503");
        page.locator("text=Lernaでバッチ処理を並列化したらリニアに速くなるか検証してみた（Fintan）").click();
        assertThat(page).hasURL(fintan.url("/page/214/"));
    } 


    @DisplayName("「/page/503/」の記事の内部リンクが「/?p=7256」ではなく「/page/223/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage503_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("503");
        page.locator("text=※ベンチマークテストにおける前提条件、スコアの詳細は「Lernaの可用性と処理能力」参照 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/223/"));

        blogDetailPage.navigate("503");
        page.locator("text=ベンチマークレポート Lernaの可用性と処理能力を計測したベンチマークレポート >> a").click();
        assertThat(page).hasURL(fintan.url("/page/223/"));
    }


    @DisplayName("「/page/334/」の記事の内部リンクが「/?p=4234」ではなく「/page/252/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage334(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("334");
        page.locator("text=Nablarchシステム開発ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/252/"));
    } 


    @DisplayName("「/page/334/」の記事の内部リンクが「/?p=304」ではなく「/page/314/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage334_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("334");
        page.locator("text=Nablarchは、企業情報システム(エンタープライズシステム)開発のために包括的に設計されたJavaアプリケーション開発⁄実行基盤です。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/314/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=1323」ではなく「/page/317/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=アプリケーション方式設計書サンプル").click();
        assertThat(page).hasURL(fintan.url("/page/317/"));
    } 


    @DisplayName("「/page/1611/」の記事の内部リンクが「/?p=141」ではなく「/page/257/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1611(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1611");
        page.locator("text=スキルマップ運用ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/257/"));
    } 


    @DisplayName("「/page/1717/」の記事の内部リンクが「/?page_id=5803&lang=en」ではなく「/en/page/1890/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1717(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1717");
        page.locator("text=Fintan Content License Terms And Conditions").click();
        assertThat(page).hasURL(fintan.url("/en/page/1890/"));
    } 


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=8039」ではなく「/page/259/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("a:has-text(\"トレーニングコンテンツ\")").click();
        assertThat(page).hasURL(fintan.url("/page/259/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=4234」ではなく「/page/252/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=Nablarchシステム開発ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/252/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=869」ではなく「/page/1455/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=サービス開発のエンジニアリングガイド").click();
        assertThat(page).hasURL(fintan.url("/page/1455/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=233」ではなく「/page/1672/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=要件定義フレームワーク").click();
        assertThat(page).hasURL(fintan.url("/page/1672/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=45」ではなく「/page/1456/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=テスト種別＆観点カタログ").click();
        assertThat(page).hasURL(fintan.url("/page/1456/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=251」ではなく「/page/1458/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=全体テスト計画ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/1458/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=1323」ではなく「/page/317/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=方式設計書サンプル").click();
        assertThat(page).hasURL(fintan.url("/page/317/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=335」ではなく「/page/1540/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_8(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("text=Collaborage（チーム開発環境構築テンプレート）").click();
        assertThat(page).hasURL(fintan.url("/page/1540/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=4234」ではなく「/page/252/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_9(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("a:has-text(\"3\")").click();
        assertThat(page).hasURL(fintan.url("/page/1868/3/"));

        page.locator("text=Nablarchシステム開発ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/252/"));
    }


    @DisplayName("「/page/1868/」の記事の内部リンクが「/?p=8039」ではなく「/page/259/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1868_10(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1868");
        page.locator("a:has-text(\"3\")").click();
        assertThat(page).hasURL(fintan.url("/page/1868/3/"));

        page.locator("text=ウォーターフォール開発における各工程毎に、使えるNablarchのコンテンツと、その活用方法が紹介されています。 ガイド内に各ドキュメントのリンクがありますが、 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/259/"));
    }


    @DisplayName("「/page/387/」の記事の内部リンクが「/?p=6156」ではなく「/page/392/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage387_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("387");
        page.locator("text=さて本題です。 会津大生向けにハンズオンを行いましたので、その内容をお伝えします。 このハンズオンはシリーズで行いました。開催経緯については会津大生向けにSPA >> a").click();
        assertThat(page).hasURL(fintan.url("/page/392/"));
    }


    @DisplayName("「/page/2685/」の記事の内部リンクが「/?p=7708」ではなく「/page/191/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage2685(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("2685");
        page.locator("a:has-text(\"Split Brain Resolver\")").click();
        assertThat(page).hasURL(fintan.url("/page/191/#split-brain-resolver"));

        blogDetailPage.navigate("2685");
        page.locator("text=アプリケーションの起動・停止シーケンスの調整").click();
        assertThat(page).hasURL(fintan.url("/page/191/#application-start-stop-sequence"));
    } 


    @DisplayName("「/page/1532/」の記事の内部リンクが「/?p=6186」ではなく「/page/1572/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1532(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1532");
        page.locator("text=※この開発時に扱った技術は「JWEとJWSによる暗号化の実装」として事例を公開しています。 JOSEのJWE, JWSを使った暗号化の具体的な実装方法にも触れて >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1572/"));

        blogDetailPage.navigate("1532");
        page.locator("text=このように基本的な用語も調べながら、改めて鍵の生成と取り込み方法を調査した結果、「JWEとJWSによる暗号化の実装」で紹介した処理を実現することが出来ました。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1572/"));
    } 


    @DisplayName("「/page/376/」の記事の内部リンクが「/?p=4920」ではなく「/page/1524/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage376(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("376");
        page.locator("text=デザイナー＆エンジニア協業で得たTIPS").click();
        assertThat(page).hasURL(fintan.url("/page/1524/"));
    } 


    @DisplayName("「/page/341/」の記事の内部リンクが「/?p=5234」ではなく「/page/355/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage341(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("341");
        page.locator("text=iPhoneでバーチャルキーボード表示時に固定要素が画面外に消える問題を解決する").click();
        assertThat(page).hasURL(fintan.url("/page/355/"));
    } 


    @DisplayName("「/page/340/」の記事の内部リンクが「/?p=5593」ではなく「/page/338/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage340(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("340");
        page.locator("text=Amazon Cognito User Pool を用いたWebサービスにおけるユーザー管理・運用の事例にあるように、ユーザー認証や管理には外部の認証基盤を利用 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/338/"));
    } 


    @DisplayName("「/page/424/」の記事の内部リンクが「/?p=6010」ではなく「/page/412/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage424_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("424");
        page.locator("text=サービス開発リファレンスを利用してWebサービスのプロトタイプを開発しました").click();
        assertThat(page).hasURL(fintan.url("/page/412/"));
    }


    @DisplayName("「/page/280/」の記事の内部リンクが「/?p=949」ではなく「/page/265/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage280(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("280");
        page.locator("text=Fintan – スクラム概論").first().click();
        assertThat(page).hasURL(fintan.url("/page/265/"));

        blogDetailPage.navigate("280");
        page.locator("text=振り返りアクション Fintan – スクラム概論を用いて、私たちからPOの上長を含む顧客に対してスクラムの考え方を説明した。 双方の置かれた状況に当て嵌めなが >> a").click();
        assertThat(page).hasURL(fintan.url("/page/265/"));
    } 


    @DisplayName("「/page/1639/」の記事の内部リンクが「/?p=3648」ではなく「/page/359/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1639(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1639");
        page.locator("text=React+APIでのOAuth2.0認証").first().click();
        assertThat(page).hasURL(fintan.url("/page/359/"));

        blogDetailPage.navigate("1639");
        page.locator("text=詳しい内容に関してはReact+APIでのOAuth2.0認証を参照して下さい。 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/359/"));
    } 


    @DisplayName("「/page/1639/」の記事の内部リンクが「/?p=3561」ではなく「/page/465/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1639_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1639");
        page.locator("text=Swaggerを利用したUI開発").click();
        assertThat(page).hasURL(fintan.url("/page/465/"));
    }


    @DisplayName("「/page/456/」の記事の内部リンクが「/?p=3561」ではなく「/page/465/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage456(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("456");
        page.locator("text=UI開発にSwaggerで作ったmockサーバーを使う").click();
        assertThat(page).hasURL(fintan.url("/page/465/"));
    } 


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=4551」ではなく「/page/379/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「新人目線で語る職場の雰囲気レポートIN大阪」").click();
        assertThat(page).hasURL(fintan.url("/page/379/"));
    } 


    @DisplayName("「/page/328/」の記事の内部リンクが「/?p=3654」ではなく「/page/330/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage328(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("328");
        page.locator("text=ハンズオンイベント").click();
        assertThat(page).hasURL(fintan.url("/page/330/"));
    } 


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=233」ではなく「/page/1672/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=要件定義フレームワーク").click();
        assertThat(page).hasURL(fintan.url("/page/1672/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=335」ではなく「/page/1540/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Collaborage（チーム開発環境構築テンプレート）").click();
        assertThat(page).hasURL(fintan.url("/page/1540/"));
    } 


    @DisplayName("「/page/1427/」の記事の内部リンクが「/?p=869」ではなく「/page/1455/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1427(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1427");
        page.locator("text=Fintan – サービス開発のエンジニアリングガイド").click();
        assertThat(page).hasURL(fintan.url("/page/1455/"));
    } 


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=5349」ではなく「/page/1545/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「2ヶ月間フル在宅勤務でチーム開発しました」").click();
        assertThat(page).hasURL(fintan.url("/page/1545/"));
    }


    @DisplayName("「/page/177/」の記事の内部リンクが「/?p=8092」ではなく「/page/189/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage177(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("177");
        page.locator("text=アップサイクル事業").first().click();
        assertThat(page).hasURL(fintan.url("/page/189/"));
    } 


    @DisplayName("「/page/384/」の記事の内部リンクが「/?p=4655」ではなく「/page/1565/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage384(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("384");
        page.locator("text=Dockerコンテナ上のJenkinsでコンテナをたててテストを実行する").click();
        assertThat(page).hasURL(fintan.url("/page/1565/"));
    } 


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=5045」ではなく「/page/376/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「短納期でフロントエンド開発をして得た知見」").click();
        assertThat(page).hasURL(fintan.url("/page/376/"));
    }


    @DisplayName("「/page/1536/」の記事の内部リンクが「/?p=7155」ではなく「/page/344/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1536(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1536");
        page.locator("text=AWS Management Consoleのログインをメール通知する").click();
        assertThat(page).hasURL(fintan.url("/page/344/"));
    } 


    @DisplayName("「/page/456/」の記事の内部リンクが「/?p=3563」ではなく「/page/362/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage456_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("456");
        page.locator("text=ReactでAPI通信をしている間Loading画面を表示する").click();
        assertThat(page).hasURL(fintan.url("/page/362/"));
    }


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=5064」ではなく「/page/352/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「FIWAREのデータをElastic Stackで可視化する」").click();
        assertThat(page).hasURL(fintan.url("/page/352/"));
    }


    @DisplayName("「/page/1629/」の記事の内部リンクが「/?p=7300&page=3」ではなく「/page/1633/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1629(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1629");
        page.locator("text=最短でダサい画面とサヨナラする方法 前編").click();
        assertThat(page).hasURL(fintan.url("/page/1633/"));
    } 


    @DisplayName("「/page/177/」の記事の内部リンクが「/?p=8105」ではなく「/page/181/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage177_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("177");
        page.locator("text=Tomory").click();
        assertThat(page).hasURL(fintan.url("/page/181/"));
    }


    @DisplayName("「/page/471/」の記事の内部リンクが「/?p=3578」ではなく「/page/1636/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage471(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("471");
        page.locator("text=Architecture Decision Records導入事例").click();
        assertThat(page).hasURL(fintan.url("/page/1636/"));
    } 


    @DisplayName("「/page/374/」の記事の内部リンクが「/?p=1266」ではなく「/page/1608/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage374(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("374");
        page.locator("text=モニタリング、監視、ログ収集の実践例（AWS）").first().click();
        assertThat(page).hasURL(fintan.url("/page/1608/"));
    } 


    @DisplayName("「/page/384/」の記事の内部リンクが「/?p=6028」ではなく「/page/1590/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage384_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("384");
        page.locator("text=フレームワーク開発").click();
        assertThat(page).hasURL(fintan.url("/page/1590/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6536」ではなく「/page/446/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=バックエンドはサービス開発リファレンスを使って、フロントエンドは自前で作成してみた").first().click();
        assertThat(page).hasURL(fintan.url("/page/446/"));
    } 


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6078」ではなく「/page/424/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスを使ってWebアプリケーションを作成してみよう＜導入編＞").click();
        assertThat(page).hasURL(fintan.url("/page/424/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6122」ではなく「/page/430/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスを使って1画面作成してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/430/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6161」ではなく「/page/426/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスを使ってREST APIを1つ作成してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/426/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6333」ではなく「/page/421/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスを使ってバリデーションしてみよう").click();
        assertThat(page).hasURL(fintan.url("/page/421/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6353」ではなく「/page/418/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスを使ってファイルダウンロードを実装してみよう").click();
        assertThat(page).hasURL(fintan.url("/page/418/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6414」ではなく「/page/428/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスを使ってCSRF対策をしてみよう").first().click();
        assertThat(page).hasURL(fintan.url("/page/428/"));
    }


    @DisplayName("「/page/438/」の記事の内部リンクが「/?p=6433」ではなく「/page/432/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage438_8(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("438");
        page.locator("text=サービス開発リファレンスの方式設計ガイドを使ってみよう").click();
        assertThat(page).hasURL(fintan.url("/page/432/"));
    }


    @DisplayName("「/page/393/」の記事の内部リンクが「/?p=5168」ではなく「/page/336/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage393(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("393");
        page.locator("text=2019年度TISインターンシップ in 会津 (企画実践プログラミングコース)").first().click();
        assertThat(page).hasURL(fintan.url("/page/336/"));
    } 


    @DisplayName("「/page/384/」の記事の内部リンクが「/?p=6070」ではなく「/page/385/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage384_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("384");
        page.locator("text=他部門に対する技術支援").click();
        assertThat(page).hasURL(fintan.url("/page/385/"));
    }


    @DisplayName("「/page/358/」の記事の内部リンクが「/?p=4161」ではなく「/page/460/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage358(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("358");
        page.locator("text=詳細はWebアプリケーションのパフォーマンスチューニング事例（Python）参照 >> a").click();
        assertThat(page).hasURL(fintan.url("/page/460/"));

        blogDetailPage.navigate("358");
        page.locator("text=Webアプリケーションのパフォーマンスチューニング事例（Python）- Redisでメモリを大量消費").click();
        assertThat(page).hasURL(fintan.url("/page/460/#user-content-Redis%E3%81%A7%E3%83%A1%E3%83%A2%E3%83%AA%E3%82%92%E5%A4%A7%E9%87%8F%E6%B6%88%E8%B2%BB"));


    } 


    @DisplayName("「/page/2157/」の記事の内部リンクが「/?p=5187」ではなく「/page/383/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage2157(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("2157");
        page.locator("text=https://fintan.jp/?p=5187").click();
        assertThat(page).hasURL(fintan.url("/page/383/"));
    } 


    @DisplayName("「/page/332/」の記事の内部リンクが「/?p=5956」ではなく「/page/1441/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage332(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("332");
        page.locator("text=Zoomを利用したリモート形式の新人研修実施の事例").click();
        assertThat(page).hasURL(fintan.url("/page/1441/"));
    } 


    @DisplayName("「/page/384/」の記事の内部リンクが「/?p=6208」ではなく「/page/1532/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage384_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("384");
        page.locator("text=鍵ファイルの生成と取得で色々調べた話").click();
        assertThat(page).hasURL(fintan.url("/page/1532/"));
    }


    @DisplayName("「/page/384/」の記事の内部リンクが「/?p=6010」ではなく「/page/412/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage384_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("384");
        page.locator("text=リファレンス実装の公開").click();
        assertThat(page).hasURL(fintan.url("/page/412/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=969」ではなく「/page/1435/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Springアプリ開発ノウハウ集").first().click();
        assertThat(page).hasURL(fintan.url("/page/1435/"));

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Springアプリ開発ノウハウ集").first().click();
        assertThat(page).hasURL(fintan.url("/page/1435/"));

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Springアプリ開発ノウハウ集").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/1435/"));
    }


    @DisplayName("「/page/1629/」の記事の内部リンクが「/?p=7300&page=4」ではなく「/page/1635/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1629_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1629");
        page.locator("text=最短でダサい画面とサヨナラする方法 後編").click();
        assertThat(page).hasURL(fintan.url("/page/1635/"));
    }


    @DisplayName("「/page/455/」の記事の内部リンクが「/?p=5926」ではなく「/page/458/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage455(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("455");
        page.locator("text=イベントレポート").nth(3).click();
        assertThat(page).hasURL(fintan.url("/page/458/"));
    } 


    @DisplayName("「/page/424/」の記事の内部リンクが「/?p=5934」ではなく「/page/436/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage424_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("424");
        page.locator("text=サービス開発リファレンスのハンズオンを作成した話").first().click();
        assertThat(page).hasURL(fintan.url("/page/436/"));
    }


    @DisplayName("「/page/456/」の記事の内部リンクが「/?p=3565」ではなく「/page/348/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage456_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("456");
        page.locator("text=Data URI形式の画像をS3へ保存してURLを取得する").click();
        assertThat(page).hasURL(fintan.url("/page/348/"));
    }


    @DisplayName("「/page/471/」の記事の内部リンクが「/?p=4116」ではなく「/page/93/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage471_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("471");
        page.locator("text=AndroidアプリのUIテスト自動化事例").click();
        assertThat(page).hasURL(fintan.url("/page/93/"));
    }


    @DisplayName("「/page/393/」の記事の内部リンクが「/?p=5151」ではなく「/page/334/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage393_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("393");
        page.locator("text=2019年度TISインターンシップ in 会津 (Nablarch開発体験コース)").first().click();
        assertThat(page).hasURL(fintan.url("/page/334/"));
    }


    @DisplayName("「/page/393/」の記事の内部リンクが「/?p=304」ではなく「/page/314/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage393_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("393");
        page.locator("text=Nablarch、Lernaなど >> a").first().click();
        assertThat(page).hasURL(fintan.url("/page/314/"));
    }


    @DisplayName("「/page/393/」の記事の内部リンクが「/?p=5946」ではなく「/page/503/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage393_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("393");
        page.locator("article >> text=Lerna").click();
        assertThat(page).hasURL(fintan.url("/page/503/"));
    }


    @DisplayName("「/page/393/」の記事の内部リンクが「/?p=1145」ではなく「/page/286/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage393_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("393");
        page.locator("text=Nablarch開発標準").click();
        assertThat(page).hasURL(fintan.url("/page/286/"));
    }


    @DisplayName("「/page/471/」の記事の内部リンクが「/?p=1857」ではなく「/page/357/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage471_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("471");
        page.locator("text=JJUG CCC 2019 Springで登壇してきました！").click();
        assertThat(page).hasURL(fintan.url("/page/357/"));
    }


    @DisplayName("「/page/455/」の記事の内部リンクが「/?p=5840」ではなく「/page/329/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage455_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("455");
        page.locator("text=イベントレポート").nth(2).click();
        assertThat(page).hasURL(fintan.url("/page/329/"));
    }


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=5288」ではなく「/page/341/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「AWS Amplifyを用いたオンラインチャットアプリのバックエンド開発ブログ」").click();
        assertThat(page).hasURL(fintan.url("/page/341/"));
    }


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=4920」ではなく「/page/1524/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「デザイナー&エンジニア協業で得た TIPS」").click();
        assertThat(page).hasURL(fintan.url("/page/1524/"));
    }


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=5593」ではなく「/page/338/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「Amazon Cognito User Pool を用いたWebサービスにおけるユーザー管理・運用の事例」").click();
        assertThat(page).hasURL(fintan.url("/page/338/"));
    }


    @DisplayName("「/page/458/」の記事の内部リンクが「/?p=5234」ではなく「/page/355/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage458_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("458");
        page.locator("text=「iPhoneでバーチャルキーボード表示時に固定要素が画面外に消える問題を解決する」").click();
        assertThat(page).hasURL(fintan.url("/page/355/"));
    }


    @DisplayName("「/page/456/」の記事の内部リンクが「/?p=3639」ではなく「/page/1729/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage456_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("456");
        page.locator("text=関ジャバ’19 8月度 イベントレポート").click();
        assertThat(page).hasURL(fintan.url("/page/1729/"));
    }


    @DisplayName("「/page/280/」の記事の内部リンクが「/?p=687」ではなく「/page/269/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage280_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("280");
        page.locator("text=Fintan – スプリント開始条件チェックリスト").click();
        assertThat(page).hasURL(fintan.url("/page/269/"));
    }


    @DisplayName("「/page/233/」の記事の内部リンクが「/?p=6043」ではなく「/page/1443/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage233(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("233");
        page.locator("text=Nablarchには、2020年9月29日にリリースされた5u18でクラウドネイティブ対応というものが入っています。 これは、NablarchをAWSやAzur >> a").click();
        assertThat(page).hasURL(fintan.url("/page/1443/"));
    } 


    @DisplayName("「/page/233/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage233_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("233");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/280/」の記事の内部リンクが「/?p=1251」ではなく「/page/267/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage280_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("280");
        page.locator("text=Fintan – スプリントの見通し確認ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/267/"));
    }


    @DisplayName("「/page/177/」の記事の内部リンクが「/?p=8204」ではなく「/page/244/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage177_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("177");
        page.locator("text=インサイドセールス事業").click();
        assertThat(page).hasURL(fintan.url("/page/244/"));
    }


    @DisplayName("「/page/1629/」の記事の内部リンクが「/?p=7300&page=2」ではなく「/page/1631/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1629_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1629");
        page.locator("text=SEとデザイナーの思考の違いから学ぶ画面デザインの基礎講座").click();
        assertThat(page).hasURL(fintan.url("/page/1631/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=1339」ではなく「/page/1556/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=Azure DevOpsを活用したCI（ビルドパイプライン）の構築例 – 背景").click();
        assertThat(page).hasURL(fintan.url("/page/1556/#user-content-background"));
    } 


    @DisplayName("「/page/341/」の記事の内部リンクが「/?p=4801」ではなく「/page/343/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage341_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("341");
        page.locator("text=なお、GraphQLの有用性の詳細な説明がFintanのAWS AppSync(GraphQL)を用いたバックエンドの構築事例に掲載されています。ご興味があれば >> a").click();
        assertThat(page).hasURL(fintan.url("/page/343/"));
    }


    @DisplayName("「/page/280/」の記事の内部リンクが「/?p=280」ではなく「/page/274/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage280_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("280");
        page.locator("text=Fintan – ワーキングアグリーメント").click();
        assertThat(page).hasURL(fintan.url("/page/274/"));
    }


    @DisplayName("「/page/177/」の記事の内部リンクが「/?p=8102」ではなく「/page/179/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage177_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("177");
        page.locator("text=SDGs事業").first().click();
        assertThat(page).hasURL(fintan.url("/page/179/"));
    }


    @DisplayName("「/page/177/」の記事の内部リンクが「/?p=4865」ではなく「/page/175/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage177_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("177");
        page.locator("text=「ステージ・ゲートプロセスに基づく新規事業開発」").click();
        assertThat(page).hasURL(fintan.url("/page/175/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=251」ではなく「/page/1458/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=全体テスト計画ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/1458/"));
    }


    @DisplayName("「/page/456/」の記事の内部リンクが「/?p=3559」ではなく「/page/346/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage456_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("456");
        page.locator("text=ContextAPIを使ってメッセージをローカライズ").click();
        assertThat(page).hasURL(fintan.url("/page/346/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=5403&lang=en」ではなく「/en/page/1667/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Nablarch System Development Guide").click();
        assertThat(page).hasURL(fintan.url("/en/page/1667/"));
    } 


    @DisplayName("「/page/1715/」の記事の内部リンクが「/?p=6243&lang=en」ではなく「/en/page/1721/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1715(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1715");
        page.locator("text=Fintan – Programmers Self Checklist").click();
        assertThat(page).hasURL(fintan.url("/en/page/1721/"));
    } 


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=6785&lang=en」ではなく「/en/page/1683/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Overall Test Plan Guide").click();
        assertThat(page).hasURL(fintan.url("/en/page/1683/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=8039」ではなく「/page/259/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Training Content *").click();
        assertThat(page).hasURL(fintan.url("/page/259/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=869」ではなく「/page/1455/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Engineering Guide For Service Development *").click();
        assertThat(page).hasURL(fintan.url("/page/1455/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Service Development reference for SPA + REST API configuration *").click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=233」ではなく「/page/1672/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Requirements Definition Framework *").click();
        assertThat(page).hasURL(fintan.url("/page/1672/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=45」ではなく「/page/1456/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Test Type & Viewpoint Catalog *").click();
        assertThat(page).hasURL(fintan.url("/page/1456/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=1323」ではなく「/page/317/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Application Architecture Design Document Sample *").click();
        assertThat(page).hasURL(fintan.url("/page/317/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=335」ではなく「/page/1540/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_8(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("text=Collaborage *").click();
        assertThat(page).hasURL(fintan.url("/page/1540/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=5403&lang=en」ではなく「/page/1667/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_9(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("a:has-text(\"3\")").click();
        assertThat(page).hasURL(fintan.url("/en/page/1954/3/"));

        page.locator("text=Nablarch System Development Guide.").click();
        assertThat(page).hasURL(fintan.url("/en/page/1667/"));
    }


    @DisplayName("「/page/1954/」の記事の内部リンクが「/?p=8039」ではなく「/page/259/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1954_10(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1954");
        page.locator("a:has-text(\"3\")").click();
        assertThat(page).hasURL(fintan.url("/en/page/1954/3/"));

        page.locator("text=Training Contents(Only Japanese Edition)").click();
        assertThat(page).hasURL(fintan.url("/page/259/"));
    }


    @DisplayName("「/page/181/」の記事の内部リンクが「/?p=5950」ではなく「/page/164/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage181(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("181");
        page.locator("li:nth-child(3) > .post-page-numbers").click();
        assertThat(page).hasURL(fintan.url("/page/181/3/"));

        page.locator("text=モバイルアプリケーションのセキュリティと認証").click();
        assertThat(page).hasURL(fintan.url("/page/164/"));
    } 


    @DisplayName("「/page/181/」の記事の内部リンクが「/?p=6997」ではなく「/page/163/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage181_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("181");
        page.locator("li:nth-child(3) > .post-page-numbers").click();
        assertThat(page).hasURL(fintan.url("/page/181/3/"));

        page.locator("text=テストのためのモバイルアプリケーション配布").click();
        assertThat(page).hasURL(fintan.url("/page/163/"));
    }


    @DisplayName("「/page/181/」の記事の内部リンクが「/?p=4865」ではなく「/page/175/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage181_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("181");
        page.locator("text=ステージ・ゲートプロセス").click();
        assertThat(page).hasURL(fintan.url("/page/175/"));
    }


    @DisplayName("「/page/181/」の記事の内部リンクが「/?p=141」ではなく「/page/257/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage181_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("181");
        page.locator("li:nth-child(2) > .post-page-numbers").click();
        assertThat(page).hasURL(fintan.url("/page/181/2/"));

        page.locator("text=スキルマップ運用ガイド | Fintan").click();
        assertThat(page).hasURL(fintan.url("/page/257/"));
    }


    @DisplayName("「/page/181/」の記事の内部リンクが「/?p=4865」ではなく「/page/175/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage181_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("181");
        page.locator("text=6").nth(3).click();
        assertThat(page).hasURL(fintan.url("/page/181/6/"));

        page.locator("text=ステージ・ゲートプロセスに基づく新規事業開発").click();
        assertThat(page).hasURL(fintan.url("/page/175/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=5513&lang=en」ではなく「/en/page/1717/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Role assignment sheet for waterfall development").click();
        assertThat(page).hasURL(fintan.url("/en/page/1717/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=233」ではなく「/page/1672/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Requirements definition framework").click();
        assertThat(page).hasURL(fintan.url("/page/1672/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=1389」ではなく「/page/1674/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Requirements definition basic training text").click();
        assertThat(page).hasURL(fintan.url("/page/1674/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=1323」ではなく「/page/317/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Sample document of application architecture design").click();
        assertThat(page).hasURL(fintan.url("/page/317/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=6785&lang=en」ではなく「/en/page/1683/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Overall test plan guide").click();
        assertThat(page).hasURL(fintan.url("/en/page/1683/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=45」ではなく「/page/1456/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Test type and viewpoint catalog").click();
        assertThat(page).hasURL(fintan.url("/page/1456/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=1369」ではなく「/page/1440/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=Deliverables self-check list for programmers").click();
        assertThat(page).hasURL(fintan.url("/page/1440/"));
    }


    @DisplayName("「/page/1667/」の記事の内部リンクが「/?p=45」ではなく「/page/1456/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1667_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1667");
        page.locator("text=7").click();
        assertThat(page).hasURL(fintan.url("/en/page/1667/7/"));

        page.locator("text=test type and test viewpoint catalog").click();
        assertThat(page).hasURL(fintan.url("/page/1456/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=1326」ではなく「/page/1436/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=ウォーターフォール開発における役割分担シート").click();
        assertThat(page).hasURL(fintan.url("/page/1436/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1273」ではなく「/page/1428/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – フルスタックエンジニア育成に関する取り組み").click();
        assertThat(page).hasURL(fintan.url("/page/1428/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1172」ではなく「/page/1534/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – 結合テスト自動化事例").click();
        assertThat(page).hasURL(fintan.url("/page/1534/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1334」ではなく「/page/1550/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – AWSの開発者用ツールを活用したCI/CD構成例").click();
        assertThat(page).hasURL(fintan.url("/page/1550/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=1244」ではなく「/page/272/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_1(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=プロダクトオーナーの役割").click();
        assertThat(page).hasURL(fintan.url("/page/272/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1216」ではなく「/page/1527/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – 性能テスト自動化事例").click();
        assertThat(page).hasURL(fintan.url("/page/1527/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1387」ではなく「/page/373/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – SPA＋REST APIにおけるセッションを使った認証の実践例").click();
        assertThat(page).hasURL(fintan.url("/page/373/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1375」ではなく「/page/397/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – ヘキサゴナルアーキテクチャ導入事例").click();
        assertThat(page).hasURL(fintan.url("/page/397/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=1389」ではなく「/page/1674/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=要件定義基礎研修テキスト").click();
        assertThat(page).hasURL(fintan.url("/page/1674/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=239」ではなく「/page/309/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_2(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=Doneの定義").click();
        assertThat(page).hasURL(fintan.url("/page/309/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1371」ではなく「/page/1427/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_8(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – フルスタックエンジニアの成熟度モデル").click();
        assertThat(page).hasURL(fintan.url("/page/1427/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1383」ではなく「/page/278/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_9(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Azure Boardsを使用したスクラム実践例").click();
        assertThat(page).hasURL(fintan.url("/page/278/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=230」ではなく「/page/262/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_3(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=スクラム開発プラクティス集").click();
        assertThat(page).hasURL(fintan.url("/page/262/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=687」ではなく「/page/269/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_4(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=スプリント開始条件チェックリスト").click();
        assertThat(page).hasURL(fintan.url("/page/269/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=949」ではなく「/page/265/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=スクラム概論").click();
        assertThat(page).hasURL(fintan.url("/page/265/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=280」ではなく「/page/274/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=ワーキングアグリーメント").click();
        assertThat(page).hasURL(fintan.url("/page/274/"));
    }


    @DisplayName("「/page/278/」の記事の内部リンクが「/?p=948」ではなく「/page/311/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage278_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("278");
        page.locator("text=スプリント運営ガイド").click();
        assertThat(page).hasURL(fintan.url("/page/311/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=1367」ではなく「/page/1433/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_5(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=PG・UT作業の完了条件チェックリスト").click();
        assertThat(page).hasURL(fintan.url("/page/1433/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1385」ではなく「/page/366/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_10(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Reactを使ったフロントエンドのアーキテクチャ事例").click();
        assertThat(page).hasURL(fintan.url("/page/366/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=1369」ではなく「/page/1440/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_6(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=プログラマー向け成果物セルフチェックリスト").click();
        assertThat(page).hasURL(fintan.url("/page/1440/"));
    }


    @DisplayName("「/page/252/」の記事の内部リンクが「/?p=45」ではなく「/page/1456/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage252_7(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("252");
        page.locator("text=7").click();
        assertThat(page).hasURL(fintan.url("/page/252/7/"));

        page.locator("text=テスト種別＆テスト観点カタログ").click();
        assertThat(page).hasURL(fintan.url("/page/1456/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1381」ではなく「/page/99/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_11(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Android開発におけるモジュール化手法").click();
        assertThat(page).hasURL(fintan.url("/page/99/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1256」ではなく「/page/374/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_12(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – SPA＋REST APIのシステム構成例（AWS）").click();
        assertThat(page).hasURL(fintan.url("/page/374/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1266」ではなく「/page/1608/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_13(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – モニタリング、監視、ログ収集の実践例（AWS）").click();
        assertThat(page).hasURL(fintan.url("/page/1608/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=869」ではなく「/page/1455/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_14(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=クラウドネイティブなアプリケーションの開発").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/1455/2/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=5952」ではなく「/page/1453/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_15(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").first().click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));

        blogDetailPage.navigate("1455");
        page.locator("text=SPA + REST API構成のサービス開発リファレンス").nth(1).click();
        assertThat(page).hasURL(fintan.url("/page/1453/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=1339」ではなく「/page/1556/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_16(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("text=Fintan – Azure DevOpsを活用したCI（ビルドパイプライン）の構築例").click();
        assertThat(page).hasURL(fintan.url("/page/1556/"));
    }


    @DisplayName("「/page/1455/」の記事の内部リンクが「/?p=969」ではなく「/page/1435/」のようなものであること")
    @EnabledOnEnvironment(production = true, reason = "テスト環境の記事内容が本番に追いついてない為")
    void checkInternalLinkForPage1455_17(Page page) {
        BlogDetailPage blogDetailPage = new BlogDetailPage(page);

        blogDetailPage.navigate("1455");
        page.locator("a:has-text(\"2\")").click();
        assertThat(page).hasURL(fintan.url("/page/1455/2/"));

        page.locator("text=Fintan – Springアプリ開発ノウハウ集").click();
        assertThat(page).hasURL(fintan.url("/page/1435/"));
    }
}
