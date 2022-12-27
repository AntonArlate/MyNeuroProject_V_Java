package presenters;

import neuralNetwork.MatrixConstructor;
import neuralNetwork.MatrixConstructor_I;
import neuralNetwork.NeuralMatrix;
import neuralNetwork.NeuralNet_I;


public class Presenter implements Presenter_I {
    NeuralNet_I neuralNet;
    MatrixConstructor_I matrixConstructor;

    public Presenter() {
        this.matrixConstructor = new MatrixConstructor();
    }

    public void initialized(int inNeuron, int outNeuron, int[] hideNeuron, int[] biasMap) throws Exception {
        neuralNet = new NeuralMatrix(inNeuron, outNeuron, hideNeuron, biasMap);
    }

    public void runMatrixConstructor(){
        matrixConstructor.MatrixConstruction(neuralNet);
    }

    public String getAllNeuronLayer(){ // где лучше парсить в строку? Ведь тотже метод может быть нужен для передачи самих ссылок
        return neuralNet.getAllNeuronLayer().toString();
    }
}
