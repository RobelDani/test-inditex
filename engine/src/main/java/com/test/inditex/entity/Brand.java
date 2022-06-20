package com.test.inditex.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "brand")
@Data
public class Brand implements Serializable {

    private static final long serialVersionUID = 6031271925195354131L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @OneToMany(mappedBy = "brand")
    private List<Prices> prices;
}
