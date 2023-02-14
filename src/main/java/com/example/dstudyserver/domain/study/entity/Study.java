package com.example.dstudyserver.domain.study.entity;

import com.example.dstudyserver.domain.comment.entity.Comment;
import com.example.dstudyserver.domain.good.entity.Good;
import com.example.dstudyserver.domain.user.entity.User;
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
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String field;

    @Column
    private String study_time;

    @Column
    private String study_profile;

    @Column(length = 999999999)
    private String memo;

    @Column
    private int like_count;

    @Column
    private int people_count;

    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE)
    private List<User> userList;

    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE)
    private List<Good> goodList;

    @OneToMany(mappedBy = "study", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;
}
