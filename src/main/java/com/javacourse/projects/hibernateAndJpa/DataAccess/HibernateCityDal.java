package com.javacourse.projects.hibernateAndJpa.DataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.javacourse.projects.hibernateAndJpa.Entities.City;

@Repository
public class HibernateCityDal implements ICityDal {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//	public HibernateCityDal(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//    
    
    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City", City.class).getResultList();
        return cities;
    }

    @Override
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void update(City city) {
    	 Session session = entityManager.unwrap(Session.class);
         session.saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
   	 Session session = entityManager.unwrap(Session.class);
	 City cityToDelete = session.get(City.class, city.getId());  
   	 session.delete(cityToDelete);
    }

	@Override
	public City getById(int id) {
	 Session session = entityManager.unwrap(Session.class);
	 City city = session.get(City.class, id);  
	 return city;
	}
}
