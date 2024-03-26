package domain;

import base.CommonUtil;

import java.util.ArrayList;

public class ArticleRepository {
    //키워드검색, 번호검색, 지우기, 업데이트, findAll, article저장
    CommonUtil commonUtil = new CommonUtil();
    ArrayList<Article> articlelist = new ArrayList<>();
    int latestId = 1;

    public ArrayList<Article> findkeyword(String keyword) {
        ArrayList<Article> searchlist = new ArrayList<>();
        for (int i = 0; i < articlelist.size(); i++) {
            Article article = articlelist.get(i);
            if (article.getTitle().contains(keyword)) {
                searchlist.add(article);
            }
        }
        return searchlist;
    }
    public Article findId(int id) {
        for (int i = 0; i < articlelist.size(); i++) {
            Article article = articlelist.get(i);
            if (article.getId() == id) {
                return article;
            }
        }
        return null;
    }
    public void deleteArticle(Article article) {
        articlelist.remove(article);
    }
    public void updateArticle(Article article, String newtitle, String newbody) {
        article.setTitle(newtitle);
        article.setBody(newbody);
    }
    public ArrayList<Article> findAll() {
        return articlelist;
    }
    public Article saveArticle(String title, String body) {
        Article article = new Article(latestId, title, body, 0, commonUtil.getDate());
        articlelist.add(article);
        latestId++;
        return article;
    }
}
