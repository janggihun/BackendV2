package com.bismo.stellive.api.obtn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObtnResponse {

    private Long id;                        //pk
    private String inputId;                 //작성자
    private LocalDateTime inputDate;        //작성시간
}
