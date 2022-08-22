package com.home.MyWorkTime.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
    @Column
    private Integer FK_autoTO;
    @Column
    private Integer FK_part_numberTO;
    @Column
    private Double amount;
    @Column
    private Integer FK_job_codeTO;

    @JsonIgnore
    @ManyToMany (mappedBy = "autoForTOModelSet")
    private List<AutoForTOModel> autoForTOModelSet;
    @JsonIgnore
    @ManyToMany (mappedBy = "normalizForTOModelSet")
    private List<NormalizForTOModel> normalizForTOModelSet;
    @JsonIgnore
    @ManyToMany (mappedBy = "partForTOModelSet")
    private List<PartForTOModel> partForTOModelSet;
    @JsonIgnore
    @ManyToMany (mappedBy = "regulForTOModelSet")
    private List<RegulForTOModel> regulForTOModelSet;

}
