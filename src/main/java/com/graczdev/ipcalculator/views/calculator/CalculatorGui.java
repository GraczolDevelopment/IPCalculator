package com.graczdev.ipcalculator.views.calculator;

import com.graczdev.ipcalculator.calculator.AnaliseIPResult;
import com.graczdev.ipcalculator.calculator.CalculatorIPService;
import com.graczdev.ipcalculator.calculator.IPAddress;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import panda.std.Option;

import java.util.ArrayList;
import java.util.List;

@PageTitle("About")
@Route(value = "/")
public class CalculatorGui extends VerticalLayout {

    H1 headerH1 = new H1();
    TextField ipTextField = new TextField();
    Select<String> masksSelect = new Select<>();
    Button calculateButton = new Button();

    List<TextField> resultTextList = new ArrayList<>();

    public CalculatorGui() {

        for (int i = 0; i < 15; i++) {
            TextField textField = new TextField();

            resultTextList.add(i , textField);
            textField.setReadOnly(true);
        }

        //header 1/4
        headerH1.setText(GuiHelper.header);

        //IP text field 2/4
        ipTextField.setLabel(GuiHelper.ipAddress);
        ipTextField.setClearButtonVisible(true);

        //mask select 3/4
        masksSelect.setItems(GuiHelper.masksListStrings);
        masksSelect.setLabel(GuiHelper.mask);

        //calculate button 4/4
        calculateButton.setText(GuiHelper.calculateButton);
        calculateButton.addClickListener(buttonClickEvent -> {
            CalculatorIPService service = new CalculatorIPService();

            Option<IPAddress> addressOption = Option.attempt(RuntimeException.class,
                    () -> new IPAddress(ipTextField.getValue()));

            Style style = ipTextField.getStyle();

            if (addressOption.isEmpty()) {
                ipTextField.setInvalid(true);
                return;
            }

            ipTextField.setInvalid(false);
            int index = GuiHelper.masksListStrings.indexOf(masksSelect.getValue());
            AnaliseIPResult analiseIPResult = service.analiseIP(addressOption.get(), GuiHelper.masksListEnums.get(index));

            resultTextList.get(0) .setValue(analiseIPResult.getIpAddressDecimal());
            resultTextList.get(1) .setValue(analiseIPResult.getIpAddressBinary());
            resultTextList.get(2) .setValue(analiseIPResult.getMaskDecimal());
            resultTextList.get(3) .setValue(analiseIPResult.getMaskBinary());
            resultTextList.get(4) .setValue(analiseIPResult.getNetAddressDecimal());
            resultTextList.get(5) .setValue(analiseIPResult.getNetAddressBinary());
            resultTextList.get(6) .setValue(analiseIPResult.getBroadCastAddressDecimal());
            resultTextList.get(7) .setValue(analiseIPResult.getBroadCastAddressBinary());
            resultTextList.get(8) .setValue(analiseIPResult.getMaxHostDecimal());
            resultTextList.get(9) .setValue(analiseIPResult.getMaxHostBinary());
            resultTextList.get(10).setValue(analiseIPResult.getMinHostDecimal());
            resultTextList.get(11).setValue(analiseIPResult.getMinHostBinary());
            resultTextList.get(12).setValue(String.valueOf(analiseIPResult.getMaskNumber()));
            resultTextList.get(13).setValue(String.valueOf(analiseIPResult.getAmountOfHosts()));
            resultTextList.get(14).setValue(analiseIPResult.getNetworkClass().toString());
        });

        resultTextList.get(0) .setLabel("IP decimal: ");
        resultTextList.get(1) .setLabel("IP binary: ");
        resultTextList.get(2) .setLabel("Mask decimal: ");
        resultTextList.get(3) .setLabel("Mask binary: ");
        resultTextList.get(4) .setLabel("Net Address decimal: ");
        resultTextList.get(5) .setLabel("Net Address binary: ");
        resultTextList.get(6) .setLabel("Broadcast Address binary: ");
        resultTextList.get(7) .setLabel("Broadcast Address decimal: ");
        resultTextList.get(8) .setLabel("Max Host decimal: ");
        resultTextList.get(9) .setLabel("Max Host binary: ");
        resultTextList.get(10).setLabel("Min Host decimal: ");
        resultTextList.get(11).setLabel("Min Host binary: ");
        resultTextList.get(12).setLabel("Mask number: ");
        resultTextList.get(13).setLabel("Amount of Hosts: ");
        resultTextList.get(14).setLabel("Network Class: ");

        add(headerH1);
        add(ipTextField);
        add(masksSelect);
        add(calculateButton);

        HorizontalLayout first = new HorizontalLayout();
        HorizontalLayout second = new HorizontalLayout();
        HorizontalLayout third = new HorizontalLayout();
        HorizontalLayout four = new HorizontalLayout();

        first.add(resultTextList.get(0) );
        first.add(resultTextList.get(1) );
        first.add(resultTextList.get(2) );
        first.add(resultTextList.get(3) );
        second.add(resultTextList.get(4) );
        second.add(resultTextList.get(5) );
        second.add(resultTextList.get(6) );
        second.add(resultTextList.get(7) );
        third.add(resultTextList.get(8) );
        third.add(resultTextList.get(9) );
        third.add(resultTextList.get(10));
        third.add(resultTextList.get(11));
        four.add(resultTextList.get(12));
        four.add(resultTextList.get(13));
        four.add(resultTextList.get(14));

        add(first, second, third, four);

        setSpacing(false);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }
}
