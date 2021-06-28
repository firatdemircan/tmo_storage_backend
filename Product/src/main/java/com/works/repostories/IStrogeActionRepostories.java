package com.works.repostories;

import com.works.models.entities.StrogeAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStrogeActionRepostories extends JpaRepository<StrogeAction,Integer> {
}
