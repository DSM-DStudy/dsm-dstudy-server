package com.example.dstudyserver.domain.user.entity;

import com.example.dstudyserver.domain.comment.entity.Comment;
import com.example.dstudyserver.domain.good.entity.Good;
import com.example.dstudyserver.domain.study.entity.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int student_id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String introduction;

    @Column
    private String image;

    @JsonIgnore
    @Column
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Good> goodList;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    public void editProfile(String introduction, String image){
        this.introduction = introduction;
        this.image = image;
    }

    public void setStudy(Study study){
        this.study = study;
    }

    public void editUser(String email, String password, int student_id){
        this.email = email;
        this.password = password;
        this.student_id = student_id;
    }
}
