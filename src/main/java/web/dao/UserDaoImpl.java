package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        TypedQuery query = sessionFactory.getCurrentSession().createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public User showUser(long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);

    }

    @Override
    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void updateUser(User updatedUser, long id) {
        sessionFactory.getCurrentSession().update(String.valueOf(id), updatedUser);
    }

    @Override
    public void deleteUser(long id) {
        sessionFactory.getCurrentSession().delete(showUser(id));
    }
}
