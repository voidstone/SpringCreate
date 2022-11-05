package org.example;

public class RecommendatorImpl implements Recommendator {
    @InjectProperty
    private String alcohol;
    @Override
    public void recommend() {
        System.out.println("to ptotect from covid-19 drink " + alcohol);
    }
}
