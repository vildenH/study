package observer.methodA;

/**
 * @author wh
 * @date 2018/3/13
 */
//对于观察者模式的主要抽象
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
