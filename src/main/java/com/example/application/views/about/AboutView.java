package com.example.application.views.about;
import com.example.application.game.TicTacToe;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import jakarta.annotation.security.PermitAll;

import java.util.Collection;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
@PermitAll
public class AboutView extends VerticalLayout {


    public AboutView() {
        setSpacing(false);
        TicTacToe ticTacToe = new TicTacToe();



        ;


        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
