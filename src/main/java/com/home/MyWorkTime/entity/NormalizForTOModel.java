package com.home.MyWorkTime.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="normalization")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class NormalizForTOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer jobCode;
    @Column
    private String jobName;
    @Column
    private Double jobTime;
    @Column
    private Double priceTime;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "to_regulations",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_job_codeTO")
    )
    private List<NormalizForTOModel> normalizForTOModelSet;

}
