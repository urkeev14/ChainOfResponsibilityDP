/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.vacation.approver;

import domain.employee.role.Role;
import domain.vacation.application.VacationApplication;

/**
 *
 * @author urosv
 */
public interface VacationApprover {
    
    void processVacationApplication(VacationApplication application);
    
    Role getApproverRole();
    
}
