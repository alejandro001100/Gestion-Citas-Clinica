package com.example.application.views.sistemadecitas;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Sistema De Citas")
@Route(value = "sistema-de-citas", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class SistemaDeCitasView extends Composite<VerticalLayout> {

    public SistemaDeCitasView() {
        H1 title = new H1("SISTEMA DE CITAS - CLÍNICA");
        Hr separator = new Hr();
        H6 subtitle = new H6("BIENVENIDOS AL SISTEMA DE CITAS");
        Paragraph infoParagraph = new Paragraph(
                "Aquí valoramos tu tiempo y esfuerzo, por eso hemos creado una experiencia de citas sencilla y eficiente. Nuestro objetivo es ayudarte a encontrar la cita perfecta en solo unos pocos pasos."
        );

        VerticalLayout content = getContent();
        content.setWidth("100%");
        content.getStyle().set("flex-grow", "1");
        content.setJustifyContentMode(JustifyContentMode.START);
        content.setAlignItems(Alignment.CENTER);

        content.add(title, separator, subtitle, infoParagraph);
    }
}
