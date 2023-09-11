package nativeclean;

import java.lang.ref.Cleaner;

public class CleaningExample implements AutoCloseable {
    // A cleaner, preferably one shared within a library
    private static final Cleaner cleaner = Cleaner.create();
    private long nativePtr;

    static class State implements Runnable {

        private long nativePtr;

        State(long nativePtr) {
            // initialize State needed for cleaning action
            this.nativePtr = nativePtr;
        }

        public void run() {
            // cleanup action accessing State, executed at most once
            System.out.println("free native ptr : " + nativePtr);
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public CleaningExample() {
        this.state = new State(123l);
        this.cleanable = cleaner.register(this, state);
    }

    public void close() {
        cleanable.clean();
    }
}

