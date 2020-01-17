package com.yj.wl.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Journalism {
    private Integer id;
    private Integer userId;
    private String content;
    private String title;


}
