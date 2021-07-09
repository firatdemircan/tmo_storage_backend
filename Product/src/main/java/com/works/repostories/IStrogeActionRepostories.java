package com.works.repostories;

import com.works.models.dtos.StrogeActionDto;
import com.works.models.entities.models.Product;
import com.works.models.entities.models.StrogeAction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStrogeActionRepostories extends JpaRepository<StrogeAction,Integer>, JpaSpecificationExecutor<StrogeAction> {

    List<StrogeActionDto> getAllByStrogeDetailId(int id);

    //using specifications

    
}
