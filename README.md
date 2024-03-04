# SprinBoot 電商網站
此實作為模擬電商網站的功能練習。詳細的使用技術版本與功能如下。

## 使用技術與版本
1. Spring Boot version : 3.2.2
2. MySql version : 8.0.22
3. 開發環境工具 : IntelliJ IDEA
4. Java/JDK version : 17
5. Spring Boot Dao使用 JDBC。
6. 使用 RESTful 與 API Tester來設計 API
7. 使用 Thymeleaf 來呈現前端。

## 電商網站功能大綱
<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E5%AF%A6%E4%BD%9C%E5%85%A7%E5%AE%B9_2.png" height="200px" width="800px" />

## 詳細功能介紹 - 查詢商品列表
#### 使用 Thymeleaf 呈現首頁

<img src="https://github.com/WBCOHBO/springboot-mall/blob/a8659a4de854e97354f22d261b2e64c4c2c16d43/springboot-mall/img/Thymeleaf_%E5%95%86%E5%93%81%E5%88%97%E8%A1%A8.png" height="300px" width="1000px" />

#### 使用 enum類型來查詢分類

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E6%9F%A5%E8%A9%A2%E5%88%97%E8%A1%A8-3_%E7%94%A8enum%E9%A1%9E%E5%9E%8B%E4%BE%86%E6%9F%A5%E8%A9%A2%E5%88%86%E9%A1%9E.png" height="300px" width="800px" />

#### 使用關鍵字 + 分類來查詢商品列表

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E6%9F%A5%E8%A9%A2%E5%88%97%E8%A1%A8-5_%E6%9F%A5%E8%A9%A2%E6%A2%9D%E4%BB%B6(%E5%88%86%E9%A1%9E%2B%E9%97%9C%E9%8D%B5%E5%AD%97%E6%9F%A5%E8%A9%A2).png" height="300px" width="800px" />

#### 商品列表排序功能 - 依照價格來做降序排序

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E6%9F%A5%E8%A9%A2%E5%88%97%E8%A1%A8-6_%E6%8E%92%E5%BA%8F%E5%8A%9F%E8%83%BD.png" height="300px" width="800px" />

## 詳細功能介紹 - 商品的CRUD
#### 建立新商品 - 在 request body建立對應的資料數據，再回傳 response body來呈現建立的資料

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E5%BB%BA%E7%AB%8B%E6%96%B0%E5%95%86%E5%93%81-1.png" height="300px" width="800px" />

#### 查詢商品

<img src="https://github.com/WBCOHBO/springboot-mall/blob/a8659a4de854e97354f22d261b2e64c4c2c16d43/springboot-mall/img/Thymeleaf_%E5%95%86%E5%93%81%E6%9F%A5%E8%A9%A2.png" height="300px" width="1000px" />

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E5%95%86%E5%93%81%E6%9F%A5%E8%A9%A2-1.png" height="300px" width="800px" />

#### 修改商品 - 在 url輸入要修改的商品 ID，然後在 request body中輸入要修改的資料，最後再回傳 response body來呈現修改後的資料

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E4%BF%AE%E6%94%B9%E5%95%86%E5%93%81-1.png" height="300px" width="800px" />

#### 刪除商品 - 在 url輸入要刪除的商品 ID，Http狀態碼即回傳 204 No Content

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E5%95%86%E5%93%81%E5%88%AA%E9%99%A4%E5%8A%9F%E8%83%BD-2.png" height="300px" width="800px" />

## 詳細功能介紹 - 帳號功能
#### 註冊新帳號 - 檢查request body 註冊的 email，並隱藏返回的密碼

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E8%A8%BB%E5%86%8A%E6%96%B0%E5%B8%B3%E6%88%B6_%E9%9A%B1%E8%97%8F%E5%AF%86%E7%A2%BC.png" height="400px" width="800px" />

#### 使用 MD5 雜湊生成密碼

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E4%BD%BF%E7%94%A8MD5%E9%9B%9C%E6%B9%8A%E7%94%9F%E6%88%90%E5%AF%86%E7%A2%BC%E5%81%9A%E8%A8%BB%E5%86%8A%E8%88%87%E7%99%BB%E5%85%A5.png" height="100px" width="800px" />

#### 用戶登入 - 在 request body中輸入信箱與密碼，當信箱與密碼的 MD5 雜湊皆正確，即回傳 response body

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E7%94%A8%E6%88%B6%E7%99%BB%E5%85%A5.png" height="400px" width="800px" />

## 詳細功能介紹 - 訂單功能
#### 創建訂單 - 讀取 request body中建立的訂單資料，將訂單資料回傳至 response body

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E8%A8%82%E5%96%AE%E5%8A%9F%E8%83%BD-%E8%AE%80%E5%8F%96%E8%A8%82%E5%96%AE%E4%B8%AD%20order%E7%9A%84%E6%95%B8%E6%93%9A.png" height="400px" width="800px" />

#### 查詢訂單列表 - 在 url中輸入對應的 userId/orders，response body即回傳該 user 的訂單列表

<img src="https://github.com/WBCOHBO/springboot-mall/blob/f6ef6647d202a0863954d2fd1210c52636e29d07/springboot-mall/img/%E8%A8%82%E5%96%AE%E5%8A%9F%E8%83%BD-%E6%9F%A5%E8%A9%A2%E8%A8%82%E5%96%AE%E5%88%97%E8%A1%A8%E5%8A%9F%E8%83%BD.png" height="400px" width="800px" />
