package com.example.codeclan.week15Project.NewsFeed.Repositories.JournalistRepository;


import com.example.codeclan.week15Project.NewsFeed.Models.Article;
import com.example.codeclan.week15Project.NewsFeed.Models.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class JournalistRepositoryImpl implements JournalistRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Article> getAllArticlesForJournalist(Long journalistId){
        List<Article> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.eq("journalist.id", journalistId));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Transactional
    public List<Category> getAllCategoriesForJournalist(Long journalistId){
        List<Category> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Category.class);
            cr.createAlias("articles", "article");
            cr.createAlias("article.article", "article");
            cr.add(Restrictions.eq("journalist.id", journalistId));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
