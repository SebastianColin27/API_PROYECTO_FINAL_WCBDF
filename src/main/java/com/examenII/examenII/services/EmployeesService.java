package com.examenII.examenII.services;

import com.examenII.examenII.dto.EmployeeDTO;
import com.examenII.examenII.models.EmployeesEntity;
import com.examenII.examenII.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class EmployeesService {
    @Autowired
    EmployeesRepository employeesRepository;


    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // Forzar el ID a null para asegurar que se crea uno nuevo
        employeeDTO.setId(null);
        EmployeesEntity employeeEntity = convertToEntity(employeeDTO);
        EmployeesEntity savedEmployee = employeesRepository.save(employeeEntity);
        return convertToDTO(savedEmployee);
    }
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeesEntity> employees = (List<EmployeesEntity>) employeesRepository.findAll();
        System.out.println("Employees encontrados: " + employees.size());
        return employees.stream().map(this::convertToDTO).toList();
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Optional<EmployeesEntity> employees = employeesRepository.findById(id);
        return employees.map(this::convertToDTO).orElse(null);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeesEntity> existingEmployee = employeesRepository.findById(id);

        if (existingEmployee.isPresent()) {
            EmployeesEntity employeesEntity = existingEmployee.get();
            employeesEntity.setId(id);
            // Añadir estas líneas para actualizar todos los campos
            employeesEntity.setFirst_name(employeeDTO.getFirst_name());
            employeesEntity.setLast_name(employeeDTO.getLast_name());
            employeesEntity.setHire_date(employeeDTO.getHire_date());
            employeesEntity.setPosition(employeeDTO.getPosition());

            EmployeesEntity updatedLog = employeesRepository.save(employeesEntity);
            return convertToDTO(updatedLog);
        }

        return null;
    }

    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }

    private EmployeesEntity convertToEntity(EmployeeDTO employeeDTO) {
        return EmployeesEntity.builder()
                // Ignora el ID completamente en la creación
                .first_name(employeeDTO.getFirst_name())
                .last_name(employeeDTO.getLast_name())
                .hire_date(employeeDTO.getHire_date())
                .position(employeeDTO.getPosition())
                .build();
    }
    private EmployeeDTO convertToDTO(EmployeesEntity employeesEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employeesEntity.getId());
        employeeDTO.setFirst_name(employeesEntity.getFirst_name());
        employeeDTO.setLast_name(employeesEntity.getLast_name());
        employeeDTO.setHire_date(employeesEntity.getHire_date());
        employeeDTO.setPosition(employeesEntity.getPosition());
        return employeeDTO;
    }
}

 /*   public List<EmployeesEntity> getAllEmployees(){
        return employeesRepository.findAll();
    }

    public Optional<EmployeesEntity> getEmployeeById(Long id){
        return employeesRepository.findById(id);
    }


    public EmployeesEntity createEmployee(EmployeesEntity employees){
        return employeesRepository.save(employees);
    }


    public EmployeesEntity updateEmployee(EmployeesEntity employee){
        return employeesRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeesRepository.deleteById(id);
    }


}
/*
    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    // List all employees
    @Transactional(readOnly = true)
    public List<EmployeesEntity> obtenerTodos() {
        return employeesRepository.findAll();
    }

    // Save a new employee
    @Transactional
    public EmployeesEntity guardarEmployee(EmployeesEntity employees) {
        return employeesRepository.save(employees);
    }

    // Update an existing employee
    @Transactional
    public EmployeesEntity actualizarEmployee(Long id, EmployeesEntity employees) {


        // Update fields from employeeDetails to existingEmployee
        // This assumes you have appropriate setters in your EmployeesEntity

        // Add other fields as necessary

        return employeesRepository.save(employees);
    }

    // Get employee by ID
    @Transactional(readOnly = true)
    public EmployeesEntity obtenerEmployeePorId(Long id) {
        return employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Delete an employee
    @Transactional
    public void eliminarEmployee(Long id) {
        EmployeesEntity employee = obtenerEmployeePorId(id);
        employeesRepository.delete(employee);
    }*/

