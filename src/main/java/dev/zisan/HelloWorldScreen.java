package dev.zisan;

import dev.tamboui.layout.Padding;
import dev.tamboui.style.Color;
import dev.tamboui.text.Text;
import dev.tamboui.toolkit.app.ToolkitApp;
import dev.tamboui.toolkit.element.Element;
import dev.tamboui.toolkit.elements.Row;
import dev.tamboui.toolkit.elements.TextElement;
import dev.tamboui.toolkit.event.EventResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static dev.tamboui.toolkit.Toolkit.*;

/**
 * author: abdulazizzisan
 * date: 24 Apr, 2026
 */

public class HelloWorldScreen extends ToolkitApp {

    String[] nameArr = {"Zisan", "Zahin", "Zarif"};

    int selectedIndex = 0;

    void incrementIndex(){
        selectedIndex = (selectedIndex + 1) % nameArr.length;
    }

    void decrementIndex(){
        selectedIndex = (selectedIndex - 1 + nameArr.length) % nameArr.length;
    }



    @Override
    protected Element render() {
        return panel(
                panel(text("This is the first TUI application by Zisan").bold().blue()).rounded().padding(new Padding(0, 0, 0, 1)),
                getNameRow(nameArr),
                spacer(),
                text("Press 'q' to quit").fg(Color.GREEN).bold().dim()
        ).padding(new Padding(0, 1, 0, 1)).rounded()
                .onKeyEvent(event -> {
                    if (event.isRight()) {
                        incrementIndex();
                        return EventResult.HANDLED;
                    }
                    if (event.isLeft()) {
                        decrementIndex();
                        return EventResult.HANDLED;
                    }
                    return EventResult.UNHANDLED;
                });
    }

    Element getNameRow(String[] names){
        var nameList = new ArrayList<Element>();

        for (int i = 0; i < names.length; i++){
            TextElement name = text(String.format("%-10s", names[i])).blue();
            if (i == selectedIndex) {
                name.bold();
            }
            nameList.add(name);
        }

        return row(nameList.toArray(Element[]::new));
    }
}
