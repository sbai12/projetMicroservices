package esprit.productgestion.Service;

import esprit.productgestion.Repository.ArticleRepository;
import esprit.productgestion.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Article addArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(int id, Article article) {
        Optional<Article> optional = articleRepository.findById(id);
        if (optional.isPresent()) {
            Article existing = optional.get();
            existing.setArtdesign(article.getArtdesign());
            existing.setPrix(article.getPrix());
            existing.setQtestock(article.getQtestock());
            existing.setTauxremise(article.getTauxremise());
            existing.setArtimg(article.getArtimg());
            existing.setArtdesc(article.getArtdesc());
            existing.setArtcategory(article.getArtcategory());
            existing.setMarque(article.getMarque());
            return articleRepository.save(existing);
        }
        return null;
    }
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    public Article getArticleById(int id) {
        return articleRepository.findById(id).orElse(null);
    }
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
