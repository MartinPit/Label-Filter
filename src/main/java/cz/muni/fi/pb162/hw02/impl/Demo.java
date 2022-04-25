package cz.muni.fi.pb162.hw02.impl;


import cz.muni.fi.pb162.hw02.HasLabels;
import cz.muni.fi.pb162.hw02.LabelFilter;
import cz.muni.fi.pb162.hw02.LabelMatcher;

import java.util.List;

import static cz.muni.fi.pb162.hw02.impl.data.Articles.*;

/**
 * @author Martin Oliver Pitonak
 */
public class Demo {

    /**
     * Tests
     * @param args cmd args
     */
    public static void main(String[] args) {
        Parser parser = new Parser(" nice  | shit &  !!  bro| bge&wwc   ");
        parser.parse();
    }
}
