package com.example.application.views.vercitas;

import java.time.format.DateTimeFormatter;
import com.example.application.data.Cita;
import com.example.application.services.CitaService;
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

@PageTitle("Ver Citas")
@Route(value = "ver-citas", layout = MainLayout.class)
@Uses(Icon.class)
public class VerCitasView extends Composite<VerticalLayout> {

    private final CitaService citaService = new CitaService();
    private final Grid<Cita> grid = new Grid<>(Cita.class);

    public VerCitasView() {
        setupGrid();
        addComponentsToLayout();
    }

    private void setupGrid() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        grid.removeAllColumns();
        grid.addColumn(cita -> cita.getPaciente().getNombres() + " " + cita.getPaciente().getApellidos())
                .setHeader("Nombre del Paciente");
        grid.addColumn(cita -> cita.getDoctor().getNombres() + " " + cita.getDoctor().getApellidos())
                .setHeader("Nombre del Doctor");
        grid.addColumn(cita -> cita.getFechaHora().format(formatter))
                .setHeader("Fecha y Hora");
        grid.addColumn(Cita::getEspecialidad).setHeader("Especialidad");

        grid.setItems(citaService.obtenerTodasLasCitas());
    }


    private void addComponentsToLayout() {
        H4 title = new H4("Citas Agendadas");
        Hr hr = new Hr();
        VerticalLayout content = getContent();
        content.add(title, hr, grid);
    }
}
