package com.christer.imperial.court.entity;


import lombok.*;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/01
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Emp {

    private Integer empId;
    private String empName;
    private String empPosition;
    private String loginAccount;
    private String loginPassword;
}
