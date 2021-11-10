package com.graczdev.ipcalculator.views.calculator;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About")
@Route(value = "/")
public class CalculatorGui extends VerticalLayout {

    public CalculatorGui() {
        setSpacing(false);

        add(new H2("Tutaj będzie nasz kalkulator :)"));
        add(new Paragraph("Zaczynamy prace nad naszym algorytmem 🤗"));
        add(new Button("Oblicz"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }

}
