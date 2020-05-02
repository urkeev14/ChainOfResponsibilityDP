/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.employee.impl;

import domain.employee.Employee;
import domain.employee.role.Role;
import domain.vacation.application.VacationApplication;
import domain.vacation.application.type.VacationType;
import domain.vacation.approver.VacationApprover;

/**
 *
 * @author urosv
 */
public class Director extends Employee {

    public Director(VacationApprover successor) {
        super(Role.Director, successor);
    }

    @Override
    protected boolean isAbleToProcessRequest(VacationApplication application) {
        if (application.getType() == VacationType.Skiing) {
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }

}
