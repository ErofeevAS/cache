package com.erofeev.demo.repo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {
    private static final long serialVersionUID = 5517244812959569947L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Long population;

    @OneToOne
//    @PrimaryKeyJoinColumn
    @JoinColumn(name="president_id")
    private President president;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private List<City> cities;
}
