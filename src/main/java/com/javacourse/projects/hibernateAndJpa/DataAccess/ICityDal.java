package com.javacourse.projects.hibernateAndJpa.DataAccess;

import java.util.List;
import com.javacourse.projects.hibernateAndJpa.Entities.City;

public interface ICityDal {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
}
