package com.graczdev.ipcalculator.views.calculator;

import com.graczdev.ipcalculator.calculator.AnaliseIPResult;
import com.graczdev.ipcalculator.calculator.CalculatorIPService;
import com.graczdev.ipcalculator.calculator.IPAddress;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.graczdev.ipcalculator.views.calculator.GuiHelper;

import java.util.Map;

@PageTitle("About")
@Route(value = "/")
public class CalculatorGui extends VerticalLayout {

    H1 headerH1 = new H1();
    TextField ipTextField = new TextField();
    Select<String> masksSelect = new Select<>();
    Button calculateButton = new Button();

    Text title1 = new Text("IP decimal: ");
    Text title2 = new Text("IP binary: ");
    Text title3 = new Text("Mask decimal: ");
    Text title4 = new Text("Mask binary: ");
    Text title5 = new Text("Net Address decimal: ");
    Text title6 = new Text("Net Address binary: ");
    Text title7 = new Text("Broadcast Address binary: ");
    Text title8 = new Text("Broadcast Address decimal: ");
    Text title9 = new Text("Max Host decimal: ");
    Text title10 = new Text("Max Host binary: ");
    Text title11 = new Text("Min Host decimal: ");
    Text title12 = new Text("Min Host binary: ");
    Text title13 = new Text("Mask number: ");
    Text title14 = new Text("Amount of Hosts: ");
    Text title15 = new Text("Network Class: ");

    Text result1 = new Text("---");
    Text result2 = new Text("---");
    Text result3 = new Text("---");
    Text result4 = new Text("---");

    Text result5 = new Text("---");
    Text result6 = new Text("---");
    Text result7 = new Text("---");
    Text result8 = new Text("---");

    Text result9 = new Text("---");
    Text result10 = new Text("---");
    Text result11 = new Text("---");
    Text result12 = new Text("---");

    Text result13 = new Text("---");
    Text result14 = new Text("---");
    Text result15 = new Text("---");

    public CalculatorGui() {

        //header 1/4
        headerH1.setText(GuiHelper.header);

        //IP text field 2/4
        ipTextField.setLabel(GuiHelper.ipAddress);
        ipTextField.setClearButtonVisible(true);

        //mask select 3/4
        masksSelect.setItems();
        masksSelect.setItems(GuiHelper.masksListStrings);
        masksSelect.setLabel(GuiHelper.mask);

        //calculate button 4/4
        calculateButton.setText(GuiHelper.calculateButton);
        calculateButton.addClickListener(buttonClickEvent ->
                {
                    CalculatorIPService service = new CalculatorIPService();
                    AnaliseIPResult analiseIPResult =
                            service.analiseIP(new IPAddress(ipTextField.getValue()), GuiHelper.masksListEnums.get(GuiHelper.masksListStrings.indexOf(masksSelect.getValue())));

                    result1.setText(analiseIPResult.getIpAddressDecimal());
                    result2.setText(analiseIPResult.getIpAddressBinary());
                    result3.setText(analiseIPResult.getMaskDecimal());
                    result4.setText(analiseIPResult.getMaskBinary());

                    result5.setText(analiseIPResult.getNetAddressDecimal());
                    result6.setText(analiseIPResult.getNetAddressBinary());
                    result7.setText(analiseIPResult.getBroadCastAddressDecimal());
                    result8.setText(analiseIPResult.getBroadCastAddressBinary());

                    result9.setText(analiseIPResult.getMaxHostDecimal());
                    result10.setText(analiseIPResult.getMaxHostBinary());
                    result11.setText(analiseIPResult.getMinHostDecimal());
                    result12.setText(analiseIPResult.getMinHostBinary());

                    result13.setText(String.valueOf(analiseIPResult.getMaskNumber()));
                    result14.setText(String.valueOf(analiseIPResult.getAmountOfHosts()));
                    result15.setText(analiseIPResult.getNetworkClass().toString());


                }
        );

        add(headerH1);
        add(ipTextField);
        add(masksSelect);
        add(calculateButton);

        add(title1);     add(result1);    add(new Html("<br>"));
        add(title2);     add(result2);    add(new Html("<br>"));
        add(title3);     add(result3);    add(new Html("<br>"));
        add(title4);     add(result4);    add(new Html("<br>"));
        add(title5);     add(result5);    add(new Html("<br>"));
        add(title6);     add(result6);    add(new Html("<br>"));
        add(title7);     add(result7);    add(new Html("<br>"));
        add(title8);     add(result8);    add(new Html("<br>"));
        add(title9);     add(result9);    add(new Html("<br>"));
        add(title10);    add(result10);   add(new Html("<br>"));
        add(title11);    add(result11);   add(new Html("<br>"));
        add(title12);    add(result12);   add(new Html("<br>"));
        add(title13);    add(result13);   add(new Html("<br>"));
        add(title14);    add(result14);   add(new Html("<br>"));
        add(title15);    add(result15);   add(new Html("<br>"));

        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
