package com.graczdev.ipcalculator.views.calculator;

import com.graczdev.ipcalculator.calculator.AnaliseIPResult;
import com.graczdev.ipcalculator.calculator.CalculatorIPService;
import com.graczdev.ipcalculator.calculator.IPAddress;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("About")
@Route(value = "/")
public class CalculatorGui extends VerticalLayout {

    H1 headerH1 = new H1();
    TextField ipTextField = new TextField();
    Select<String> masksSelect = new Select<>();
    Button calculateButton = new Button();

    List<Text> resultTextList = new ArrayList<>();

    public CalculatorGui() {

        for (int i = 0; i < 15; i++) {
            resultTextList.add(i , new Text("---"));
        }

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

                    resultTextList.get(0) .setText(analiseIPResult.getIpAddressDecimal());
                    resultTextList.get(1) .setText(analiseIPResult.getIpAddressBinary());
                    resultTextList.get(2) .setText(analiseIPResult.getMaskDecimal());
                    resultTextList.get(3) .setText(analiseIPResult.getMaskBinary());

                    resultTextList.get(4) .setText(analiseIPResult.getNetAddressDecimal());
                    resultTextList.get(5) .setText(analiseIPResult.getNetAddressBinary());
                    resultTextList.get(6) .setText(analiseIPResult.getBroadCastAddressDecimal());
                    resultTextList.get(7) .setText(analiseIPResult.getBroadCastAddressBinary());

                    resultTextList.get(8) .setText(analiseIPResult.getMaxHostDecimal());
                    resultTextList.get(9) .setText(analiseIPResult.getMaxHostBinary());
                    resultTextList.get(10).setText(analiseIPResult.getMinHostDecimal());
                    resultTextList.get(11).setText(analiseIPResult.getMinHostBinary());

                    resultTextList.get(12).setText(String.valueOf(analiseIPResult.getMaskNumber()));
                    resultTextList.get(13).setText(String.valueOf(analiseIPResult.getAmountOfHosts()));
                    resultTextList.get(14).setText(analiseIPResult.getNetworkClass().toString());
                }
        );

        add(headerH1);
        add(ipTextField);
        add(masksSelect);
        add(calculateButton);

        add(new Text("IP decimal: "));                  add(resultTextList.get(0) );   add(new Html("<br>"));
        add(new Text("IP binary: "));                   add(resultTextList.get(1) );   add(new Html("<br>"));
        add(new Text("Mask decimal: "));                add(resultTextList.get(2) );   add(new Html("<br>"));
        add(new Text("Mask binary: "));                 add(resultTextList.get(3) );   add(new Html("<br>"));
        add(new Text("Net Address decimal: "));         add(resultTextList.get(4) );   add(new Html("<br>"));
        add(new Text("Net Address binary: "));          add(resultTextList.get(5) );   add(new Html("<br>"));
        add(new Text("Broadcast Address binary: "));    add(resultTextList.get(6) );   add(new Html("<br>"));
        add(new Text("Broadcast Address decimal: "));   add(resultTextList.get(7) );   add(new Html("<br>"));
        add(new Text("Max Host decimal: "));            add(resultTextList.get(8) );   add(new Html("<br>"));
        add(new Text("Max Host binary: "));             add(resultTextList.get(9) );   add(new Html("<br>"));
        add(new Text("Min Host decimal: "));            add(resultTextList.get(10));   add(new Html("<br>"));
        add(new Text("Min Host binary: "));             add(resultTextList.get(11));   add(new Html("<br>"));
        add(new Text("Mask number: "));                 add(resultTextList.get(12));   add(new Html("<br>"));
        add(new Text("Amount of Hosts: "));             add(resultTextList.get(13));   add(new Html("<br>"));
        add(new Text("Network Class: "));               add(resultTextList.get(14));   add(new Html("<br>"));

        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}