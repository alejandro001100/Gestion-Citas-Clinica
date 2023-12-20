package com.example.application.data;

import java.time.LocalDateTime;

public class Cita {
    private Paciente paciente;
    private Doctor doctor;
    private LocalDateTime fechaHora;
    private String especialidad;

    public Cita(Paciente paciente, Doctor doctor, LocalDateTime fechaHora, String especialidad) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fechaHora = fechaHora;
        this.especialidad = especialidad;
    }

    // Getters y setters
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
