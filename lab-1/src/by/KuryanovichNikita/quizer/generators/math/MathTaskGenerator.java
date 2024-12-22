package by.KuryanovichNikita.quizer.generators.math;

import by.KuryanovichNikita.quizer.generators.TaskGenerator;
import by.KuryanovichNikita.quizer.tasks.math.MathTask;

public interface MathTaskGenerator<T extends MathTask> extends TaskGenerator<T> {
    int getMinNumber(); // получить минимальное число
    int getMaxNumber(); // получить максимальное число

    /**
     * @return разница между максимальным и минимальным возможным числом
     */
    default int getDiffNumber(){
        return getMaxNumber() - getMinNumber();
    }
}
