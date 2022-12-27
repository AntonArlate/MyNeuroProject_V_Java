import presenters.Presenter;
import presenters.Presenter_I;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");

        // инициализация презентера
        Presenter_I presenter = new Presenter();
        //запуск процеса
        not_thread_runner(presenter);

        System.out.println(presenter.getAllNeuronLayer());


    }

    // без потоковый вариант. Нейросетью управляет UI
    private static void not_thread_runner(Presenter_I presenter){
        TestData testData = new TestData();

        try {
            presenter.initialized(testData.inNeuron, testData.outNeuron, testData.hideNeuron, testData.biasMap);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        presenter.runMatrixConstructor();

    }

    // Вариант с независимым потоком. UI только сканирует данные и отправляет команды прерывания.
    private static void thread_runner(){
    }


}

class TestData{
    int inNeuron = 4;
    int outNeuron = 6;
    int[] hideNeuron = {3, 4};
    int[] biasMap = {1,1,1,0};
}