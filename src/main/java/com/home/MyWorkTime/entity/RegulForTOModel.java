package com.home.MyWorkTime.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "regulations")
@NoArgsConstructor
@AllArgsConstructor
public class RegulForTOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String number_TO;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "to_regulations",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_numTO")
    )
    private List<RegulForTOModel> regulForTOModelSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RegulForTOModel that = (RegulForTOModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
