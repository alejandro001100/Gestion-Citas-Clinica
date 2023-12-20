package com.example.application.views.crearcita;

import com.example.application.data.Cita;
import com.example.application.data.Doctor;
import com.example.application.data.Paciente;
import com.example.application.services.CitaService;
import com.example.application.services.DoctorService;
import com.example.application.services.PacienteService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.time.LocalDateTime;

@PageTitle("Crear Cita")
@Route(value = "crear-cita", layout = MainLayout.class)
@Uses(Icon.class)
public class CrearCitaView extends Composite<VerticalLayout> {

    private final CitaService citaService = new CitaService();
    private final DoctorService doctorService = new DoctorService();
    private final PacienteService pacienteService = new PacienteService();
    private final TextField cedulaField = new TextField("Cédula");
    private final Select<Doctor> selectDoctor = new Select<>();
    private final DateTimePicker dateTimePicker = new DateTimePicker();
    private final H6 welcomeMessage = new H6();

    public CrearCitaView() {
        H4 title = new H4("Ingresa tu cédula para crear tu cita");
        Button ingresarButton = new Button("Ingresar");
        Button cancelarButton = new Button("Cancelar");
        FormLayout formLayout = new FormLayout();

        selectDoctor.setLabel("Doctor");
        selectDoctor.setItems(doctorService.obtenerTodosLosDoctores());
        selectDoctor.setItemLabelGenerator(doctor -> doctor.getNombres() + " " + doctor.getApellidos() + " - " + doctor.getEspecialidad());

        dateTimePicker.setLabel("Fecha y hora");

        ingresarButton.addClickListener(e -> mostrarNombrePaciente(cedulaField.getValue()));
        Button agendarButton = new Button("Agendar");
        agendarButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        agendarButton.addClickListener(e -> agendarCita());

        formLayout.add(cedulaField, ingresarButton, cancelarButton, welcomeMessage, selectDoctor, dateTimePicker, agendarButton);
        getContent().add(title, new Hr(), formLayout);
    }

    private void mostrarNombrePaciente(String cedula) {
        Paciente paciente = pacienteService.obtenerPaciente(cedula);
        if (paciente != null) {
            welcomeMessage.setText("Bienvenido: " + paciente.getNombres());
        } else {
            welcomeMessage.setText("Paciente no encontrado");
        }
    }

    private void agendarCita() {
        Doctor doctorSeleccionado = selectDoctor.getValue();
        LocalDateTime fechaHora = dateTimePicker.getValue();
        Paciente paciente = pacienteService.obtenerPaciente(cedulaField.getValue());

        if (doctorSeleccionado == null || fechaHora == null || paciente == null) {
            Notification.show("Por favor, completa todos los campos requeridos.");
            return;
        }

        Cita nuevaCita = new Cita(paciente, doctorSeleccionado, fechaHora, doctorSeleccionado.getEspecialidad());
        citaService.agendarCita(nuevaCita);
        Notification.show("Cita agendada con éxito.");
    }
}
