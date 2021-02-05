# Singleton Design Pattern
> _**Singleton Design Pattern, Creational Design Pattern grubunda yer alır.**_
>
> Singleton desgin pattern çalışma zamanında yalnızca 1 object yaratılmasını garanti eden tasarım desenidir.

Kullanımına ihtiyaç duyulan durum şudur :

1. Birden çok sınıfın aynı instance’ı kullanması gerekmektedir.
2. Tüm uygulama için yalnızca bir nesne olması gerekmektedir.
3. Sadece bir nesne olduğu (unique) garanti edilmelidir.

* **Bir sınıfın yalnızca bir instance’ının bulunduğundan emin olmalıyız ve buna global erişim noktası sağlamalıyız.**

&NewLine;

1. ### Eager Initialization

    Bu yaklaşımımızda uygulamamız ayağa kalkarken nesnemiz oluşturulmaktadır.

    ```
    public class SingletonOrnek {

        private static SingletonOrnek nesne = new SingletonOrnek();

        private SingletonOrnek() {
        }

        public static SingletonOrnek getNesne() {
            return nesne;
        }
    }
    ```
    Classımızda oluşan nesnemiz uygulama oluşturulduğunda bir değişken oluşturulur.

&NewLine;

2. ### Static Block Initialization

    Eager Initialization’un aynısı diyebiliriz. Uygulama başladığında nesnemiz oluşturulur ancak burada oluşturulmuş ya da oluşturalacak nesnemiz üzerinde kontrol mekanizması oluşturabiliriz.

      ```
      public class SingletonOrnek {

          private static SingletonOrnek nesne;

          static {
            try {
                nesne= new SingletonOrnek();
                } catch (IOException e) {
                    throw new RuntimeException("Hata", e);
                }
          }

          private SingletonOrnek() {
          }

          public static SingletonOrne getNesne() {
              return nesne;
          }
      }
      ```

      Static bir nesne oluşturarak hata işlemlerini yakalabilmekteyiz.

&NewLine;

3. ### Lazy Initialization

    Bu Singleton Pattern yaklaşımında nesnemiz biz isteğimiz zaman oluşturulmakta ve aynı nesnenin oluşup oluşmadığı kontrol ederek eğer oluşmadıysa nesnenin oluşturulmasını sağlamaktayız.

      ```
      public class SingletonOrnek {

      private static SingletonOrnek nesne;

          private SingletonOrnek() {
          }

          public static SingletonOrnek getNesne() {
            if (null == nesne) {
                nesne= new SingletonOrnek();
            }
            return nesne;
          }
      }
      ```
      Bu sayede “aynı nesnenin ikinci kez” oluşturulmasının da önüne geçiyoruz.

&NewLine;

4.  ### Lazy Initialization ve Double Check Locking

    Uygulamamızda Lazy Initialization yapısı kullanarak bir Singleton Pattern oluşturduk. Uygulamamızda ikinci kez nesnemizin oluşturulmasını engellemek için kontrol mekanizmasını genişlettiğimiz yaklaşımdır.

      ```
      public class DoubleCheckedLocking {

        private volatile static DoubleCheckedLocking nesne;

        private DoubleCheckedLocking() {
              }

        public static DoubleCheckedLocking getNesne() {
          if (nesne== null) {
            synchronized (DoubleCheckedLocking.class) {
              if (nesne == null) {
                nesne = new DoubleCheckedLocking();
              }
            }
          }
          return nesne;
        }
      }
      ```

&NewLine;

 5. ### Bill Pugh Singleton

      Bu yaklaşımda static nested class oluşturarak nesnemizin üretilmesini sağlamaktayız.

      ```
      public class SingletonBillPugh {

          private SingletonBillPugh() {
          }

          private static class SingletonHolder {
              public static final SingletonBillPugh nesne = new SingletonBillPugh();
          }

          public static SingletonBillPugh getInstance() {
              return SingletonHolder.instance;
          }
      }
      ```

&NewLine;

 6. ### Thread Safe Singleton

      Bu yaklaşımda uygulamamıza birden çok aynı anda nesne oluşturulması işleminde aynı anda istek gelse bile sadece birtanesinin işlenmesi sonra diğerini işleme alarak nesnemiz oluştuysa tekrar oluşturulmasını engellemek için yapıtığımız bir Singleton Pattern yaklaşımıdır.

      ```
      public class ThreadSafeSingleton {

          private static ThreadSafeSingleton nesne;

          private ThreadSafeSingleton(){}

          public static synchronized ThreadSafeSingleton getNesne(){

              if(nesne== null){
                  nesne = new ThreadSafeSingleton();
              }
              return nesne;
          }

      }
      ```
      Bu yaklaşımda uygulamamızda bu nesne için oluşturmak isteyen birden fazla isteği synchronized yaparak sıraya sokuyoruz ve oluşmadı ise nesnemizi oluşturuyoruz.

&NewLine;

### Kaynaklar

- https://medium.com/i%CC%87yi-programlama/singleton-design-pattern-nedir-6f9ab8ea2e32

- https://blog.burakkutbay.com/design-patterns-singleton-pattern-nedir.html/
