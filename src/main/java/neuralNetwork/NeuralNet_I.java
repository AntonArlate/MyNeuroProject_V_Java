package neuralNetwork;

import java.util.List;

public interface NeuralNet_I {
    int[] getNeuronScheme();
    int[] getBiasMap();
    void addNewNeuron(int layer);
    List<NeuronLayer<Neuron>> getAllNeuronLayer();
    NeuronLayer<Neuron> getNeuronLayer(int layer);
}
