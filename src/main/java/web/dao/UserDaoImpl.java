package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

//    @PersistenceContext
//    private EntityManager entityManager;
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
        //return entityManager.find(User.class,id);
        //return entityManager.createQuery("SELECT u FROM User u where u.id = :id", User.class).getSingleResult();
    }

    @Override
    public void saveUser(User user) {
         sessionFactory.getCurrentSession().save(user);

    }

    @Override
    public void updateUser(User updatedUser, long id) {
        sessionFactory.getCurrentSession().update(String.valueOf(id), updatedUser);

        //Language == SQL
//        String UPDATE = "UPDATE User u SET u.name = :name, u.secondName = :secondName, " +
//                "u.age = :age, u.occupation = :occupation WHERE u.id = :id";
//        sessionFactory.getCurrentSession().createQuery(UPDATE).setParameter("name", updatedUser.getName())
//                .setParameter("secondName",updatedUser.getSecondName()).setParameter("age", updatedUser.getAge())
//                .setParameter("occupation", updatedUser.getOccupation()).executeUpdate();
    }

    @Override
    public void deleteUser(long id) {
        sessionFactory.getCurrentSession().delete(showUser(id));
    }
}
