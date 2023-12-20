package com.example.application.views.verpacientes;

import com.example.application.data.Paciente;
import com.example.application.services.PacienteService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;

@PageTitle("Ver Pacientes")
@Route(value = "ver-pacientes", layout = MainLayout.class)
@Uses(Icon.class)
public class VerPacientesView extends Composite<VerticalLayout> {

    private final PacienteService pacienteService = new PacienteService();
    private final Grid<Paciente> grid = new Grid<>(Paciente.class);

    public VerPacientesView() {
        setupGrid();
        addComponentsToLayout();
    }

    private void setupGrid() {
        grid.setColumns("cedula", "nombres", "apellidos", "edad");
        grid.setItems(pacienteService.obtenerTodosLosPacientes().values());
    }

    private void addComponentsToLayout() {
        H4 title = new H4("Lista de Pacientes");
        Hr hr = new Hr();

        VerticalLayout content = getContent();
        content.add(title, hr, grid);
    }
}

