package esprit.productgestion.restcontroller;


import esprit.productgestion.Service.ArticleService;
import esprit.productgestion.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable int id, @RequestBody Article article) {
        return articleService.updateArticle(id, article);
    }
    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleService.deleteArticle(id);
    }}

