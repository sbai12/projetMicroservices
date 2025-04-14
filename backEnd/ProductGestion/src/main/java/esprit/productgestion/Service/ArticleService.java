package esprit.productgestion.Service;

import esprit.productgestion.entity.Article;

import java.util.List;

public interface ArticleService {
    Article addArticle(Article article);
    Article updateArticle(int id, Article article);
    List<Article> getAllArticles();
    Article getArticleById(int id);
    void deleteArticle(int id);
}