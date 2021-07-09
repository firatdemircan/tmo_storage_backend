package com.works.models.entities.models;

import com.works.models.entities.BaseEntity;
import com.works.models.entities.enums.IslemTipi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StrogeAction extends BaseEntity {
    private float miktar;
    private IslemTipi islemTipi;

    @ManyToOne
    private StrogeDetail strogeDetail;
}
