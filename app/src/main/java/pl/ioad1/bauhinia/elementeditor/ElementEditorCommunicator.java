package pl.ioad1.bauhinia.elementeditor;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import pl.ioad1.bauhinia.sessionManager.ElementProvider;
import pl.ioad1.bauhinia.sessionManager.model.Element;


public class ElementEditorCommunicator {
    private ElementProvider elementProvider;
    private ArrayList<Element> elements = new ArrayList<>();

    ArrayList<Element> dowloadList() {
        reloadList();
        return elements;
    }

    Element getElementById(int id) {
        reloadList();
        for (Element element : elements) {
            if (id == element.getId())
                return element;
        }
        return null;
    }

    boolean saveElementChange(Element elementToSave) {
        boolean ret = true;
        try {
            elementProvider.updateElement(elementToSave);
        } catch (ExecutionException e) {
            e.printStackTrace();
            ret = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            ret = false;
        }
        return ret;
    }

    boolean addElement(Element elementToSave) {
        boolean ret = true;
        try {
            elementProvider.sendElement(elementToSave);
        } catch (ExecutionException e) {
            e.printStackTrace();
            ret = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            ret = false;
        } catch (TimeoutException e) {
            e.printStackTrace();
            ret = false;
        }
        return ret;
    }

    private void reloadList() {
        elements.clear();

        for (int i = 1; i < 21; i++)
            elements.add(new Element(i, i, i, "Name" + i, null, i, i));
    }

    public int generateId() {
        int id = 1;
        reloadList();
        while (true) {
            for (Element element : elements) {
                if (id != element.getId())
                    return id;
                id++;
            }
        }

    }
}

