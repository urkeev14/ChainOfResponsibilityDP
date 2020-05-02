/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.vacation.application;

import domain.employee.role.Role;
import domain.vacation.application.status.VacationStatus;
import domain.vacation.application.type.VacationType;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author urosv
 *
 * Represents a request in our chain of responsibility
 * Builder DP implemented (immutable class, no setter methods)
 */
public class VacationApplication {

    private VacationType type;
    private VacationStatus status;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Role processedBy;

    public VacationApplication(VacationType type, LocalDate from, LocalDate to) {
        this.type = type;
        this.dateFrom = from;
        this.dateTo = to;
        this.status = VacationStatus.Pending;
    }

    public VacationType getType() {
        return type;
    }
    public VacationStatus getStatus() {
        return status;
    }
    public LocalDate getDateFrom() {
        return dateFrom;
    }
    public LocalDate getDateTo() {
        return dateTo;
    }
    public Role getProcessedBy() {
        return processedBy;
    }
    
    //No setters because it is immutable class
    
    public void approve(Role approverRole) {
        this.status = VacationStatus.Approved;
        this.processedBy = approverRole;
    }

    public void reject(Role approverRole) {
        this.status = VacationStatus.Rejected;
        this.processedBy = approverRole;
    }

    public int getNumberOfDays() {
        return (int) ChronoUnit.DAYS.between(dateFrom, dateTo);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder()
                .append(type).append(" vacation for")
                .append(getNumberOfDays())
                .append(" day(s)")
                .append(status)
                .append(" by ")
                .append(processedBy);
        return sentence.toString();
    }

    public static class Builder {

        private VacationType vacationType;
        private LocalDate dateFrom;
        private LocalDate dateTo;
        private VacationApplication application;

        private Builder() {

        }

        public Builder withVacationType(VacationType type) {
            this.vacationType = type;
            return this;
        }

        public Builder withStartDate(LocalDate from) {
            this.dateFrom = from;
            return this;
        }

        public Builder withEndDate(LocalDate to) {
            this.dateTo = to;
            return this;
        }

        public VacationApplication build() {
            this.application = new VacationApplication(vacationType, dateFrom, dateTo);
            return this.application;
        }

//        public VacationApplication getApplication() {
//            return application;
//
//        }
    }
}
