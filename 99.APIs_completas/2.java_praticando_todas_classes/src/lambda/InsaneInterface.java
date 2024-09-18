package lambda;
import java.util.List;

@FunctionalInterface
public interface InsaneInterface <T>{
    
    public void  printAll(List<T> listaInsana);
}
