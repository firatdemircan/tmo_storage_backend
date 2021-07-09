package com.works.repostories;

import com.works.models.entities.models.Stroge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStrogeRepostories extends JpaRepository<Stroge,Integer> {
}
