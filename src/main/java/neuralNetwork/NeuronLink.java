package neuralNetwork;

public class NeuronLink {
    private int linkLayer;
    private double value;
    private Neuron firstNeuron;
    private Neuron secondNeuron;

    public NeuronLink(int linkLayer, Neuron firstNeuron, Neuron secondNeuron) {
        this.linkLayer = linkLayer;
        this.value = 1;
        this.firstNeuron = firstNeuron;
        this.secondNeuron = secondNeuron;

        firstNeuron.addLinkNext(this);
        secondNeuron.addLinkPrev(this);
    }
}
