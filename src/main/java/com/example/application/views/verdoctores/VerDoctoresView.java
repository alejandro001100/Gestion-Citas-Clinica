package com.example.application.views.verdoctores;

import com.example.application.data.Doctor;
import com.example.application.services.DoctorService;
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

@PageTitle("Ver Doctores")
@Route(value = "ver-doctores", layout = MainLayout.class)
@Uses(Icon.class)
public class VerDoctoresView extends Composite<VerticalLayout> {

    private final DoctorService doctorService = new DoctorService();
    private final Grid<Doctor> grid = new Grid<>(Doctor.class);

    public VerDoctoresView() {
        setupGrid();
        addComponentsToLayout();
    }

    private void setupGrid() {
        grid.setColumns("nombres", "apellidos", "especialidad");
        grid.setItems(doctorService.obtenerTodosLosDoctores());
    }

    private void addComponentsToLayout() {
        H4 title = new H4("Lista de Doctores");
        Hr hr = new Hr();

        VerticalLayout content = getContent();
        content.add(title, hr, grid);
    }
}
