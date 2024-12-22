package by.KuryanovichNikita.quizer.generators;

import by.KuryanovichNikita.quizer.exceptions.NotValidGenerator;
import by.KuryanovichNikita.quizer.tasks.Task;

/**
 * Interface, который описывает один генератор заданий
 */
public interface TaskGenerator <T extends Task> {
    /**
     * Возвращает задание. При этом новый объект может не создаваться, если класс задания иммутабельный
     *
     * @return задание
     * @see    Task
     */
    T generate() throws NotValidGenerator;
}
