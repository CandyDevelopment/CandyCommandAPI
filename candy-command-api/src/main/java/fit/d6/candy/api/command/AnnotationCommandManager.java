package fit.d6.candy.api.command;

public interface AnnotationCommandManager {

    Command register(Object command);

    Command register(String prefix, Object command);

}
