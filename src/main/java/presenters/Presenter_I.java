package presenters;

public interface Presenter_I {

    // инициализируем нейросеть. Можно вызвать из UI.
    void initialized(int inNeuron, int outNeuron, int[] hideNeuron, int[] biasMap) throws Exception;
    String getAllNeuronLayer();
    public void runMatrixConstructor();
}
