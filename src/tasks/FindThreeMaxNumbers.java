package tasks;

import java.util.Arrays;

public class FindThreeMaxNumbers {

    public static void main(String[] args) {
        String sequence = "-8 -55 -33 -1 -9 -37 -22 22 6 2 4 1 6 7 50";
        int[] numbers = convertStringToArray(sequence);

        int[] maxProductNumbers = findMaxProductNumbers(numbers);

        System.out.println("��� ����� � ������������ �������������: " + maxProductNumbers[0]+", "+maxProductNumbers[1] + " � " + maxProductNumbers[2]);
    }

    // �������� ������ � ������� �����
    private static int[] convertStringToArray(String sequence) {
        String[] numbersString = sequence.split(" ");
        int[] numbers = new int[numbersString.length];

        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        return numbers;
    }

    // ������� ��� ����� � ������������ �������������
    private static int[] findMaxProductNumbers(int[] numbers) {
        Arrays.sort(numbers); // ��������� ������ �� �����������

        int length = numbers.length;

        // ��������� ��� ������:
        //              1) ��� ����������� ����� ��������� �� ������������
        //              2) ��� ������������
        // ��� ������� ������ ����� ������� ��� ����� ��������� ����� � ����� �������
        // ��� ������� ������ ����� ������� ��� ����� ������� �����
        int caseOne = numbers[0] * numbers[1] * numbers[length - 1];
        int caseTwo = numbers[0] * numbers[length - 1] * numbers[length - 2];

        if (caseOne > caseTwo) {
            return new int[]{ numbers[0], numbers[1], numbers[length - 1] };
        } else
            return new int[]{ numbers[0], numbers[length - 1], numbers[length - 2] };
    }
}
