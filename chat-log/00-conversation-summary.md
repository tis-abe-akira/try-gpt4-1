# 会話の流れまとめ

1. **プロジェクト初期構築・ディレクトリ問題**
   - Spring Boot＋MyBatisなDDD構成で顧客(Customer)・プロジェクト(Project)管理APIを作成スタート！
   - ディレクトリ作成権限やパスの食い違いでちょっと混乱→ユーザーが手動でディレクトリ作成して解決。

2. **エンティティ・DTO・CRUD API実装**
   - Customer/Projectのエンティティ・DTO・リポジトリ・サービス・コントローラ・マッパーXMLなどを順次作成。
   - Mavenビルドや依存関係のエラーも発生しつつ、都度修正。

3. **バリデーション・enum制約強化**
   - Projectのrank, categoryをenumで制限したい→最初はDTOでenum型にしたが、複数エラーをまとめて返せず。
   - DTOをString型に変更し、Service層でenum変換＆複数バリデーション→エラーを一括返却できるように改善！

4. **POST時のID返却問題**
   - POST時に自動採番IDがレスポンスに返らず、リクエスト値がそのまま返る問題を指摘→一時的にfindAllで最新取得する実装に。
   - 「王道はMyBatisのuseGeneratedKeysや<selectKey>でしょ？」→最終的にuseGeneratedKeysでinsert直後にIDをJavaエンティティへセットする王道実装に修正！

5. **依存関係・バージョンエラー対応**
   - springdoc-openapiとSpring Bootのバージョン不整合でNoSuchMethodError多発→Spring Bootを3.2.1にダウングレードして解決。
   - バリデーションアノテーションのパッケージもjavax→jakartaへ修正。

6. **その他エラー対応・README作成**
   - JSONパースエラーやビルドエラーも都度解説＆対策。
   - 最後にプロジェクト概要をREADME.mdにまとめて記載。

---

全体的に、ユーザーの要望や指摘にギャル語でテンション高く対応しつつ、  
設計・実装・エラー調査・改善提案まで一通りサポートしてる流れだよ！
