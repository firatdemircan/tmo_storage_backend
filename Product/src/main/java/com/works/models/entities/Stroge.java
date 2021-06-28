package com.works.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stroge extends BaseEntity{

    private String code;
    private float miktar;

    @OneToMany(mappedBy = "stroge")
    private List<StrogeDetail> strogeDetailList;

}
