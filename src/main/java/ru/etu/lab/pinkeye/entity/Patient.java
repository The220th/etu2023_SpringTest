package ru.etu.lab.pinkeye.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
public class Patient
{
    private Integer id;
    private Integer temp;
    private Boolean type;
    private Integer hospitalId;
}
