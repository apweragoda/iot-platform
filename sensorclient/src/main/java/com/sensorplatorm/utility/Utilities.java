package com.sensorplatorm.utility;

import org.springframework.ui.Model;

public class Utilities {

    //util method for injecting a single data instance to the model instance
    public static void collectionModelUtil(Model model, String identifier, Object object) {
        model.addAttribute(identifier, object);
    }

    //util method for injecting list to a model instance
    public static void collectionModelUtil(Model model, String identifier, Iterable<?> list) {
        model.addAttribute(identifier, list);
    }
}
