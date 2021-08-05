package com.works.repostories;

import com.works.models.entities.StrogeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStrogeDetailRepostories extends JpaRepository<StrogeDetail,Integer> {

    Optional<StrogeDetail> findByStrogeIdAndActive(int id,boolean active);
}
