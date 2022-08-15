package com.home.MyWorkTime.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="to_regulations")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SelectForTOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer FK_numTO;
    private Integer FK_autoTO;
    private Integer FK_partNumberTO;
    private Double amount;
    private Integer FK_jobCodeTO;


    @ManyToMany (mappedBy = "autoForTOModelSet")
    private Set<AutoForTOModel> autoForTOModelSet;

    @ManyToMany (mappedBy = "normalizForTOModelSet")
    private Set<NormalizForTOModel> normalizForTOModelSet;

    @ManyToMany (mappedBy = "partForTOModelSet")
    private Set<PartForTOModel> partForTOModelSet;

    @ManyToMany (mappedBy = "regulForTOModelSet")
    private Set<RegulForTOModel> regulForTOModelSet;

}
