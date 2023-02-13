package com.example.dstudyserver.domain.user.entity;

import com.example.dstudyserver.domain.good.entity.Good;
import com.example.dstudyserver.domain.study.entity.Study;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String introduction;

    @Column
    private String image;

    @Column
    private Role role;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Good> goodList;
}
