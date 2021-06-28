package com.works.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StrogeDetail extends BaseEntity{

    private String code;
    private float miktar;
    private float doluluk;
    private boolean active;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Stroge stroge;

    @OneToMany(mappedBy = "strogeDetail")
    private List<StrogeAction> strogeActionList;
}
