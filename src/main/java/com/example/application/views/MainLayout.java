package com.example.application.views;


import com.example.application.components.appnav.AppNav;
import com.example.application.components.appnav.AppNavItem;
import com.example.application.security.SecurityService;
import com.example.application.views.about.AboutView;
import com.example.application.views.checkoutform.CheckoutFormView;
import com.example.application.views.creditcardform.CreditCardFormView;
import com.example.application.views.greeting.HelloWorldView;
import com.example.application.views.list.DashboardView;
import com.example.application.views.list.ListView;
import com.example.application.views.personform.PersonFormView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private  SecurityService securityService;
    private H2 viewTitle;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        H1 logo = new H1("Vaadin CRM");
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");




        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Button logOut = new Button("Logout", e-> securityService.logout());

       // addToNavbar(true, toggle, viewTitle,logOut );

        HorizontalLayout navbarLayout = new HorizontalLayout(toggle, viewTitle, logOut);
        navbarLayout.expand(viewTitle); // Expands the title to fill the available space
        navbarLayout.setAlignItems(FlexComponent.Alignment.CENTER); // Centers the components vertically
        navbarLayout.setWidthFull();
        addToNavbar(navbarLayout);

        logOut.getElement().getStyle().set("margin-left", "auto");
    }

    private void addDrawerContent() {
        H1 appName = new H1("Aplikasi Bekantan");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);



        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());


    }

    private AppNav createNavigation() {
        // AppNav is not yet an official component.
        // For documentation, visit https://github.com/vaadin/vcf-nav#readme
        AppNav nav = new AppNav();

        nav.addItem(new AppNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new AppNavItem("About", AboutView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new AppNavItem("Credit Card Form", CreditCardFormView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(new AppNavItem("List", ListView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new AppNavItem("Person Form", PersonFormView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new AppNavItem("Checkout Form", CheckoutFormView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(new AppNavItem("Dashboard", DashboardView.class, LineAwesomeIcon.CREDIT_CARD.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
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
