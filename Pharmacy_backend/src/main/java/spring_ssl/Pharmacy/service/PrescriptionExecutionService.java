package spring_ssl.Pharmacy.service;

import spring_ssl.Pharmacy.domain.PrescriptionExecution;


public interface PrescriptionExecutionService {

    public PrescriptionExecution insertPrescriptionExecution(PrescriptionExecution prescriptionExecution);

    public PrescriptionExecution getPrescriptionExecutionById(int prescriptionExecution);
}
