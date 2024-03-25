package com.example.spring_data_auto_mapping_objects.demo;

import com.example.spring_data_auto_mapping_objects.demo.dto.EmployeeDTO;
import com.example.spring_data_auto_mapping_objects.demo.entities.Address;
import com.example.spring_data_auto_mapping_objects.demo.entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        Address address = new Address("Vasi Levski",
                    84,
                    "Sofia",
                    "Bulgaria");

        Employee source = new Employee("first",
                    "last",
                    BigDecimal.TEN,
                    LocalDate.now(),
                    address);

        EmployeeDTO dto = mapper.map(source, EmployeeDTO.class);

        System.out.println(dto);
    }
}
