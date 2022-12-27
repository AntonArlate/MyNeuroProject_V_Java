package neuralNetwork;

import static java.lang.Math.exp;

public class ActivationFunctions {

    /**
     * @param x �������� ������� ��������� ���������� ����� ������� ���������
     */
    public double logisticF (double x){ // ��� ����� �� ��������� ���������� ��� �������, �� ����� ����������� ��������?
        return 1 / (1 + exp(-1 * x));
    }

    /**
     * ����������� ��������������� �������
     * @param y ��� ��� ����������� ����������� �� ���������� ����� �������, ��� ��������� ������� �������� �������.
     */
    public double derLogisticF(double y){
        return y * (1 - y);
    }
}
