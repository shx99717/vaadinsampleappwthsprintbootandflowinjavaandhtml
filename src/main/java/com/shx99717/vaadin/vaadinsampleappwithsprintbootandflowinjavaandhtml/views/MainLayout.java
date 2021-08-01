package com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.MainLayout;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.helloworld.HelloWorldView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.about.AboutView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.empty.EmptyView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.dashboard.DashboardView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.cardlist.CardListView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.list.ListView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.masterdetail.MasterDetailView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.personform.PersonFormView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.addressform.AddressFormView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.creditcardform.CreditCardFormView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.map.MapView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.editor.EditorView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.imagelist.ImageListView;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.checkoutform.CheckoutFormView;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.component.avatar.Avatar;

/**
 * The main view is a top-level placeholder for other views.
 */
@PWA(name = "VaadinSampleAppWthSprintBootAndFlowInJavaAndHTML", shortName = "VaadinSampleAppWthSprintBootAndFlowInJavaAndHTML", enableInstallPrompt = false)
@Theme(themeFolder = "vaadinsampleappwthsprintbootandflowinjavaandhtml", variant = Lumo.DARK)
@PageTitle("Main")
public class MainLayout extends AppLayout {

    public static class MenuItemInfo {

        private String text;
        private String iconClass;
        private Class<? extends Component> view;

        public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
            this.text = text;
            this.iconClass = iconClass;
            this.view = view;
        }

        public String getText() {
            return text;
        }

        public String getIconClass() {
            return iconClass;
        }

        public Class<? extends Component> getView() {
            return view;
        }

    }

    private final Tabs menu;
    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setClassName("sidemenu-header");
        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.add(new DrawerToggle());
        viewTitle = new H1();
        layout.add(viewTitle);

        Avatar avatar = new Avatar();
        avatar.addClassNames("ms-auto", "me-m");
        layout.add(avatar);

        return layout;
    }

    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        layout.setClassName("sidemenu-menu");
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        logoLayout.add(new Image("images/logo.png", "VaadinSampleAppWthSprintBootAndFlowInJavaAndHTML logo"));
        logoLayout.add(new H1("VaadinSampleAppWthSprintBootAndFlowInJavaAndHTML"));
        layout.add(logoLayout, menu);
        return layout;
    }

    private Tabs createMenu() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        for (Tab menuTab : createMenuItems()) {
            tabs.add(menuTab);
        }
        return tabs;
    }

    private List<Tab> createMenuItems() {
        MenuItemInfo[] menuItems = new MenuItemInfo[]{ //
                new MenuItemInfo("Hello World", "la la-globe", HelloWorldView.class), //

                new MenuItemInfo("About", "la la-file", AboutView.class), //

                new MenuItemInfo("Empty", "la la-file", EmptyView.class), //

                new MenuItemInfo("Dashboard", "la la-chart-area", DashboardView.class), //

                new MenuItemInfo("Card List", "la la-list", CardListView.class), //

                new MenuItemInfo("List", "la la-th", ListView.class), //

                new MenuItemInfo("Master-Detail", "la la-columns", MasterDetailView.class), //

                new MenuItemInfo("Person Form", "la la-user", PersonFormView.class), //

                new MenuItemInfo("Address Form", "la la-map-marker", AddressFormView.class), //

                new MenuItemInfo("Credit Card Form", "", CreditCardFormView.class), //

                new MenuItemInfo("Map", "la la-map", MapView.class), //

                new MenuItemInfo("Editor", "la la-edit", EditorView.class), //

                new MenuItemInfo("Image List", "la la-th-list", ImageListView.class), //

                new MenuItemInfo("Checkout Form", "", CheckoutFormView.class), //

        };
        List<Tab> tabs = new ArrayList<>();
        for (MenuItemInfo menuItemInfo : menuItems) {
            tabs.add(createTab(menuItemInfo));

        }
        return tabs;
    }

    private static Tab createTab(MenuItemInfo menuItemInfo) {
        Tab tab = new Tab();
        RouterLink link = new RouterLink();
        link.setRoute(menuItemInfo.getView());
        Span iconElement = new Span();
        iconElement.addClassNames("text-l", "pr-s");
        if (!menuItemInfo.getIconClass().isEmpty()) {
            iconElement.addClassNames(menuItemInfo.getIconClass());
        }
        link.add(iconElement, new Text(menuItemInfo.getText()));
        tab.add(link);
        ComponentUtil.setData(tab, Class.class, menuItemInfo.getView());
        return tab;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);
        viewTitle.setText(getCurrentPageTitle());
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
