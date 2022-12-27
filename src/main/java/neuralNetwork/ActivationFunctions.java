package neuralNetwork;

import static java.lang.Math.exp;

public class ActivationFunctions {

    /**
     * @param x значение которое требуется пропустить через функцию активации
     */
    public double logisticF (double x){ // как можно по умолчанию установить эту функции, но иметь возможность изменить?
        return 1 / (1 + exp(-1 * x));
    }

    /**
     * Производная логарифмической функции
     * @param y так как производная вычисляется из результата самой функции, тут ожидается текущее значение нейрона.
     */
    public double derLogisticF(double y){
        return y * (1 - y);
    }
}
