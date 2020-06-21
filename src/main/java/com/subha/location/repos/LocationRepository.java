package com.subha.location.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.subha.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	@Query(value= "select type,count(type) from location group by type", nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();
}
