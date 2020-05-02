/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.employee.impl.Director;
import domain.employee.impl.Manager;
import domain.employee.impl.ProjectLead;
import domain.vacation.application.VacationApplication;
import domain.vacation.application.type.VacationType;
import domain.vacation.approver.VacationApprover;
import java.time.LocalDate;

/**
 *
 * @author urosv
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        VacationApplication application = createVacationApplication();

        System.out.println(application);

        //wait a couple of seconds
        processing();

        ProjectLead lead = new ProjectLead(new Manager(new Director(null)));
        
        /*If a project lead can not handle application, he will pass it to
        manager, who, if can not handle application, will pass it to director.
        Finally, if director can not handle application, application won't be
        handled at all*/
        lead.processVacationApplication(application);
        
        System.out.println(application);
    }

    private static VacationApplication createVacationApplication() {
        VacationApplication application = VacationApplication.getBuilder()
                .withVacationType(VacationType.Seaside)
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now().plusDays(2))
                .build();
        return application;
    }

    public static void processing() throws InterruptedException {
        System.out.println();
        Thread.currentThread().sleep(2000);
        
        System.out.println("Processing...");
        
        Thread.currentThread().sleep(2000);
        System.out.println();
    }

   
}
