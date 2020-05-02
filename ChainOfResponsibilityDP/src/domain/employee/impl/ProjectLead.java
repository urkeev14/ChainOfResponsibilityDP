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
 *
 * A concrete handler
 *
 * This role can only process the vacation application of type SEASIDE , and, if
 * duration is less the or equal to 2 days
 */
public class ProjectLead extends Employee {

    public ProjectLead(VacationApprover successor) {
        super(Role.ProjectLead, successor);
    }

    @Override
    protected boolean isAbleToProcessRequest(VacationApplication application) {
        if (application.getType() == VacationType.Seaside
                && application.getNumberOfDays() <= 2) {
            application.approve(getApproverRole());
            return true;
        }
        return false;
    }

}
