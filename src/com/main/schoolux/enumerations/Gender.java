package com.main.schoolux.enumerations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Gender {

    MASCULIN,
    FEMININ,
    NEUTRE,
    PERSONNALISE;


    public static List<String> properties() {

        List<Gender> genderList = Arrays.asList(Gender.values());
        List<String> genderListString = new ArrayList<>();

        for (Gender genderItem : genderList) {
            genderListString.add(genderItem.name().replace("_", " "));
        }

        return genderListString;




    }




}
