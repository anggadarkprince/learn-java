package com.sketchproject;

import java.util.List;

/**
 * InterfacesChallenge
 * Created by Angga on 24/07/16.
 */
public interface ISaveable {
    List<String> write();

    void read(List<String> savedValues);
}
