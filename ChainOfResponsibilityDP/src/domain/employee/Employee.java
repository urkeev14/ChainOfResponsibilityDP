/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.employee;

import domain.employee.role.Role;
import domain.vacation.application.VacationApplication;
import domain.vacation.approver.VacationApprover;

/**
 *
 * @author urosv
 * 
 * A class that represents an employee that will eventually try to
 * approve vacation, if not, it will pass down the VacationApplication object
 * to a successor
 * 
 */
public abstract class Employee implements VacationApprover {

    /*A employe that is at the higher level in hierarchy that this employee
    so, maybe he could approve the vacation ?*/
    private VacationApprover successor;
    private Role role;

    public Employee(Role role, VacationApprover successor) {
        this.role = role;
        this.successor = successor;
    }

    @Override
    public void processVacationApplication(VacationApplication application) {
        if (!isAbleToProcessRequest(application) && successor != null) {
            successor.processVacationApplication(application);
        }
    }

    protected abstract boolean isAbleToProcessRequest(VacationApplication application);

    @Override
    public Role getApproverRole() {
        return role;
    }
}
