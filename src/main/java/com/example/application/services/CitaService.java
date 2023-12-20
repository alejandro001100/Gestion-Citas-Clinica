package com.example.application.services;

import com.example.application.data.Cita;
import java.util.ArrayList;
import java.util.List;

public class CitaService {
    private static final List<Cita> citas = new ArrayList<>();

    public static void agendarCita(Cita cita) {
        citas.add(cita);
    }

    public static List<Cita> obtenerTodasLasCitas() {
        return new ArrayList<>(citas);
    }
}
