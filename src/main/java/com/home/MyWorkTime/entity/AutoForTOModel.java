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
@Table(name = "auto")
@NoArgsConstructor
@AllArgsConstructor
public class AutoForTOModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String automobile;
    @Column
    private String modification;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "to_regulations",
    joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "FK_numTO")
    )
    private List<AutoForTOModel> autoForTOModelSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AutoForTOModel that = (AutoForTOModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
