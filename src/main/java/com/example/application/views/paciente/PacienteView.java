package com.example.application.views.paciente;

import com.example.application.data.Paciente;
import com.example.application.services.PacienteService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Paciente")
@Route(value = "paciente", layout = MainLayout.class)
@Uses(Icon.class)
public class PacienteView extends Composite<VerticalLayout> {

    public PacienteView() {
        H2 title = new H2("Ingrese Datos Paciente");
        FormLayout formLayout = new FormLayout();
        TextField nombresField = new TextField("Nombres");
        TextField apellidosField = new TextField("Apellidos");
        NumberField edadField = new NumberField("Edad");
        TextField cedulaField = new TextField("Cedula");

        Button guardarButton = new Button("Guardar");
        guardarButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        guardarButton.addClickListener(e -> guardarPaciente(nombresField.getValue(), apellidosField.getValue(), edadField.getValue(), cedulaField.getValue()));

        formLayout.add(nombresField, apellidosField, edadField, cedulaField);

        VerticalLayout content = getContent();
        content.add(title, new Hr(), formLayout, guardarButton);
    }

    private void guardarPaciente(String nombres, String apellidos, Double edad, String cedula) {
        if (nombres.isEmpty() || apellidos.isEmpty() || edad == null || cedula.isEmpty()) {
            Notification.show("Por favor complete todos los campos.");
            return;
        }

        Paciente nuevoPaciente = new Paciente(cedula, nombres, apellidos, edad.intValue());
        PacienteService.guardarPaciente(nuevoPaciente);
        Notification.show("Paciente guardado con éxito.");
    }
}
