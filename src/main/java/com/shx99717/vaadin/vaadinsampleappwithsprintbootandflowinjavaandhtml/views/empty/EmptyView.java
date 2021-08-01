package com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.empty;

import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.shx99717.vaadin.vaadinsampleappwithsprintbootandflowinjavaandhtml.views.MainLayout;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@PageTitle("Empty")
@Route(value = "empty", layout = MainLayout.class)
@Tag("empty-view")
@JsModule("./views/empty/empty-view.ts")
public class EmptyView extends LitTemplate {

    // This is the Java companion file of a design
    // You can find the design file inside /frontend/views/

    public EmptyView() {
    }
}
