package com.finalproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idCourse;

    @Column(length = 120, nullable = false)
    private String name;

    @Column (length = 20, nullable = false)
    private String acronym;

    @Column (nullable = false)
    private boolean enabled;

}
