package com.finalproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)


public class RegistrationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegistrationDetail;

    @ManyToOne
    @JoinColumn(name = "id_registration" , nullable = false , foreignKey = @ForeignKey(name="FK_RegistrationDetail_Registration"))
    private Registration registration;

    @ManyToOne
    @JoinColumn(name = "id_course", nullable = false , foreignKey = @ForeignKey(name="FK_RegistrationDetail_Course"))
    private Course course;

    @Column (length = 30, nullable = false)
    private String classroom;
}
