package nativeclean;

public class NativeHandler {
    private long nativePtr;

    public NativeHandler(long nativePtr) {
        this.nativePtr = nativePtr;
    }

    private void free() {
        System.out.println("free this native ptr : " + nativePtr);
    }

    @Override
    protected void finalize() throws Throwable {
        free();

    }
}
