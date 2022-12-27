package neuralNetwork;


import java.util.function.Function;

import static java.lang.Math.exp;

abstract class NeuralNet implements NeuralNet_I {
    private int[] neuronScheme; // полная схема нейросети
    private int inNeuron;
    private int outNeuron;
    private int[] hideNeuron;
    private int[] biasMap;



    /**
     * @inNeuron Количество входных нейронов
     * @outNeuron Количество выходных нейронов
     * @hideNeuron Схема скрытых слоёв. Один индекс на слой
     * @biasMap Схема присутствия нейрона смещения (0 - нет; 1 - есть). Один индекс на слой
     */
    public NeuralNet(int inNeuron, int outNeuron, int[] hideNeuron, int[] biasMap) throws Exception {
        if (biasMap.length != (hideNeuron.length + 2)){
            throw new Exception("длина biasMap != neuronScheme продолжение генерации невозможно");
        }

        this.inNeuron = inNeuron;
        this.outNeuron = outNeuron;
        this.hideNeuron = hideNeuron;
        this.biasMap = biasMap;

        this.neuronSchemeConstruct();


    }

    private void neuronSchemeConstruct(){
        this.neuronScheme = new int[this.hideNeuron.length + 2];
        this.neuronScheme[0] = this.inNeuron + this.biasMap[0];
        for (int i = 1; i < this.neuronScheme.length - 1; i++) {
            this.neuronScheme [i] = this.hideNeuron [i-1] + this.biasMap[i];
        }
        this.neuronScheme[this.neuronScheme.length - 1] = this.outNeuron + this.biasMap[this.neuronScheme.length - 1];
    }



    public int[] getNeuronScheme() {
        return neuronScheme;
    }

    public void setNeuronScheme(int[] neuronScheme) {
        this.neuronScheme = neuronScheme;
    }

    public int getInNeuron() {
        return inNeuron;
    }

    public void setInNeuron(int inNeuron) {
        this.inNeuron = inNeuron;
        this.neuronSchemeConstruct();
    }

    public int getOutNeuron() {
        return outNeuron;
    }

    public void setOutNeuron(int outNeuron) {
        this.outNeuron = outNeuron;
        this.neuronSchemeConstruct();
    }

    public int[] getHideNeuron() {
        return hideNeuron;
    }

    public void setHideNeuron(int[] hideNeuron) throws Exception {
        if (this.hideNeuron.length != (hideNeuron.length)){
            throw new Exception("Количество слоёв изменилось. Для данного действия рекомендуется пересоздать схему заново");
        }
        this.hideNeuron = hideNeuron;
        this.neuronSchemeConstruct();
    }

    public int[] getBiasMap() {
        return biasMap;
    }

    public void setBiasMap(int[] biasMap) throws Exception {
        if (this.biasMap.length != (hideNeuron.length)){
            throw new Exception("Количество слоёв изменилось. Для данного действия рекомендуется пересоздать схему заново");
        }
        this.biasMap = biasMap;
        this.neuronSchemeConstruct();
    }
}

