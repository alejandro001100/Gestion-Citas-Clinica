package com.example.application.services;

import com.example.application.data.Doctor;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private final List<Doctor> doctores = new ArrayList<>();

    public DoctorService() {
        // Inicializar con algunos doctores predefinidos
        doctores.add(new Doctor("Juan", "Pérez", "Cardiología"));
        doctores.add(new Doctor("Ana", "Martínez", "Dermatología"));
        // Añadir más doctores como sea necesario
    }

    public List<Doctor> obtenerTodosLosDoctores() {
        return Collections.unmodifiableList(doctores);
    }


}

