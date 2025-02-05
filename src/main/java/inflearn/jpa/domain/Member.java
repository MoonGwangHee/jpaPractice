package inflearn.jpa.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Embeddable
@Data
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
