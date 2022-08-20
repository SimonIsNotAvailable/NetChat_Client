public class Main {
    public static void main(String[] args) {

        // Задача 1: Калькулятор
        Calculator calc = Calculator.instance.get();
        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.divide.apply(a, b);
        calc.println.accept(c);


        // Задача 2: Работяга
        final int ERROR_NUMBER = 33;
        Worker.OnTaskDoneListener listener = System.out::println;
        Worker.OnTaskErrorListener errorNumber = System.out::println;
        Worker worker = new Worker(listener, errorNumber);
        worker.start(ERROR_NUMBER);
    }
}
