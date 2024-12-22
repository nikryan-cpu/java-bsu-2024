package by.KuryanovichNikita.quizer.generators;

import by.KuryanovichNikita.quizer.exceptions.GroupGeneratorException;
import by.KuryanovichNikita.quizer.exceptions.NotValidGenerator;
import by.KuryanovichNikita.quizer.tasks.Task;

import java.util.*;

public class GroupTaskGenerator implements TaskGenerator<Task> {
    private final List<TaskGenerator<? extends Task>> listGenerators; //list всех generators
    /**
     * Конструктор с переменным числом аргументов
     *
     * @param generators генераторы, которые в конструктор передаются через запятую
     */
    @SafeVarargs
    public GroupTaskGenerator(TaskGenerator<? extends Task>... generators) {

        listGenerators = Arrays.asList(generators);
    }

    /**
     * Конструктор, который принимает коллекцию генераторов
     *
     * @param generators генераторы, которые передаются в конструктор в Collection (например, {@link ArrayList})
     */
    GroupTaskGenerator(Collection<? extends TaskGenerator<? extends Task>> generators) {
        listGenerators = new ArrayList<>(generators);
    }


    /**
     * @return результат метода generate() случайного генератора из списка.
     *         Если этот генератор выбросил исключение в методе generate(), выбирается другой.
     *         Если все генераторы выбрасывают исключение, то и тут выбрасывается исключение.
     */
    public Task generate() throws NotValidGenerator {
        Random rand = new Random();
        if(listGenerators.isEmpty()){
            throw new GroupGeneratorException("No available generators to make GroupGenerator");
        }
        int myRandomGeneratorIndex = rand.nextInt(listGenerators.size());
        TaskGenerator<? extends Task> myRandomGenerator = listGenerators.get(myRandomGeneratorIndex);
        try{
            return myRandomGenerator.generate();
        }
        catch(RuntimeException e){
            listGenerators.remove(myRandomGeneratorIndex);
            return generate();
        }
    }
}
