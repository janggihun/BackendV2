package com.bismo.stellive.api.obtnDtl;


import com.bismo.stellive.api.obtn.Obtn;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class ObtnDtl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //pk

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obtn_id")
    private Obtn obtn;

    private String name;        //수주디테일 번호


}
