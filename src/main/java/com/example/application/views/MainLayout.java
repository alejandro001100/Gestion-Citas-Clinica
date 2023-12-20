package com.example.application.views;

import com.example.application.views.crearcita.CrearCitaView;
import com.example.application.views.paciente.PacienteView;
import com.example.application.views.sistemadecitas.SistemaDeCitasView;
import com.example.application.views.vercitas.VerCitasView;
import com.example.application.views.verdoctores.VerDoctoresView;
import com.example.application.views.verpacientes.VerPacientesView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * El layout principal es un contenedor de nivel superior para otras vistas.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menú");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Gestión De Citas Clínica");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Sistema De Citas", SistemaDeCitasView.class,
                LineAwesomeIcon.CLINIC_MEDICAL_SOLID.create()));
        nav.addItem(new SideNavItem("Paciente", PacienteView.class, LineAwesomeIcon.MALE_SOLID.create()));
        nav.addItem(new SideNavItem("Crear Cita", CrearCitaView.class, LineAwesomeIcon.CLOCK.create()));
        nav.addItem(new SideNavItem("Ver Citas", VerCitasView.class, LineAwesomeIcon.EYE.create()));
        nav.addItem(new SideNavItem("Ver Doctores", VerDoctoresView.class, LineAwesomeIcon.EYE.create()));
        nav.addItem(new SideNavItem("Ver Pacientes", VerPacientesView.class, LineAwesomeIcon.EYE.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer footer = new Footer();
        H1 footerText = new H1("Alejandro Paqui");
        footerText.addClassNames(LumoUtility.FontSize.SMALL, LumoUtility.Margin.NONE);
        footer.add(footerText);
        return footer;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
