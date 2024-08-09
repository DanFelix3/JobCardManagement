package com.demoprogram.database.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@Data
@Getter
@Setter
public class JobCardModel {
    @NotNull(message = "Must not be Empty")
    private Integer id;
    @NotNull(message = "Must not be Empty")
    private Date date;
    @NotNull(message = "Must not be Empty")
    private String jobCardNo;
    @NotNull(message = "Must not be Empty")
    private String workAssigned;
    @NotNull(message = "Must not be Empty")
    private String custName;
    @NotNull(message = "Must not be Empty")
    private String custNo;
    @NotNull(message = "Must not be Empty")
    private String custAddress;
    @NotNull(message = "Must not be Empty")
    private Integer pinCode;
    @NotNull(message = "Must not be Empty")
    private String vehModel;
    @NotNull(message = "Must not be Empty")
    private String veh_reg_no;
    @NotNull(message = "Must not be Empty")
    private String custVoice;
    @NotNull(message = "Must not be Empty")
    private String status;

    public JobCardModel(Integer id, Date date, String jobCardNo,
                        String workAssigned, String custName, String custNo, String custAddress,
                        Integer pinCode, String vehModel, String veh_reg_no, String custVoice, String status) {
        this.id = id;
        this.date = date;
        this.jobCardNo = jobCardNo;
        this.workAssigned=workAssigned;
        this.custName=custName;
        this.custNo=custNo;
        this.custAddress=custAddress;
        this.pinCode=pinCode;
        this.vehModel=vehModel;
        this.veh_reg_no=veh_reg_no;
        this.custVoice=custVoice;
        this.status = status;
    }
}
