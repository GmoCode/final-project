package com.finalproject.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idRegistration;

    @Column(nullable = false)
    private LocalDateTime dateRegistration;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name="FK_Registration_Student"))
    private Student student;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "registration",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RegistrationDetail> details;


}
