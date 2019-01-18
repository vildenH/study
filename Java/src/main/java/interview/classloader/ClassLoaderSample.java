package interview.classloader;

/**
 * @author wh
 * @date 2019/1/3
 */
public class ClassLoaderSample {

  public static void main(String[] args) {
    ClassLoader loader = ClassLoaderSample.class.getClassLoader();
    while (loader != null) {
      System.out.println(loader.toString());
      loader = loader.getParent();
    }
  }

}
