/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.employee.impl;

import domain.employee.Employee;
import domain.employee.role.Role;
import domain.vacation.application.VacationApplication;
import domain.vacation.approver.VacationApprover;

/**
 *
 * @author urosv
 */
public class Manager extends Employee {

    public Manager(VacationApprover successor) {
        super(Role.Manager, successor);
    }
    @Override
    protected boolean isAbleToProcessRequest(VacationApplication application) {
        switch (application.getType()) {
            case Mountains:
                application.approve(getApproverRole());
                return true;
            case Skiing:
                if (application.getNumberOfDays()<= 5) {
                    application.approve(getApproverRole());
                    return true;
                }
        }
        return false;
    }
}
