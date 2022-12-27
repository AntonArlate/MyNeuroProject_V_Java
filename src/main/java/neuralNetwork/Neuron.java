package neuralNetwork;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    private final int layer;
    private double value;
    private double errorValue;
    private List<NeuronLink> linkPrev;
    private List<NeuronLink> linkNext;
    private int itsBias;

    public Neuron(int layer) {
        this.layer = layer;
        this.value = 1;
        this.errorValue = 1;
        this.linkPrev = new ArrayList<>();
        this.linkNext = new ArrayList<>();
        this.itsBias = 0;
    }

    public int getLayer() {
        return layer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(double errorValue) {
        this.errorValue = errorValue;
    }

    public List<NeuronLink> getLinkPrev() {
        return linkPrev;
    }

    public void addLinkPrev(NeuronLink link) {
        this.linkPrev.add(link);
    }

    public List<NeuronLink> getLinkNext() {
        return linkNext;
    }

    public void addLinkNext(NeuronLink link) {
        this.linkNext.add(link);
    }

    public int getItsBias() {
        return itsBias;
    }

    public void setItsBias(int itsBias) {
        if (itsBias == 0 || itsBias == 1) {
            this.itsBias = itsBias;
        }
    }
}
