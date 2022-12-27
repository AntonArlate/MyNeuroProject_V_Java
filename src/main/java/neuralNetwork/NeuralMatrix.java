package neuralNetwork;

import java.util.ArrayList;
import java.util.List;

public class NeuralMatrix extends NeuralNet{

    private List<NeuronLayer<Neuron>> allNeuronLayer;
    private List<LinkLayer<NeuronLink>> allLinkLayer;


    /**
     * @param inNeuron
     * @param outNeuron
     * @param hideNeuron
     * @param biasMap
     * @inNeuron Количество входных нейронов
     * @outNeuron Количество выходных нейронов
     * @hideNeuron Схема скрытых слоёв. Один индекс на слой
     * @biasMap Схема присутствия нейрона смещения (0 - нет; 1 - есть). Один индекс на слой
     */
    public NeuralMatrix(int inNeuron, int outNeuron, int[] hideNeuron, int[] biasMap) throws Exception {
        super(inNeuron, outNeuron, hideNeuron, biasMap);

        this.allNeuronLayer = new ArrayList<>();
        this.allLinkLayer = new ArrayList<>();
    }

    public List<NeuronLayer<Neuron>> getAllNeuronLayer() {
        return allNeuronLayer;
    }

    public NeuronLayer<Neuron> getNeuronLayer(int layer) {
        return allNeuronLayer.get(layer);
    }

    public void addNewNeuronLayer() {
        this.allNeuronLayer.add(new NeuronLayer<>());
    }

    public List<LinkLayer<NeuronLink>> getAllLinkLayer() {
        return allLinkLayer;
    }

    public void addNewLinkLayer() {
        this.allLinkLayer.add(new LinkLayer<>());
    }

    public void addNewNeuron(int layer){
        while (allNeuronLayer.size() <= layer){
            addNewNeuronLayer();
        }

        Neuron newNeuron = new Neuron(layer);
        allNeuronLayer.get(layer).add(newNeuron);

        if (layer > 0){
            List<Neuron> allPrevNeuron = allNeuronLayer.get(layer - 1);
            for (Neuron prevNeuron :
                 allPrevNeuron) {
                addNewLink(layer - 1, prevNeuron, newNeuron);
            }
        }

        if (layer < (allNeuronLayer.size() - 1)){
            List<Neuron> allNextNeuron = allNeuronLayer.get(layer + 1);
            for (Neuron nextNeuron :
                    allNextNeuron) {
                addNewLink(layer - 1, newNeuron, nextNeuron);
            }
        }

    }

    public void addNewLink(int layer, Neuron firstN, Neuron SecondN){
        while (allLinkLayer.size() <= layer){
            addNewLinkLayer();
        }
        allLinkLayer.get(layer).add(new NeuronLink(layer, firstN, SecondN));
    }
}

class LinkLayer<NeuronLink> extends ArrayList<NeuronLink> {
//    List<NeuronLink> linkList;
}