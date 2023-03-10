package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 양방향 연관 관계가 존재시
    // FK가 가까운곳을 연관 관계의 주인으로 지정하여됨.
    // Order의 Member member를 주인으로 지정.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
