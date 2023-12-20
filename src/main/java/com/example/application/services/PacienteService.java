package com.example.application.services;

import com.example.application.data.Paciente;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PacienteService {
    private static final Map<String, Paciente> pacientes = new LinkedHashMap<>();

    public static void guardarPaciente(Paciente paciente) {
        pacientes.put(paciente.getCedula(), paciente);
    }

    public static Paciente obtenerPaciente(String cedula) {
        return pacientes.get(cedula);
    }

    public static Map<String, Paciente> obtenerTodosLosPacientes() {
        return Collections.unmodifiableMap(pacientes);
    }
}
