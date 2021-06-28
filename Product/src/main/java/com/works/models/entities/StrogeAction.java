package com.works.models.entities;

import com.works.models.enums.IslemTipi;
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
public class StrogeAction extends BaseEntity{
    private float miktar;
    private IslemTipi islemTipi;

    @ManyToOne
    private StrogeDetail strogeDetail;
}
