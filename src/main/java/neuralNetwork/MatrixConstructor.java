package neuralNetwork;

public class MatrixConstructor implements MatrixConstructor_I{
    public void MatrixConstruction(NeuralNet_I matrix) {
        int[] neuronScheme = matrix.getNeuronScheme();
        int[] biasScheme = matrix.getBiasMap();

        for (int layer = 0; layer < neuronScheme.length; layer++) {
            for (int i = 0; i < neuronScheme[layer]; i++) {
                matrix.addNewNeuron(layer);
            }
            if (biasScheme[layer] == 1) {
                matrix.getNeuronLayer(layer).get(0).setItsBias(1);
            }
        }
    }
}
