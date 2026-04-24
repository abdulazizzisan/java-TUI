package dev.zisan;

import dev.tamboui.layout.Padding;
import dev.tamboui.toolkit.app.ToolkitApp;
import dev.tamboui.toolkit.element.Element;

import static dev.tamboui.toolkit.Toolkit.*;

/**
 * author: abdulazizzisan
 * date: 24 Apr, 2026
 */

public class HelloWorldScreen extends ToolkitApp {
    @Override
    protected Element render() {
        return panel("| Hello |",
                text("Welcome to TamboUI DSL!").bold().cyan(),
                spacer(),
                text("Press 'q' to quit").dim()
        ).padding(new Padding(0, 1, 0, 1)).rounded();
    }
}
